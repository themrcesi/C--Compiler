package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import ast.expressions.Variable;
import ast.types.Type;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Invocation extends ASTAbstractNode implements Statement, Expression {

    private Variable name;
    private List<Expression> arguments;
    private boolean lValue;
    private Type type;

    public Invocation(int line, int column, Variable name, List<Expression> arguments)
    {
        super(line, column);
        this.name = name;
        this.arguments = new ArrayList<Expression>(arguments);
    }

    @Override
    public String toString()
    {
        return "Invocation at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Variable getName() {
        return name;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public boolean isLValue() {
        return lValue;
    }

    @Override
    public void setLValue(boolean lValue) {
        this.lValue = lValue;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void setType(Type t) {
        this.type = t;
    }
}
