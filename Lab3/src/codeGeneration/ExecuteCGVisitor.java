package codeGeneration;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

import java.util.ArrayList;

public class ExecuteCGVisitor extends AbstractCGVisitor<int[],Void> {

    private CodeGeneration cg;
    private AddressCGVisitor av;
    private ValueCGVisitor vv;

    public ExecuteCGVisitor(CodeGeneration cg, AddressCGVisitor av, ValueCGVisitor vv)
    {
        this.cg = cg;
        this.av = av;
        this.vv = vv;
    }

        /*
        ###################################READ#####################################
        execute[[Read: st -> exp]] =
            address[[exp]]
            <in> exp.type.suffix()
            <store> exp.type.suffix()
        */
    @Override
    public Void visit(Read read, int[] params) {
        cg.printComment("\t' * Read");
        read.getExpression().accept(this.av, null);
        cg.in(read.getExpression().getType());
        cg.store(read.getExpression().getType());
        return null;
    }
    /*
        ##################################WRITE#####################################
        execute[[Write: st -> exp]] =
            value[[exp]]
            <out> exp.type.suffix()
        */
    @Override
    public Void visit(Write write, int[] params) {
        cg.printComment("\t' * Write");
        write.getExpression().accept(this.vv, null);
        cg.out(write.getExpression().getType());
        return null;
    }
    /*
        #############################ASSIGNMENT####################################
        execute[[Assignment: st -> exp1 exp2]] =
            address[[exp1]]
            value[[exp2]]
            <store> exp1.type.suffix()
        */
    @Override
    public Void visit(Assignment assignment, int[] params) {
        assignment.getLeftEx().accept(this.av, null);
        assignment.getRightEx().accept(this.vv, null);
        cg.store(assignment.getLeftEx().getType());
        return null;
    }

    /*
        #####################################VAR DEFINITIONS######################
        execute[[VarDefinition: varDefinition -> type ID]] =
	        <' * > type.toString() ID <( offset > varDefinition.offset <)>
         */
    @Override
    public Void visit(VarDefinition vDef, int[] params)
    {
        cg.printComment("\t' * "+vDef.getType().toString()+" "+vDef.getName()+" (offset "+vDef.getOffset()+")");
        return null;
    }

        /*
        #####################################FUNC DEFINITIONS######################
        execute[[FuncDefinition: funcDefinition -> type ID varDefinition* statement*]] =
            ID<:>
            execute[[type]]
            <' * Local variables:>
            varDefinition*.foreach(vd -> execute[[vd]]())

            int bytesParams = 0;
            for(VarDefinition vd: type.parameters)
                bytesParams += vd.type.numberOfBytes()

            int bytesLocals = 0;
            if(varDefinition*.size()>0)
                bytesLocals = -varDefinition*.get(varDefinition*.size()-1).offset
            <enter > bytesLocals

            int bytesReturn = type.returnType.numberOfBytes();

            statement*.foreach(st -> execute[[st]](bytesLocals, bytesParams, bytesReturn))

            if(bytesReturn==0) //no return
                <ret > bytesReturn, bytesLocals, bytesParams
         */

    @Override
    public Void visit(FunctionDefinition funcDef, int[] params) {
        cg.printComment(" "+funcDef.getName()+":");

        funcDef.getType().accept(this, params); //parameters

        cg.printComment("\t' * Local variables");
        funcDef.getBody().forEach(st -> {
            if(st instanceof VarDefinition)
                st.accept(this, params);
        });

        int byteParams = getParamsBytes(funcDef);
        int byteLocals = getLocalsBytes(funcDef.getBody());

        cg.enter(byteLocals);

        int bytesReturn = getBytesReturn(funcDef);

        funcDef.getBody().forEach(st -> {
            if(!(st instanceof VarDefinition))
            {
                cg.line(st.getLine());
                st.accept(this, new int[]{byteLocals,byteParams,bytesReturn});
                cg.printComment("");
            }
        });

        if(bytesReturn==0)
            cg.ret(bytesReturn,byteLocals,byteParams);

        return null;
    }

    private int getBytesReturn(FunctionDefinition funcDef) {

        return funcDef.getType().getReturnType() instanceof VoidType? 0: funcDef.getType().getReturnType().numberOfBytes();
    }

    private int getLocalsBytes(ArrayList<Statement> body) {
        int byteParams = 0;
        for(Statement st: body)
        {
            if(st instanceof VarDefinition)
                byteParams += ((VarDefinition) st).getType().numberOfBytes();
        }
        return byteParams;
    }

