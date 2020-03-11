package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public abstract class AbstractExpression extends ASTAbstractNode implements Expression {

    private boolean lValue;

    public AbstractExpression(int line, int column)
    {
        super(line,column);
    }

    @Override
    public boolean isLValue() {
        return lValue;
    }

    @Override
    public void setLValue(boolean lValue) {
        this.lValue = lValue;
    }
}
