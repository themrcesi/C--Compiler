package ast;

public class UnaryNot extends AbstractExpression {

    private Expression expr;

    public UnaryNot(int line, int column, Expression expr)
    {
        super(line, column);
        this.expr = expr;
    }
}
