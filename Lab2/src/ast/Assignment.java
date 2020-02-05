package ast;

public class Assignment extends AbstractStatement{

    private Expression leftEx;
    private Expression rightEx;

    public Assignment(int line, int column, Expression expressionLeft, Expression expressionRight) {
        super(line, column);
        this.leftEx = expressionLeft;
        this.rightEx = expressionRight;
    }
}
