package ast;

public abstract class ASTAbstractNode implements ASTNode
{
    private int line;
    private int column;

    public ASTAbstractNode(int line, int column)
    {
        this.line = line;
        this.column = column;
    }

    @Override
    public int getLine()
    {
        return this.line;
    }

    @Override
    public int getColumn()
    {
        return this.column;
    }
}
