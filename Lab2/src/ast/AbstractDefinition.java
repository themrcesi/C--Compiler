package ast;

import ast.types.Type;

public abstract class AbstractDefinition extends ASTAbstractNode implements Definition {

    private String identifier;

    public AbstractDefinition(int line, int column, String name) {
        super(line,column);
        this.identifier = name;
    }

    @Override
    public String getName()
    {
        return this.identifier;
    }

    @Override
    public abstract Type getType();
}
