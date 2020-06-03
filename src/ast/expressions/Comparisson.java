package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class Comparisson extends AbstractExpression implements Expression {

    private String operand;
    private Expression exprLeft;
    private Expression exprRight;

    public Comparisson(int line, int column, String operand, Expression exprLeft, Expression exprRight) 
    {
        super(line, column);
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
        this.operand = operand;
    }

    @Override
    public String toString()
    {
        return "Comparision at "+getLine()+" ,"+getColumn();
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
