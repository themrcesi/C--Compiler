package ast;

public class Comparisson extends ASTAbstractNode implements Expression {

    private String operand;
    private Expression exprLeft;
    private Expression exprRight;

    public Comparisson(int line, int column, String operand, Expression exprLeft, Expression exprRight) 
    {
        super(line, column);
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
        this.operand = operand;
    }

    @Override
    public String toString()
    {
        return "Comparision at "+getLine()+" ,"+getColumn();
    }
}
