package ast.expressions;

import ast.ASTAbstractNode;

public class Variable extends ASTAbstractNode implements Expression{

    private String name;

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
}
