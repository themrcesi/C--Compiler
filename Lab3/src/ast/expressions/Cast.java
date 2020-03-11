package ast.expressions;

import ast.ASTAbstractNode;
import ast.types.Type;

public class Cast extends ASTAbstractNode implements Expression {

    private Type castType;
    private Expression expression;

    public Cast (int line, int column, Type type, Expression expression)
    {
        super(line, column);
        this.castType = type;
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        return "Cast at "+getLine()+" ,"+getColumn();
    }
}