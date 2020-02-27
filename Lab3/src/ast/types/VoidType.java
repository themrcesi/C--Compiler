package ast.types;

import ast.ASTAbstractNode;

public class VoidType extends ASTAbstractNode implements Type {

    public VoidType (int line, int column)
    {
        super(line,column);
    }
}
