package ast.types;

import ast.ASTAbstractNode;

public class ArrayType extends ASTAbstractNode implements Type {

    private Type type;
    private int size;

    public ArrayType(int line, int column, Type t, int size)
    {
        super(line, column);
        this.type = t;
        this.size = size;
    }
}

