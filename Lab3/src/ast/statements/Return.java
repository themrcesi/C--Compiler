package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class Return extends ASTAbstractNode implements Statement {

    private final Expression returned;

    public Return(int line, int column, Expression returned) 
    {
        super(line, column);
        this.returned = returned;
    }

    @Override
    public String toString()
    {
        return "Return at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getReturned() {
        return returned;
    }
}
