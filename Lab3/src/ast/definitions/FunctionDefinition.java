package ast.definitions;

import ast.ASTAbstractNode;
import ast.statements.Statement;
import ast.types.FunctionType;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends ASTAbstractNode implements Definition{

    private String name;
    private FunctionType type;
    private ArrayList<Statement> body;
    private int scope;

    public FunctionDefinition(int line, int column, String name, FunctionType type, List<Statement> statements)
    {
        super(line, column);
        this.name = name;
        this.type = type;
        this.body = new ArrayList<Statement>(statements);
    }

    @Override
    public String toString()
    {
        return "FunctionDefinition at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public FunctionType getType() {
        return type;
    }

    public ArrayList<Statement> getBody() {
        return body;
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
}
