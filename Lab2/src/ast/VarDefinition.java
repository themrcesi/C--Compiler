package ast;

import ast.types.Type;

public class VarDefinition extends AbstractDefinition implements Statement
{
    private Type type;

    public VarDefinition(int line, int column, String name, Type type) {
        super(line, column, name);
        this.type = type;
    }

    @Override
    public Type getType()
    {
        return this.type;
    }
}
