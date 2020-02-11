package ast;

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
}
