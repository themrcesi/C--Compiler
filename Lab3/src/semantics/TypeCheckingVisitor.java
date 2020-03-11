package semantics;

import ast.expressions.*;
import ast.statements.Assignment;
import ast.statements.Invocation;
import ast.statements.Read;
import ast.types.ErrorType;
import visitor.AbstractVisitor;
import visitor.Visitor;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(Assignment assignment, Void param)
    {
        assignment.getLeftEx().accept(this, param);
        assignment.getRightEx().accept(this, param);
        if(!assignment.getLeftEx().isLValue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "LValue required");
        return null;
    }

    @Override
    public Void visit(Read read, Void param)
    {
        read.getExpression().accept(this, param);
        if(!read.getExpression().isLValue())
            new ErrorType(read.getLine(), read.getColumn(), "LValue required");
        return null;
    }

    @Override
    public Void visit(Access access, Void params)
    {
        access.getAccess().accept(this, params);
        access.setLValue(true);
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void params)
    {
        arithmetic.getExprLeft().accept(this, params);
        arithmetic.getExprRight().accept(this, params);
        arithmetic.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void params)
    {
        cast.getCastType().accept(this, params);
        cast.getExpression().accept(this, params);
        cast.setLValue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void params)
    {
        charLiteral.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Comparisson comparisson, Void params)
    {
        comparisson.getExprLeft().accept(this, params);
        comparisson.getExprRight().accept(this, params);
        comparisson.setLValue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void params)
    {
        doubleLiteral.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void params)
    {
        indexing.getExprLeft().accept(this, params);
        indexing.getExprRight().accept(this, params);
        indexing.setLValue(true);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void params)
    {
        intLiteral.setLValue(false);
        return null;
    }

    public Void visit(Logical logical, Void params)
    {
        logical.getExprLeft().accept(this, params);
        logical.getExprRight().accept(this, params);
        logical.setLValue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void params)
    {
        unaryMinus.getExpr().accept(this, params);
        unaryMinus.setLValue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Void params)
    {
        unaryNot.getExpr().accept(this, params);
        unaryNot.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void params)
    {
        variable.setLValue(true);
        return null;
    }

    @Override
    public Void visit(Invocation invocation, Void params)
    {
        invocation.getName().accept(this, params);
        invocation.getArguments().forEach(expression -> expression.accept(this,params));
        invocation.setLValue(false);
        return null;
    }

}
