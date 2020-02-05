package ast;

public class Write extends AbstractStatement {

    private Expression expression;

    public Write(int line, int column, Expression expression)
    {
        super(line, column);
        this.expression = expression;
    }
}
