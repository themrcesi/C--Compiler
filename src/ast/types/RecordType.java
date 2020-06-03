package ast.types;

import ast.ASTAbstractNode;
import ast.definitions.VarDefinition;
import ast.expressions.Access;
import ast.expressions.Expression;
import errorHandler.ErrorHandler;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecordType extends AbstractType implements Type {

    private List<RecordField> fields;

    public RecordType(int line, int column, List<RecordField> fields)
    {
        super(line, column);
        this.fields = new ArrayList<RecordField>(checkFields(fields));
    }

    private List<RecordField> checkFields(List<RecordField> fields)
    {
        List<String> uniquesNames = new ArrayList<String>();
        for (RecordField rf : fields) {
            if(uniquesNames.contains(rf.getName()))
                new ErrorType(rf.getLine(),rf.getColumn(),"Duplicate RecordField name "+rf.getName());
            else
            {
                uniquesNames.add(rf.getName());
            }
        }
        return fields;
    }

    @Override
    public String toString()
    {
        var returned = "record(";
        for (RecordField rf: fields) {
            returned += "(" + rf.getName()+" x "+rf.getType().toString()+")";
        }
        return returned+")";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public List<RecordField> getFields() {
        return fields;
    }

    //###################################TYPE CHECKING##################################

    @Override
    public Type dot(String member, Expression access)
    {
        for(RecordField rf : getFields())
        {
            if(rf.getName().equals(member)) return rf.getType();
        }
        return new ErrorType(access.getLine(), access.getColumn(), "You are trying to access a non defined field: "+member);
    }

    @Override
    public int numberOfBytes() {
        int sum = 0;
        for(RecordField rf: this.fields)
        {
            sum += rf.getType().numberOfBytes();
        }
        return sum;
    }

    public RecordField getField(String member) {
        RecordField returned = null;
        for (RecordField rf: fields) {
            if(rf.getName().equals(member))
                returned = rf;
        }
        return returned;
    }
}
