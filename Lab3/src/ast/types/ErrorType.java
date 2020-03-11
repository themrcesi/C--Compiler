package ast.types;

import ast.ASTAbstractNode;
import errorHandler.ErrorHandler;
import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
