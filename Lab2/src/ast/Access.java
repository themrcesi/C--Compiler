package ast;

public class Access extends ASTAbstractNode implements Statement {

    private Expression access;
    private String member;

    public Access(int line, int column, Expression access, String member)
    {
        super(line, column);
        this.access = access;
        this.member = member;
    }
}
