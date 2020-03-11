package ast.types;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class IntType extends ASTAbstractNode implements Type {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString()
    {
        return "IntType at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
