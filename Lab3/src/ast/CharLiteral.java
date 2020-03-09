package ast;

public class CharLiteral extends ASTAbstractNode implements Expression {

    private char value;

    public CharLiteral(int line, int column, char value)
    {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "CharLiteral at "+getLine()+" ,"+getColumn();
    }
}
