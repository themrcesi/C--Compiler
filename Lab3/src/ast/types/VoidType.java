package ast.types;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class VoidType extends ASTAbstractNode implements Type {

    public VoidType (int line, int column)
    {
        super(line,column);
    }

    @Override
    public String toString()
    {
        return "VoidType at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
