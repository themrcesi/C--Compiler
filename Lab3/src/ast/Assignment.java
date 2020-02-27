package ast;

public class Assignment extends ASTAbstractNode implements Statement {

    private Expression leftEx;
    private Expression rightEx;

    public Assignment(int line, int column, Expression expressionLeft, Expression expressionRight) {
        super(line, column);
        this.leftEx = expressionLeft;
        this.rightEx = expressionRight;
    }
}
