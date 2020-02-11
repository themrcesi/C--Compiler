package ast.types;

import ast.ASTAbstractNode;

public class Int extends ASTAbstractNode implements Type {

    public Int(int line, int column) {
        super(line, column);
    }
}
