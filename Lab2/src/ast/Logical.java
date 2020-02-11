package ast;

public class Logical extends ASTAbstractNode implements Expression {

    private String operand;
    private Expression exprLeft;
    private Expression exprRight;

    public Logical(int line, int column, String operand, Expression exprLeft, Expression exprRight)
    {
        super(line, column);
        this.operand = operand;
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
    }
}
