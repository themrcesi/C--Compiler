package ast;

public class DoubleLiteral extends ASTAbstractNode implements Expression {

    private double value;

    public DoubleLiteral(int line, int column, double value)
    {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "DoubleLiteral at "+getLine()+" ,"+getColumn();
    }
}
