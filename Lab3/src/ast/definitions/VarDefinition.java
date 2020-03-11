package ast.definitions;

import ast.ASTAbstractNode;
import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

public class VarDefinition extends ASTAbstractNode implements Definition, Statement
{
    private final String name;
    private Type type;

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

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
