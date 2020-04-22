package codeGeneration;

import ast.expressions.*;
import ast.statements.Invocation;

public class ValueCGVisitor extends AbstractCGVisitor<Void,Void> {

    private CodeGeneration cg;
    private AddressCGVisitor av;

    public ValueCGVisitor(CodeGeneration cg)
    {
        this.cg = cg;
    }

    public void setAddressVisitor(AddressCGVisitor vv)
    {
        this.av=vv;
    }


    //################################CONSTANTS###################################
    @Override
    /*
    value[[CharLiteral: exp -> CHAR_CONSTANT]] =
        <push>exp.type.suffix()< >(int)exp.value
    */
    public Void visit(CharLiteral charLiteral, Void params) {
        cg.push(charLiteral.getType(), (int) charLiteral.getValue());
        return null;
    }

    @Override
    /*
    value[[IntLiteral: exp -> INT_CONSTANT]] =
        <push>exp.type.suffix()< >exp.value
    */
    public Void visit(IntLiteral intLiteral, Void params) {
        cg.push(intLiteral.getType(), intLiteral.getValue());
        return null;
    }

    @Override
    /*
    value[[DoubleLiteral: exp -> DOUBLE_CONSTANT]] =
        <push>exp.type.suffix()< >exp.value
    */
    public Void visit(DoubleLiteral doubleLiteral, Void params) {
        cg.push(doubleLiteral.getType(), doubleLiteral.getValue());
        return null;
    }

    //################################VARIABLE###################################
    @Override
    /*
    value[[Variable: exp -> ID]] =
        address[[exp]]
        <load> exp.type.suffix()
    */
    public Void visit(Variable variable, Void params) {
        variable.accept(this.av, params);
        cg.load(variable.getType());
        return null;
    }

    @Override
    /*
    ####################################CAST##################################
    value[[Cast: exp1 -> type exp2]] =
        value[[exp2]]
        exp2.type.convertTo(exp1.type)
    */
    public Void visit(Cast cast, Void params) {
        cast.getExpression().accept(this, params);
        cg.convertTo(cast.getExpression().getType(), cast.getType());
        return null;
    }

    /*
    #############################ARITHMETIC OPERATION#########################
    value[[Arithmetic: exp1 -> exp2 (+|-|*|/) exp3]] =
        value[[exp2]]
        exp2.type.convertTo(exp1.type)  // cg.cast(exp2.type,exp1.type)
        value[[exp3]]
        exp3.type.convertTo(exp1.type)  // cg.cast(exp3.type,exp1.type)
        switch(exp1.operator) {                         cg.arithmetic(exp1.operator, exp1.type)
            case "+": <add> exp1.type.suffix() break;
            case "-": <add> exp1.type.suffix() break;
            case "*": <add> exp1.type.suffix() break;
            case "/": <add> exp1.type.suffix() break;
        }
     */
    @Override
    public Void visit(Arithmetic arithmetic, Void params) {
        arithmetic.getExprLeft().accept(this, params);
        cg.convertTo(arithmetic.getExprLeft().getType(), arithmetic.getType());
        arithmetic.getExprRight().accept(this, params);
        cg.convertTo(arithmetic.getExprLeft().getType(), arithmetic.getType());
        cg.arithmetic(arithmetic.getOperator(), arithmetic.getType());
        return null;
    }

    /*
    #############################COMPARISON OPERATION#########################
    value[[Comparisson: exp1 -> exp2 (>|<|>=|<=|!=|==) exp3]] =
        value[[exp2]]
        value[[exp3]]
        switch(exp1.operator) {     cg.comparison(exp1.operator)
            case ">": <gt> exp1.type.suffix() break;
            case "<": <lt> exp1.type.suffix() break;
            case ">=": <ge> exp1.type.suffix() break;
            case "<=": <le> exp1.type.suffix() break;
            case "==": <eq> exp1.type.suffix() break;
            case "!=": <ne> exp1.type.suffix() break;
        }
     */

    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        unaryNot.getExpr().accept(this, null);
        cg.not();
        return null;
    }

    @Override
    public Void visit(UnaryMinus um, Void param) {
        cg.push(um.getType(), 0);
        um.getExpr().accept(this, null);
        cg.sub(um.getType());
        return null;
    }

    @Override
    public Void visit(Comparisson comparisson, Void params) {
        comparisson.getExprLeft().accept(this, params);
        comparisson.getExprRight().accept(this, params);
        cg.comparisson(comparisson.getOperand(), comparisson.getType());
        return null;
    }

    /*
    value[[Logical: exp1 -> exp2 (&&|||) exp3]] =
        value[[exp2]]
        value[[exp3]]
        switch(exp1.operator) {         cg.logical(exp1.operator)
            case "&&": <and> break;
            case "||": <or>  break;
        }
     */
    @Override
    public Void visit(Logical logical, Void params) {
        logical.getExprLeft().accept(this, params);
        logical.getExprRight().accept(this, params);
        cg.logical(logical.getOperand());
        return null;
    }

    /*
    value[[Invocation: exp1 -> exp2 exp3*]] =
        exp3*.forEach(exp -> value[[exp]])  //pushing params
        <call > exp2.name
     */
    @Override
    public Void visit(Invocation invocation, Void params)
    {
        invocation.getArguments().forEach(argument -> argument.accept(this, null));
        cg.call(invocation.getName().getName());
        return null;
    }

    /*
    value[[Indexing: exp1 -> exp2 exp3]] =
        address[[exp1]]
        <load> exp1.type.suffix()
     */
    @Override
    public Void visit(Indexing indexing, Void params)
    {
        indexing.accept(this.av, null);
        cg.load(indexing.getType());
        return null;
    }

    /*
    value[[Access: exp1 -> exp2 ID]]=
        address[[exp1]]
        <load> exp1.type.suffix()
     */
    @Override
    public Void visit(Access access, Void params) {
        access.accept(this.av, null);
        cg.load(access.getType());
        return null;
    }
}
