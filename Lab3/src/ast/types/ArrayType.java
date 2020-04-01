package ast.types;

import ast.expressions.Expression;
import visitor.Visitor;

public class ArrayType extends AbstractType implements Type {

    private Type type;
    private int size;

    public ArrayType(int line, int column, Type t, int size)
    {
        super(line, column);
        this.type = t;
        setSize(size);
    }

    private void setSize(int size)
    {
        if(this.type instanceof ArrayType)
        {
            this.size = ((ArrayType) this.type).getSize();
            ((ArrayType) this.type).setSize(size);
        }
        else
        {
            this.size = size;
        }
    }

    @Override
    public String toString()
    {
        return type.toString()+"["+size+"]";
    }

//    public void setType(Type prev)
//    {
//        if(this.type instanceof ArrayType)
//        {
//            ((ArrayType)this.type).setType(type);
//        }
//        else //the actual type
//        {
//            this.type = type;
//        }
//    }

//    public void setType(Type previousType)
//    {
//        if(previousType instanceof ArrayType)
//        {
//            Type aux = ((ArrayType)previousType).getType();
//            ((ArrayType) previousType).setType(aux);
//            this.type = aux;
//        }
//        else {
//            this.type = previousType;
//        }
//    }

//    public void setType(Type type)
//    {
//        this.type = type;
//    }

    public int getSize()
    {
        return this.size;
    }

    public Type getType()
    {
        return this.type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type t, Expression indexing) {
        if(t instanceof IntType) return this.getType();
        if(t instanceof ErrorType) return t;
        return new ErrorType(indexing.getLine(), indexing.getColumn(), "Array can only be indexed with integers, you tried with "+t.toString());
    }

//    @Override
//    public boolean isAssignable(Type t)
//    {
//        if(t instanceof ArrayType)
//        {
//            ArrayType right = (ArrayType) t;
//            if(this.type.assignment(right.getType())) //same type
//                if(right.getSize()<=this.getSize()) // right size <= left size
//                    return true;
//        }
//        return false;
//    }

    @Override
    public int numberOfBytes()
    {
        return this.size*this.type.numberOfBytes();
    }
}

