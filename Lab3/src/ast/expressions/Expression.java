package ast.expressions;

import ast.ASTNode;

public interface Expression extends ASTNode {

    public boolean isLValue();
    public void setLValue(boolean lValue);
}
