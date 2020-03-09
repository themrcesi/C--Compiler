package ast.types;

import ast.ASTAbstractNode;
import errorHandler.ErrorHandler;

public class ErrorType extends ASTAbstractNode implements Type {

    private final String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstanceOf().addError(this);
    }

    @Override
    public String toString()
    {
        return getLine()+", "+getColumn()+": "+this.message;
    }
}
