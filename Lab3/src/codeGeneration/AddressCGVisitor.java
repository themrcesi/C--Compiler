package codeGeneration;

import ast.definitions.VarDefinition;
import ast.expressions.Access;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.types.RecordType;

public class AddressCGVisitor extends AbstractCGVisitor<Void,Void> {

    private CodeGeneration cg;
    private ValueCGVisitor vv;

    public AddressCGVisitor(CodeGeneration cg)
    {
        this.cg = cg;
    }

    public void setValueVisitor(ValueCGVisitor vv) {
        this.vv = vv;
    }

    //################################VARIABLE##################################
    @Override
    /*
        address[[Variable: exp -> ID]] =
            if(exp.definition.scope==0)         // this is global
		        <pusha > exp.definition.offset
	        else {                              // this is local
	            <push bp>
		        <pusha > exp.definition.offset
		        <addi>
            }
        */
    public Void visit(Variable variable, Void params) {
        if(variable.getDefinition().getScope()==0) //GLOBAL
            cg.pusha(((VarDefinition)variable.getDefinition()).getOffset());
        else
        {
            cg.pushbp();
            cg.pushi(((VarDefinition)variable.getDefinition()).getOffset());
            cg.addi();
        }
        return null;
    }

    /*
    address[[Indexing: exp1 -> exp2 exp3]] =
        address[[exp2]] //base address
        value[[exp3]]   //index
        <pushi > exp1.type.numberOfBytes()   // nob of array type
        <muli>
        <addi>
     */

    @Override
    public Void visit(Indexing indexing, Void params) {
        indexing.getExprLeft().accept(this, null);
        indexing.getExprRight().accept(this.vv, null);
        cg.pushi(indexing.getType().numberOfBytes());
        cg.muli();
        cg.addi();
        return null;
    }


    /*
    address[[Access: exp1 -> exp2 ID]] =
        address[[exp2]]
        <pushi > exp2.getType().getField(exp1.member).offset
        <addi>
     */
    @Override
    public Void visit(Access access, Void params)
    {
        access.getAccess().accept(this, null);
        cg.pushi(((RecordType)access.getAccess().getType()).getField(access.getMember()).getOffset());
        cg.addi();
        return null;
    }

}
