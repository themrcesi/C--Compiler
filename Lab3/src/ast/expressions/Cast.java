package ast.expressions;

import ast.ASTAbstractNode;
import ast.types.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression implements Expression {

    private Type castType;
    private Expression expression;

    public Cast (int line, int column, Type type, Expression expression)
    {
        super(line, column);
        this.castType = type;
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        return "Cast at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Type getCastType() {
        return castType;
    }

    public Expression getExpression() {
        return expression;
    }
}
