package ast.types;

import ast.ASTAbstractNode;

public class IntType extends ASTAbstractNode implements Type {

    public IntType(int line, int column) {
        super(line, column);
    }
}
