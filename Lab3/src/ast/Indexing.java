package ast;

public class Indexing extends ASTAbstractNode implements Expression {

    private Expression exprRight;
    private Expression exprLeft;

    public Indexing(int line, int column, Expression exprLeft, Expression exprRight)
    {
        super(line, column);
        this.exprLeft = exprLeft;
        this.exprRight = exprRight;
    }

    @Override
    public String toString()
    {
        return "Indexing at "+getLine()+" ,"+getColumn();
    }
}
