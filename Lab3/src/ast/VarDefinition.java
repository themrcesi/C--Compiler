package ast;

import ast.types.Type;

public class VarDefinition extends ASTAbstractNode implements Definition, Statement
{
    private final String name;
    private Type type;

    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }
}
