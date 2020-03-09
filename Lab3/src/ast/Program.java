package ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program extends ASTAbstractNode {

    private List<Definition> defs;

    public Program(int line, int column, List<Definition> definitions)
    {
        super(line,column);
        this.defs = new ArrayList<Definition>(definitions);
    }

    @Override
    public String toString()
    {
        return "Program at "+getLine()+" ,"+getColumn();
    }
}
