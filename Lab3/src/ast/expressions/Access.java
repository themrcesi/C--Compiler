package ast.expressions;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class Access extends AbstractExpression implements Expression {

    private Expression access;
    private String member;

    public Access(int line, int column, Expression access, String member)
    {
        super(line, column);
        this.access = access;
        this.member = member;
    }

    @Override
    public String toString()
    {
        return "Access at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getAccess() {
        return access;
    }

    public String getMember() {
        return member;
    }
}
