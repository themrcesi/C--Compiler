package ast.statements;

import ast.ASTAbstractNode;
import ast.expressions.Expression;
import ast.types.Type;
import visitor.Visitor;

public class Assignment extends ASTAbstractNode implements Statement {

    private Expression leftEx;
    private Expression rightEx;

    public Assignment(int line, int column, Expression expressionLeft, Expression expressionRight) {
        super(line, column);
        this.leftEx = expressionLeft;
        this.rightEx = expressionRight;
    }

    @Override
    public String toString()
    {
        return "Assignment at "+getLine()+" ,"+getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public Expression getLeftEx() {
        return leftEx;
    }

    public Expression getRightEx() {
        return rightEx;
    }
}
