package ast.expressions;

import ast.ASTAbstractNode;

public class Arithmetic extends ASTAbstractNode implements Expression {

    private String operator;
    private Expression exprLeft;
    private Expression exprRight;

    public Arithmetic(int line, int column, String operator, Expression exprLeft, Expression exprRight)
    {
        super(line, column);
        this.operator = operator;
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
    }

    @Override
    public String toString()
    {
        return "Arithmetic at "+getLine()+" ,"+getColumn();
    }
}
