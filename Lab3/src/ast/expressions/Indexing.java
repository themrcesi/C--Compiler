package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class Indexing extends AbstractExpression implements Expression {

    private Expression exprRight;
    private Expression exprLeft;

    public Indexing(int line, int column, Expression exprLeft, Expression exprRight)
    {
        super(line, column);
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
    }

    @Override
    public String toString()
    {
        return "Indexing at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getExprRight() {
        return exprRight;
    }

    public Expression getExprLeft() {
        return exprLeft;
    }
}
