package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class Write extends ASTAbstractNode implements Statement{

    private Expression expression;

    public Write(int line, int column, Expression expression)
    {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        return "Write at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getExpression() {
        return expression;
    }
}
