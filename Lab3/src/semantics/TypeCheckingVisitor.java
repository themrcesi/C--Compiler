package semantics;

import ast.expressions.Access;
import ast.expressions.Arithmetic;
import ast.expressions.Variable;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.types.ErrorType;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    public void visit(Assignment assignment)
    {
        assignment.getLeftEx().accept(this, null);
        assignment.getRightEx().accept(this, null);
        if(!assignment.getLeftEx().isLValue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "LValue required");
    }

    public void visit(Variable variable)
    {
        variable.setLValue(true);
    }
}
