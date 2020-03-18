package ast.definitions;

import ast.ASTNode;
import ast.types.Type;

public interface Definition extends ASTNode {

    void setScope(int scope);
    int getScope();
    String getName();
}
