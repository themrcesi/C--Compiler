package ast;

public class UnaryMinus extends ASTAbstractNode implements Expression {

    private Expression expr;

    public UnaryMinus(int line, int column, Expression expr)
    {
        super(line, column);
        this.expr = expr;
    }

    @Override
    public String toString()
    {
        return "UnaryMinus at "+getLine()+" ,"+getColumn();
    }
}
