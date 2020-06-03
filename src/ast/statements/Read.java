package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class Read extends ASTAbstractNode implements Statement {

    private Expression expression;

    public Read(int line, int column, Expression expression)
    {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        return "Read at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getExpression() {
        return expression;
    }
}
