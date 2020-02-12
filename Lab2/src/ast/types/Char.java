package ast.types;

import ast.ASTAbstractNode;

public class Char extends ASTAbstractNode implements Type {

    public Char(int line, int column)
    {
        super(line, column);
    }
}
