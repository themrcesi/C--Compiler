package ast.types;

import ast.ASTAbstractNode;
import errorHandler.ErrorHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecordType extends ASTAbstractNode implements Type {

    private List<RecordField> fields;

    public RecordType(int line, int column, List<RecordField> fields)
    {
        super(line, column);
        this.fields = new ArrayList<RecordField>(checkFields(fields));
    }

    private List<RecordField> checkFields(List<RecordField> fields)
    {
        List<String> uniquesNames = new ArrayList<String>();
        List<RecordField> returned = new ArrayList<RecordField>();
        for (RecordField rf : fields) {
            if(uniquesNames.contains(rf.getName()))
                new ErrorType(rf.getLine(),rf.getColumn(),"Duplicate RecordField name "+rf.getName());
            else
            {
                returned.add(rf);
                uniquesNames.add(rf.getName());
            }
        }
        return returned;
    }

    @Override
    public String toString()
    {
        return "RecordType at "+getLine()+" ,"+getColumn();
    }
}
