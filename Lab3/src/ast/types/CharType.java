package ast.types;

import ast.ASTAbstractNode;

public class CharType extends ASTAbstractNode implements Type {

    public CharType(int line, int column)
    {
        super(line, column);
    }

    @Override
    public String toString()
    {
        return "CharType at "+getLine()+" ,"+getColumn();
    }
}
