package ast.types;

import ast.ASTNode;

public class RecordField implements ASTNode {

    private Type type;
    private int column;
    private int line;

    public RecordField(int line, int column, Type type)
    {
        this.line = line;
        this.column = column;
        this.type = type;
    }
    @Override
    public int getLine()
    {
        return this.line;
    }

    @Override
    public int getColumn() {
        return this.column;
    }
}
