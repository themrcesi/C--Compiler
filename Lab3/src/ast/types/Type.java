package ast.types;

import ast.ASTNode;
import ast.expressions.Access;
import ast.expressions.Expression;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import ast.statements.Invocation;

import java.util.List;

public interface Type extends ASTNode {

    Type logical(Type t, Expression logical);
    Type arithmetic(Type t, Expression arithmetic);
    Type squareBrackets(Type t, Expression indexing);
    Type unaryNot(UnaryNot unaryNot);
    Type unaryMinus(UnaryMinus unaryMinus);
    Type comparisson(Type type);
    Type cast(Type castType);
    Type dot(String member, Expression access);
    Type parenthesis(List<Expression> arguments, Expression invocation);
    boolean isBoolean(); //if, while
    boolean isWritable();  //write
    boolean isAssignable(Type type);
}
