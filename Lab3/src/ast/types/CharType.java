package ast.types;

import ast.ASTAbstractNode;
import visitor.Visitor;

public class CharType extends ASTAbstractNode implements Type {

    public CharType(int line, int column)
    {
        super(line, column);
    }

    @Override
    public String toString()
    {
        return "CharType at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
