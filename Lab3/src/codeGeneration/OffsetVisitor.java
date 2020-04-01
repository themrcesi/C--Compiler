package codeGeneration;

import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.RecordType;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Void,Void> {

    public final static int GLOBAL = 0;
    public final static int IP_OFFSET = 4;

    int globalOffset = 0;
    int localOffset = 0;

    @Override
    public Void visit(RecordType recordType, Void param)
    {
        int fieldsByteSum = 0;

        for(RecordField rf : recordType.getFields())
        {
            rf.setOffset(fieldsByteSum);
            fieldsByteSum += rf.getType().numberOfBytes();
            rf.accept(this, param);
        }

        return null;
    }

    @Override
    public Void visit(VarDefinition varDef, Void param)
    {
        varDef.getType().accept(this, param);
        if(varDef.getScope()==GLOBAL)
        {
            varDef.setOffset(globalOffset);
            globalOffset += varDef.getType().numberOfBytes();
        }
        else //LOCAL
        {
            localOffset += varDef.getType().numberOfBytes();
            varDef.setOffset(-localOffset);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void param)
    {
        localOffset = 0; //RESET LOCAL
        funcDef.getType().accept(this, param);
        funcDef.getBody().forEach(st -> {
            st.accept(this, param);
        });
        return null;
    }

    @Override
    public Void visit(FunctionType funcType, Void param)
    {
        int paramsSum = IP_OFFSET;
        funcType.getReturnType().accept(this, param);
        for(var i = funcType.getParameters().size()-1; i>=0; i--)
        {
            funcType.getParameters().get(i).setOffset(paramsSum);
            paramsSum += funcType.getParameters().get(i).getType().numberOfBytes();
            funcType.getParameters().get(i).getType().accept(this, null);
        }
        return null;
    }

}
