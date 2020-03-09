package ast.expressions;

import ast.ASTAbstractNode;

public class IntLiteral extends ASTAbstractNode implements Expression {

    private int value;

    public IntLiteral(int line, int column, int value)
    {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "IntLiteral at "+getLine()+" ,"+getColumn();
    }
}
