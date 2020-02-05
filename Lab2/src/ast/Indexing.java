package ast;

public class Indexing extends AbstractExpression {

    private Expression exprRight;
    private Expression exprLeft;

    public Indexing(int line, int column, Expression exprLeft, Expression exprRight)
    {
        super(line, column);
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
    }
}
