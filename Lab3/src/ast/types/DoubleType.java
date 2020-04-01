package ast.types;

import ast.expressions.Expression;
import ast.expressions.UnaryMinus;
import visitor.Visitor;

public class DoubleType extends AbstractType implements Type {

    public DoubleType(int line, int column)
    {
        super(line, column);
    }

    @Override
    public String toString()
    {
        return "double";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }


    //###########################TYPE CHECKING##########################################

    @Override
    public boolean isWritable() {
        return true;
    }

    @Override
    public Type arithmetic(Type t, Expression arithmetic)
    {
        if(t instanceof DoubleType) return this;
        if(t instanceof ErrorType) return t;
        return new ErrorType(arithmetic.getLine(), arithmetic.getColumn(), "Cannot perform an arithmetic operation for double and "+t.toString());
    }

    @Override
    public Type unaryMinus(UnaryMinus t) {
        return this;
    }

    @Override
    public Type comparisson(Type t) {
        if(t instanceof DoubleType) return new IntType(this.getLine(), this.getColumn());
        if(t instanceof ErrorType) return t;
        return new ErrorType(this.getLine(), this.getColumn(), "Cannot compare a double with a "+t.toString());
    }

    @Override
    public Type cast(Type t) {
        if(t instanceof IntType || t instanceof DoubleType || t instanceof CharType) return t;
        if(t instanceof ErrorType) return t;
        return new ErrorType(this.getLine(), this.getColumn(), "Cannot perform a cast of double to "+t.toString());
    }

    @Override
    public boolean isAssignable(Type t)
    {
        if(t instanceof DoubleType) return true;
        return false;
    }
}
