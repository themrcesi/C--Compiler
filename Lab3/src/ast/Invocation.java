package ast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Invocation extends ASTAbstractNode implements Statement, Expression {

    private Variable name;
    private List<Expression> arguments;

    public Invocation(int line, int column, Variable name, List<Expression> arguments)
    {
        super(line, column);
        this.name = name;
        this.arguments = new ArrayList<Expression>(arguments);
    }
}
