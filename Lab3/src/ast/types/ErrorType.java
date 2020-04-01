package ast.types;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import errorHandler.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractType implements Type {

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

    @Override
    public Type logical(Type t, Expression logical)
    {
        return this;
    }
    @Override
    public Type arithmetic(Type t, Expression arithmetic)
    {
        return this;
    }
    @Override
    public Type squareBrackets(Type t, Expression indexing)
    {
        return this;
    }
    @Override
    public Type unaryNot(UnaryNot unaryNot)
    {
        return this;
    }
    @Override
    public Type unaryMinus(UnaryMinus unaryMinus)
    {
        return this;
    }
    public Type comparisson(Type type)
    {
        return this;
    }
    @Override
    public Type cast(Type castType)
    {
        return this;
    }
    @Override
    public Type dot(String member, Expression access)
    {
        return this;
    }
    @Override
    public Type parenthesis(List<Expression> arguments, Expression invocation)
    {
        return this;
    }

}
