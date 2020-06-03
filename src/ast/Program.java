package ast;

import ast.definitions.Definition;
import visitor.Visitor;

import java.util.ArrayList;
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

    public List<Definition> getDefs() {
        return defs;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
