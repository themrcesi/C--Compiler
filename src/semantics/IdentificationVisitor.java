package semantics;

import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable st = new SymbolTable();

    @Override
    public Void visit(VarDefinition varDefinition, Void params)
    {
        varDefinition.getType().accept(this, params);
        if(!st.insert(varDefinition))
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(), varDefinition.getName()+" already defined in this scope.");
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDefinition, Void params)
    {
        //first insert the funcDefinition
        if(!st.insert(funcDefinition))
            new ErrorType(funcDefinition.getLine(), funcDefinition.getColumn(), funcDefinition.getName()+" already defined in this scope");
        // set a new scope and traverse childs and finally reset
        st.set();
        funcDefinition.getType().accept(this, params);
        for (Statement st : funcDefinition.getBody())
        {
            st.accept(this, params);
        }
        st.reset();
        return null;
    }

    @Override
    public Void visit(Variable variable, Void params)
    {
        variable.setDefinition(st.find(variable.getName()));
        if(variable.getDefinition() == null)
            new ErrorType(variable.getLine(), variable.getColumn(), variable.getName() + " has not been defined yet");
        return null;
    }

}
