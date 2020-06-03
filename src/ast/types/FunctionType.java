package ast.types;

import ast.ASTAbstractNode;
import ast.definitions.VarDefinition;
import ast.expressions.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType implements Type {

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
        return "Function with return type "+returnType.toString() + " and "+parameters.size()+" parameters";
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

    //#################################TYPE CHECKING################################


    @Override
    public Type parenthesis(List<Expression> arguments, Expression invocation) {
        if(getParameters().size()!=arguments.size())
            return new ErrorType(invocation.getLine(),invocation.getColumn(), "Number of arguments doesn´t match, expected: "+ getParameters().size() +" and were given: "+arguments.size());
        for(int i = 0; i < arguments.size(); i++)
        {
            if(!getParameters().get(i).getType().isAssignable(arguments.get(i).getType()))
                return new ErrorType(invocation.getLine(), invocation.getColumn(), "Type of parameter doesn´t match, expected: "+getParameters().get(i).getType()+" and was given: "+arguments.get(i).getType());
        }
        return this.getReturnType();
    }
}
