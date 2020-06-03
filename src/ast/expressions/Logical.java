package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class Logical extends AbstractExpression implements Expression {

    private String operand;
    private Expression exprLeft;
    private Expression exprRight;

    public Logical(int line, int column, String operand, Expression exprLeft, Expression exprRight)
    {
        super(line, column);
        this.operand = operand;
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
    }

    @Override
    public String toString()
    {
        return "Logical at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public String getOperand() {
        return operand;
    }

    public Expression getExprLeft() {
        return exprLeft;
    }

    public Expression getExprRight() {
        return exprRight;
    }
}
