package ast.expressions;

import ast.ASTAbstractNode;

public class UnaryNot extends ASTAbstractNode implements Expression {

    private Expression expr;

    public UnaryNot(int line, int column, Expression expr)
    {
        super(line, column);
        this.expr = expr;
    }

    @Override
    public String toString()
    {
        return "UnaryNot at "+getLine()+" ,"+getColumn();
    }
}
