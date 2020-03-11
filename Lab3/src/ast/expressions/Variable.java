package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class Variable extends AbstractExpression implements Expression{

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
