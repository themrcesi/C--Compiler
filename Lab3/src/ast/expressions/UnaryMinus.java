package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class UnaryMinus extends AbstractExpression implements Expression {

    private Expression expr;

    public UnaryMinus(int line, int column, Expression expr)
    {
        super(line, column);
        this.expr = expr;
    }

    @Override
    public String toString()
    {
        return "UnaryMinus at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getExpr() {
        return expr;
    }
}
