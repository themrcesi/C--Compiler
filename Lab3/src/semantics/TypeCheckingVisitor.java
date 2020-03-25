package semantics;

import ast.definitions.FunctionDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    //##########################################DEFINITIONS####################################################
    @Override
    public Void visit(FunctionDefinition funcDef, Type params) {
        funcDef.getType().accept(this, funcDef.getType().getReturnType());
        for (Statement st : funcDef.getBody())
        {
            st.accept(this, funcDef.getType().getReturnType());
        }
        return null;
    }

    //##########################################STATEMENTS######################################################

    @Override
    public Void visit(Return returnSt, Type param)
    {
        returnSt.getReturned().accept(this, param);
        if(!returnSt.getReturned().getType().equals(param))
            new ErrorType(returnSt.getLine(), returnSt.getColumn(), "Returned "+returnSt.getReturned().getType().toString() + " when expecting "+param.toString());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Type param)
    {
        assignment.getLeftEx().accept(this, param);
        assignment.getRightEx().accept(this, param);
        if(!assignment.getLeftEx().isLValue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "LValue required");

        if (!(assignment.getLeftEx().getType() instanceof ErrorType)
                && !(assignment.getRightEx().getType() instanceof ErrorType)) {
            if (!assignment.getLeftEx().getType().isAssignable(assignment.getRightEx().getType())) {
                new ErrorType(assignment.getLine(), assignment.getColumn(), "Both parts of the assignment must be equal, trying to assign a "+assignment.getRightEx().getType()+" to a "+assignment.getLeftEx().getType());
            }
        }
        return null;
    }

    @Override
    public Void visit(Read read, Type param)
    {
        read.getExpression().accept(this, param);
        if(!read.getExpression().isLValue())
            new ErrorType(read.getLine(), read.getColumn(), "LValue required");
        return null;
    }

    @Override
    public Void visit(While whileSt, Type params)
    {
        whileSt.getCondition().accept(this, params);
        whileSt.getBody().forEach(st -> st.accept(this, params));

        if(!whileSt.getCondition().getType().isBoolean())
            new ErrorType(whileSt.getLine(), whileSt.getColumn(), "Condition of a while must be boolean");

        return null;
    }

    @Override
    public Void visit(If ifSt, Type param)
    {
        ifSt.getCondition().accept(this, param);
        ifSt.getIfStatements().forEach(st -> st.accept(this, param));
        ifSt.getElseStatements().forEach(st -> st.accept(this, param));

        if(!ifSt.getCondition().getType().isBoolean())
            new ErrorType(ifSt.getLine(), ifSt.getColumn(), "Condition of an if must be boolean");

        return null;
    }

    public Void visit(Write write, Type param)
    {
        write.getExpression().accept(this, param);

        if(write.getExpression().getType().isWritable())
            new ErrorType(write.getLine(), write.getColumn(), "Expression of a write must be writable");

        return null;
    }

    //#######################################EXPRESSIONS#####################################

    @Override
    public Void visit(Invocation invocation, Type params)
    {
        invocation.getName().accept(this, params);
        invocation.getArguments().forEach(expression -> expression.accept(this, params));
        //lvalue
        invocation.setLValue(false);
        //set type
        invocation.setType(invocation.getName().getType().parenthesis(invocation.getArguments(), invocation));
        return null;
    }

    @Override
    public Void visit(Access access, Type params)
    {
        access.getAccess().accept(this, params);
        //lvalue
        access.setLValue(true);
        //set type
        access.setType(access.getAccess().getType().dot(access.getMember(), access));
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Type params)
    {
        arithmetic.getExprLeft().accept(this, params);
        arithmetic.getExprRight().accept(this, params);
        //lvalue
        arithmetic.setLValue(false);
        //set type
        arithmetic.setType(arithmetic.getExprLeft().getType().arithmetic(arithmetic.getExprRight().getType(), arithmetic));
        return null;
    }

    @Override
    public Void visit(Cast cast, Type params)
    {
        cast.getCastType().accept(this, params);
        cast.getExpression().accept(this, params);
        //lvalue
        cast.setLValue(false);
        //set type
        cast.setType(cast.getExpression().getType().cast(cast.getCastType()));
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Type params)
    {
        //lvalue
        charLiteral.setLValue(false);
        //set type
        charLiteral.setType(new CharType(charLiteral.getLine(), charLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(Comparisson comparisson, Type params)
    {
        comparisson.getExprLeft().accept(this, params);
        comparisson.getExprRight().accept(this, params);
        //lvalue
        comparisson.setLValue(false);
        //set type
        comparisson.setType(comparisson.getExprLeft().getType().comparisson(comparisson.getExprRight().getType()));
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Type params)
    {
        //lvalue
        doubleLiteral.setLValue(false);
        //set type
        doubleLiteral.setType(new DoubleType(doubleLiteral.getLine(),doubleLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Type params)
    {
        indexing.getExprLeft().accept(this, params);
        indexing.getExprRight().accept(this, params);
        //lvalue
        indexing.setLValue(true);
        //set type
        indexing.setType(indexing.getExprLeft().getType().squareBrackets(indexing.getExprRight().getType(), indexing));
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Type params)
    {
        //lvalue
        intLiteral.setLValue(false);
        //type
        intLiteral.setType(new IntType(intLiteral.getLine(),intLiteral.getColumn()));
        return null;
    }

    public Void visit(Logical logical, Type params)
    {
        logical.getExprLeft().accept(this, params);
        logical.getExprRight().accept(this, params);
        //lvalue
        logical.setLValue(false);
        //set type
        logical.setType(logical.getExprLeft().getType().logical(logical.getExprRight().getType(), logical));
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Type params)
    {
        unaryMinus.getExpr().accept(this, params);
        //lvalue
        unaryMinus.setLValue(false);
        //type
        unaryMinus.setType(unaryMinus.getExpr().getType().unaryMinus(unaryMinus));
        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Type params)
    {
        unaryNot.getExpr().accept(this, params);
        //lvalue
        unaryNot.setLValue(false);
        //set type
        unaryNot.setType(unaryNot.getExpr().getType().unaryNot(unaryNot));
        return null;
    }

    @Override
    public Void visit(Variable variable, Type params)
    {
        //lvalue
        variable.setLValue(true);
        //setting type
        if (variable.getDefinition().equals(null)) {
            variable.setType(new ErrorType(variable.getLine(), variable.getColumn(), "Variable " + variable.getName() + " has no definition."));
        } else {
            variable.setType(variable.getDefinition().getType());
        }
        return null;
    }

}
