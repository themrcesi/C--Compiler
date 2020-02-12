package ast.types;

import ast.ASTAbstractNode;

import java.util.ArrayList;
import java.util.List;

public class Record extends ASTAbstractNode implements Type {

    private List<RecordField> fields;

    public Record(int line, int column, List<RecordField> fields)
    {
        super(line, column);
        this.fields = new ArrayList<RecordField>(fields);
    }
}
