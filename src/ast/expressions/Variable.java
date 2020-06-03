package ast.expressions;

import ast.ASTAbstractNode;
import ast.definitions.Definition;
import visitor.Visitor;

public class Variable extends AbstractExpression implements Expression{

    private String name;
    private Definition definition;

    public Variable(int line, int column, String name)
    {
        super(line, column);
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Variable at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public String getName()
    {
        return this.name;
    }

    public Definition getDefinition()
    {
        return this.definition;
    }

    public void setDefinition(Definition definition)
    {
        this.definition = definition;
    }
}
