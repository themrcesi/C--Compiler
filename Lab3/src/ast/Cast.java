package ast;

import ast.types.Type;

public class Cast extends ASTAbstractNode implements Expression {

    private Type type;
    private Expression expression;

    public Cast (int line, int column, Type type, Expression expression)
    {
        super(line, column);
        this.type = type;
        this.expression = expression;
    }
}
