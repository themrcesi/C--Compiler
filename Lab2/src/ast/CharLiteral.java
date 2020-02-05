package ast;

public class CharLiteral extends AbstractExpression {

    private char value;

    public CharLiteral(int line, int column, char value)
    {
        super(line, column);
        this.value = value;
    }
}
