package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode {

    public boolean isLValue();
    public void setLValue(boolean lValue);
    public Type getType();
    public void setType(Type t);
}
