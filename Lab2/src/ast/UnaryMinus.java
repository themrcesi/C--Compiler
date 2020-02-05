package ast;

public class UnaryMinus extends AbstractExpression {

    private Expression expr;

    public UnaryMinus(int line, int column, Expression expr)
    {
        super(line, column);
        this.expr = expr;
    }
}
