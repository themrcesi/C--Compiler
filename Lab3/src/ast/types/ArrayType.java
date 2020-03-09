package ast.types;

import ast.ASTAbstractNode;

public class ArrayType extends ASTAbstractNode implements Type {

    private Type type;
    private int size;

    public ArrayType(int line, int column, Type t, int size)
    {
        super(line, column);
        this.type = t;
        setSize(size);
        //setSize(size);
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
}

