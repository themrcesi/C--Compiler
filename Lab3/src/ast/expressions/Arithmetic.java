package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class Arithmetic extends AbstractExpression implements Expression {

    private String operator;
    private Expression exprLeft;
    private Expression exprRight;

    public Arithmetic(int line, int column, String operator, Expression exprLeft, Expression exprRight)
    {
        super(line, column);
        this.operator = operator;
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
    }

    @Override
    public String toString()
    {
        return "Arithmetic at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public String getOperator() {
        return operator;
    }

    public Expression getExprLeft() {
        return exprLeft;
    }

    public Expression getExprRight() {
        return exprRight;
    }
}
