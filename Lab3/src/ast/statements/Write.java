package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;

public class Write extends ASTAbstractNode implements Statement{

    private Expression expression;

    public Write(int line, int column, Expression expression)
    {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        return "Write at "+getLine()+" ,"+getColumn();
    }
}
