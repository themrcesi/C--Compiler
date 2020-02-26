package ast;

public class Return extends ASTAbstractNode implements Statement {

    private final Expression returned;

    public Return(int line, int column, Expression returned) 
    {
        super(line, column);
        this.returned = returned;
    }
}
