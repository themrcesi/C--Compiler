package ast.types;

import ast.ASTNode;
import ast.expressions.Access;
import ast.expressions.Expression;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import ast.statements.Invocation;

import java.util.List;

public interface Type extends ASTNode {

    public boolean isBoolean();

    Type logical(Type t);
    Type arithmetic(Type t);
    Type squareBrackets(Type t);
    Type unaryNot(UnaryNot unaryNot);
    Type unaryMinus(UnaryMinus unaryMinus);
    Type comparisson(Type type);
    Type cast(Type castType);
    Type dot(String member, Access access);

    Type parenthesis(List<Expression> arguments, Invocation invocation);
}
