package ast;

public class Read extends AbstractStatement {

    private Expression expression;

    public Read(int line, int column, Expression expression)
    {
        super(line, column);
        this.expression = expression;
    }
}
