package ast.types;

import ast.ASTAbstractNode;
import ast.definitions.VarDefinition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends ASTAbstractNode implements Type {

    private Type returnType;
    private ArrayList<VarDefinition> parameters;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> parameters) {
        super(line, column);
        this.returnType = returnType;
        this.parameters = new ArrayList<VarDefinition>(parameters);
    }

    @Override
    public String toString()
    {
        return "FunctionType at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Type getReturnType() {
        return returnType;
    }

    public ArrayList<VarDefinition> getParameters() {
        return parameters;
    }
}
