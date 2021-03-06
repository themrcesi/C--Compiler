package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class IntLiteral extends AbstractExpression implements Expression {

    private int value;

    public IntLiteral(int line, int column, int value)
    {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "IntLiteral at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public int getValue() {
        return this.value;
    }
}
