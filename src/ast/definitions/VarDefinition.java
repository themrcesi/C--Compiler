package ast.definitions;

import ast.ASTAbstractNode;
import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

public class VarDefinition extends ASTAbstractNode implements Definition, Statement
{
    private final String name;
    private Type type;
    private int scope;
    private int offset;

    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "VarDefinition at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int getScope() {
        return this.scope;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    public int getOffset()
    {
        return this.offset;
    }

    public void setOffset(int offset)
    {
        this.offset=offset;
    }
}
