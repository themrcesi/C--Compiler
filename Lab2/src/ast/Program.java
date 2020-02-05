package ast;

public class Program implements ASTNode {

    public Program(int line, int column, List<Definition> definitions)

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
