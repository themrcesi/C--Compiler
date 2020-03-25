package ast.expressions;

import ast.ASTAbstractNode;
import ast.types.Type;
import visitor.Visitor;

public abstract class AbstractExpression extends ASTAbstractNode implements Expression {

    private boolean lValue;
    private Type type;

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

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void setType(Type type)
    {
        this.type = type;
    }
}
