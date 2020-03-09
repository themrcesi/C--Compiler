package ast.types;

import ast.ASTAbstractNode;

public class DoubleType extends ASTAbstractNode implements Type {

    public DoubleType(int line, int column)
    {
        super(line, column);
    }

    @Override
    public String toString()
    {
        return "DoubleType at "+getLine()+" ,"+getColumn();
    }
}
