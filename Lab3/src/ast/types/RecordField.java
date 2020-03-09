package ast.types;

import ast.ASTAbstractNode;
import ast.ASTNode;

public class RecordField extends ASTAbstractNode {

    private String name;
    private Type type;

    public RecordField(int line, int column, Type type, String name) {
        super(line,column);
        this.type = type;
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return "RecordField at "+getLine()+" ,"+getColumn();
    }
}
