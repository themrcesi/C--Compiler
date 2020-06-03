package ast.types;

import ast.expressions.Expression;
import visitor.Visitor;

public class CharType extends AbstractType implements Type {

    public CharType(int line, int column)
    {
        super(line, column);
    }

    @Override
    public String toString()
    {
        return "char";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    //###################################TYPE CHECKING##################################################

    @Override
    public boolean isWritable()
    {
        return true;
    }

    @Override
    public Type arithmetic(Type t, Expression arithmetic)
    {
        if(t instanceof CharType) return new IntType(arithmetic.getLine(), arithmetic.getColumn());
        if(t instanceof ErrorType) return t;
        return new ErrorType(arithmetic.getLine(), arithmetic.getColumn(), "Cannot perform an arithemtic operation of char and "+t.toString());
    }

    @Override
    public Type comparisson(Type t) {
        if(t instanceof CharType) return new IntType(this.getLine(), this.getColumn());
        if(t instanceof ErrorType) return t;
        return new ErrorType(this.getLine(), this.getColumn(), "Cannot compare a char with a "+t.toString());
    }

    @Override
    public Type cast(Type t)
    {
        if(t instanceof IntType || t instanceof DoubleType || t instanceof CharType) return t;
        if(t instanceof ErrorType) return t;
        return new ErrorType(this.getLine(), this.getColumn(), "Cannot perform a cast of char to "+t.toString());
    }

    @Override
    public boolean isAssignable(Type t)
    {
        if(t instanceof CharType) return true;
        return false;
    }

    @Override
    public int numberOfBytes()
    {
        return 1;
    }

    @Override
    public String suffix()
    {
        return "b";
    }
}
