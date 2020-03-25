package ast.types;

import ast.expressions.Expression;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import visitor.Visitor;

public class IntType extends AbstractType implements Type {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString()
    {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    //####################################TYPE CHECKING########################################################

    @Override
    public Type arithmetic(Type t, Expression arithmetic)
    {
        if(t instanceof IntType) return this;
        if(t instanceof ErrorType) return t;
        return new ErrorType(arithmetic.getLine(), arithmetic.getColumn(), "Cannot perform an arithmetic operation for int and "+t.toString());
    }

    @Override
    public Type logical(Type t, Expression logical)
    {
        if(t instanceof IntType) return this;
        if(t instanceof ErrorType) return t;
        return new ErrorType(logical.getLine(), logical.getColumn(), "Cannot perform a logical operation with int and "+t.toString());
    }

    @Override
    public boolean isBoolean()
    {
        return true;
    }

    @Override
    public boolean isWritable()
    {
        return true;
    }

    @Override
    public Type unaryMinus(UnaryMinus um)
    {
        return this;
    }

    @Override
    public Type unaryNot(UnaryNot un)
    {
        return this;
    }

    @Override
    public Type comparisson(Type t)
    {
        if(t instanceof IntType) return this;
        if(t instanceof ErrorType) return t;
        return new ErrorType(this.getLine(), this.getColumn(), "Cannot perform a comparisson operation with int and "+t.toString());
    }

    @Override
    public Type cast(Type t)
    {
        if(t instanceof IntType || t instanceof DoubleType || t instanceof CharType) return this;
        if(t instanceof ErrorType) return t;
        return new ErrorType(this.getLine(), this.getColumn(), "Cannot cast int to "+t.toString());
    }

    @Override
    public boolean isAssignable(Type t)
    {
        if(t instanceof IntType) return true;
        return false;
    }

}
