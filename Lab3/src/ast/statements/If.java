package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class If extends ASTAbstractNode implements Statement
{
    private Expression condition;
    private List<Statement> ifStatements;
    private List<Statement> elseStatements;

    public If(int line, int column, Expression condition, List<Statement> ifStatements)
    {
        super(line, column);
        this.condition = condition;
        this.ifStatements = new ArrayList<Statement>(ifStatements);
        this.elseStatements = new ArrayList<Statement>();
    }

    public void setElse(List<Statement> elseStatements)
    {
        this.elseStatements = new ArrayList<Statement>(elseStatements);
    }

    @Override
    public String toString()
    {
        return "If at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfStatements() {
        return ifStatements;
    }

    public List<Statement> getElseStatements() {
        return elseStatements;
    }
}
