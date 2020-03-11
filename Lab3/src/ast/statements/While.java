package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class While extends ASTAbstractNode implements Statement {

    private Expression condition;
    private List<Statement> body;

    public While(int line, int column, Expression condition, List<Statement> body)
    {
        super(line, column);
        this.condition = condition;
        this.body = new ArrayList<Statement>(body);
    }

    @Override
    public String toString()
    {
        return "Variable at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getBody() {
        return body;
    }
}
