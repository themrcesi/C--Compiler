package ast;

import ast.types.Type;

public interface Definition extends ASTNode {

    public String getName();
    public Type getType();
}
