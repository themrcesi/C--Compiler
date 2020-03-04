package ast.types;

import ast.ASTAbstractNode;

public class ErrorType extends ASTAbstractNode implements Type {

    private final String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
    }

    @Override
    public String toString()
    {
        return getLine()+", "+getColumn()+": "+this.message;
    }
}
