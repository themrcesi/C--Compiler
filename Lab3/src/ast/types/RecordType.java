package ast.types;

import ast.ASTAbstractNode;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends ASTAbstractNode implements Type {

    private List<RecordField> fields;

    public RecordType(int line, int column, List<RecordField> fields)
    {
        super(line, column);
        this.fields = new ArrayList<RecordField>(fields);
    }
}
