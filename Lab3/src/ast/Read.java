package ast;

public class Read extends ASTAbstractNode implements Statement {

    private Expression expression;

    public Read(int line, int column, Expression expression)
    {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        return "Read at "+getLine()+" ,"+getColumn();
    }
}
