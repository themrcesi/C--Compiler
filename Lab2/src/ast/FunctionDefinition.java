package ast;

import ast.types.FunctionType;
import ast.types.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition{

    private FunctionType type;
    private ArrayList<Statement> body;

    public FunctionDefinition(int line, int column, String name, FunctionType type, List<Statement> statements)
    {
        super(line, column, name);
        this.type = type;
        this.body = new ArrayList<Statement>(statements);
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
