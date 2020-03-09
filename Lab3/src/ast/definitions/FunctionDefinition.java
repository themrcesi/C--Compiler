package ast.definitions;

import ast.ASTAbstractNode;
import ast.statements.Statement;
import ast.types.FunctionType;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends ASTAbstractNode implements Definition{

    private String name;
    private FunctionType type;
    private ArrayList<Statement> body;

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
}
