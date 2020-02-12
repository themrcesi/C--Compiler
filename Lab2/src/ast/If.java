package ast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class If extends ASTAbstractNode implements Statement
{
    private Expression condition;
    private List<Statement> ifStatements;
    private List<Statement> elseStatements;

    public If(int line, int column, Expression condition, List<Statement> ifStatements, List<Statement> elseStatements)
    {
        super(line, column);
        this.condition = condition;
        this.ifStatements = new ArrayList<Statement>(ifStatements);
        this.elseStatements = new ArrayList<Statement>(elseStatements);
    }
}