    private int getParamsBytes(FunctionDefinition funcDef) {
        int byteParams = 0;
        for (VarDefinition param: funcDef.getType().getParameters())
        {
            byteParams += param.getType().numberOfBytes();
        }
        return byteParams;
    }
        /*
        execute [[FuncType : type1 -> type2 varDefinition*]] =
            <' * Parameters:>
            varDefinition*.forEach(vd -> {
                execute[[vd]]()
            })
        */
    @Override
    public Void visit(FunctionType funcType, int[] params) {
        cg.printComment("\t' * Parameters");
        funcType.getParameters().forEach(vd -> vd.accept(this, params));
        return null;
    }

    /*
        ###############################################PROGRAM#########################################
        execute[[Program: program -> varDefinition* funcDefinition*]] =
            < ' * Global variables:>
            varDefinition.forEach(vd -> execute[[vd]]())

            <call main>
            <halt>

            funcDefinition*.forEach(fd -> execute[[fd]]())
         */

    @Override
    public Void visit(Program program, int[] params) {
        cg.source();

        cg.printComment("\t' * Global variables");
        program.getDefs().forEach(def -> {
            if(def instanceof VarDefinition)
                def.accept(this, null);
        });

        cg.printComment("' Invocation of the main function");
        cg.call("main");
        cg.halt();

        program.getDefs().forEach(def -> {
            if(def instanceof FunctionDefinition)
                def.accept(this, null);
        });
        return null;
    }

    /*
        execute[[Return: statement -> expression]](int bytesLocals, int byteParams, int bytesReturn) =
            value[[exp]]
            <ret > bytesReturn, bytesLocals, bytesParams
         */
    @Override
    public Void visit(Return returnStatement, int[] params) {
        cg.printComment("\t' * Return");
        var returned = params;
        returnStatement.getReturned().accept(this.vv, null);
        cg.ret(returned[2], returned[0], returned[1]);
        return null;
    }

    /*
    execute[[Invocation: st -> exp expression*]] =
        expression*.forEach(exp -> value[[exp]])
        <call > exp.name
        if(!(exp.type.returnType instanceOf VoidType)) //return type is Void
            <pop> exp.type.returnType.suffix()
     */

    @Override
    public Void visit(Invocation invocation, int[] params) {
        invocation.getArguments().forEach(param -> param.accept(this.vv, null));
        cg.call(invocation.getName().getName());
        if(!(((FunctionType)invocation.getName().getType()).getReturnType() instanceof VoidType))
            cg.pop(((FunctionType) invocation.getName().getType()).getReturnType());
        return null;
    }
    /*
    execute[[If: st1 -> exp st2+ st3*]] =
        int labelNumber = cg.getLabels(2);
        value[[exp]]    //evaluate condition
        <jz label> labelNumber  //go to else branch
        st2+.forEach(st -> execute[[st]])
        <jmp label> labelNumber+1   //go to end
        <label>labelNumber<:>
        st3*.forEach(st -> execute[[st]])
        <label>labelNumber+1<:>
     */

    @Override
    public Void visit(If ifelse, int[] params) {
        cg.printComment("\t' * If statement");
        int labelNumber = cg.getLabels(2);
        ifelse.getCondition().accept(this.vv, null);
        cg.jz(labelNumber);
        cg.printComment("\t' * Body of the if branch");
        ifelse.getIfStatements().forEach(st -> {
            cg.line(st.getLine());
            st.accept(this, params);
        });
        cg.jmp(labelNumber+1);
        cg.label(labelNumber);
        cg.printComment("\t' * Body of the else branch");
        ifelse.getElseStatements().forEach(st -> {
            cg.line(st.getLine());
            st.accept(this, params);
        });
        cg.label(labelNumber+1);
        return null;
    }
    /*
    execute[[While: st1 -> exp st2*]] =
        int labelNumber = cg.getLabels(2)
        <label> labelNumber <:>
        value[[exp]]    //evaluate condition
        <jz label> labelNumber+1    //go to end
        st2*.forEach(st -> execute[[st]]
        <jmp label> labelNumber     //go to beginning
        <label> labelNumber+1 <:>
     */

    @Override
    public Void visit(While whileStatement, int[] params) {
        cg.printComment("\t ' * While");
        int labelNumber = cg.getLabels(2);
        cg.label(labelNumber);
        whileStatement.getCondition().accept(this.vv, null);
        cg.jz(labelNumber+1);
        cg.printComment("\t' * Body of the while statement");
        whileStatement.getBody().forEach(st -> {
            cg.line(st.getLine());
            st.accept(this, params);
        });
        cg.jmp(labelNumber);
        cg.label(labelNumber+1);
        return null;
    }
}
