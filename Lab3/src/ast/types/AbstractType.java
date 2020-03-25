package ast.types;

import ast.ASTAbstractNode;
import ast.expressions.Access;
import ast.expressions.Expression;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import ast.statements.Invocation;
import visitor.Visitor;

import java.util.List;

public abstract class AbstractType extends ASTAbstractNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean isBoolean() {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public Type logical(Type t, Expression logical) {
        return new ErrorType(t.getLine(),t.getColumn(), "Cannot perform a logical operation with these types");
    }

    @Override
    public Type arithmetic(Type t, Expression arithmetic) {
        return new ErrorType(t.getLine(),t.getColumn(), "Cannot perform a arithmetic operation with these types");
    }

    @Override
    public Type squareBrackets(Type t, Expression indexing) {
        return new ErrorType(t.getLine(),t.getColumn(), "Cannot index any other type than array");
    }

    @Override
    public Type unaryNot(UnaryNot t) {
        return new ErrorType(t.getLine(),t.getColumn(), "Cannot perform a unaryNot of a "+t.getExpr().getType());
    }

    @Override
    public Type unaryMinus(UnaryMinus t) {
        return new ErrorType(t.getLine(),t.getColumn(), "Cannot perform a unaryMinus");
    }

    @Override
    public Type comparisson(Type t) {
        return new ErrorType(t.getLine(),t.getColumn(), "Cannot perform a comparison of these types");
    }

    @Override
    public Type cast(Type castType) {
        return this;
    }

    @Override
    public Type dot(String member, Expression access) {
        return new ErrorType(access.getLine(),access.getColumn(), "Trying to access a non struct type");
    }

    @Override
    public Type parenthesis(List<Expression> arguments, Expression invocation) {
        return new ErrorType(invocation.getLine(),invocation.getColumn(), "Cannot invoke function");
    }

    @Override
    public boolean isAssignable(Type type) {
        return false;
    }

}
