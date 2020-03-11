package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Program program, TP params) {
        for(Definition d : program.getDefs())
        {
            d.accept(this, params);
        }
        return null;
    }

    @Override
    public TR visit(FunctionDefinition funcDef, TP params) {
        funcDef.getType().accept(this, params);
        for (Statement st : funcDef.getBody())
        {
            st.accept(this, params);
        }
        return null;
    }

    @Override
    public TR visit(VarDefinition varDef, TP params) {
        varDef.getType().accept(this, params);
        return null;
    }

    @Override
    public TR visit(Access access, TP params) {
        access.getAccess().accept(this, params);
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP params) {
        arithmetic.getExprLeft().accept(this, params);
        arithmetic.getExprRight().accept(this, params);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP params) {
        cast.getCastType().accept(this, params);
        cast.getExpression().accept(this, params);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP params) {
        return null;
    }

    /*if(!assign.getLFHS().getLValue()) new ErrorType("LValue required")*/

    @Override
    public TR visit(Comparisson comparisson, TP params) {
        comparisson.getExprLeft().accept(this, params);
        comparisson.getExprRight().accept(this, params);
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP params) {
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP params) {
        indexing.getExprLeft().accept(this, params);
        indexing.getExprRight().accept(this, params);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP params) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP params) {
        logical.getExprLeft().accept(this, params);
        logical.getExprRight().accept(this, params);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP params) {
        unaryMinus.getExpr().accept(this, params);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP params) {
        unaryNot.getExpr().accept(this, params);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP params) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP params) {
        assignment.getLeftEx().accept(this, params);
        assignment.getRightEx().accept(this, params);
        return null;
    }

    @Override
    public TR visit(If ifelse, TP params) {
        ifelse.getCondition().accept(this, params);
        ifelse.getIfStatements().forEach(st -> st.accept(this, params));
        ifelse.getElseStatements().forEach(st -> st.accept(this, params));
        return null;
    }

    @Override
    public TR visit(Invocation invocation, TP params) {
        invocation.getName().accept(this, params);
        invocation.getArguments().forEach(exp -> exp.accept(this, params));
        return null;
    }

    @Override
    public TR visit(Read read, TP params) {
        read.getExpression().accept(this, params);
        return null;
    }

    @Override
    public TR visit(Return returnStatement, TP params) {
        returnStatement.accept(this, params);
        return null;
    }

    @Override
    public TR visit(While whileStatement, TP params) {
        whileStatement.getCondition().accept(this, params);
        whileStatement.getBody().forEach(st -> st.accept(this, params));
        return null;
    }

    @Override
    public TR visit(Write write, TP params) {
        write.getExpression().accept(this, params);
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP params) {
        arrayType.getType().accept(this, params);
        return null;
    }

    @Override
    public TR visit(CharType charType, TP params) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP params) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP params) {
        return null;
    }

    @Override
    public TR visit(FunctionType funcType, TP params) {
        funcType.getReturnType().accept(this, params);
        funcType.getParameters().forEach(vdf -> vdf.accept(this, params));
        return null;
    }

    @Override
    public TR visit(IntType intType, TP params) {
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP params) {
        recordField.getType().accept(this, params);
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP params) {
        recordType.getFields().forEach(rf -> rf.accept(this, params));
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP params) {
        return null;
    }
}
