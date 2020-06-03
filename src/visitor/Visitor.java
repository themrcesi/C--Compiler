package visitor;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP, TR> {

    public TR visit(Program program, TP params);
    public TR visit(FunctionDefinition funcDef, TP params);
    public TR visit(VarDefinition varDef, TP params);
    public TR visit(Access access, TP params);
    public TR visit(Arithmetic arithmetic, TP params);
    public TR visit(Cast cast, TP params);
    public TR visit(CharLiteral charLiteral, TP params);
    public TR visit(Comparisson comparisson, TP params);
    public TR visit(DoubleLiteral doubleLiteral, TP params);
    public TR visit(Indexing indexing, TP params);
    public TR visit(IntLiteral intLiteral, TP params);
    public TR visit(Logical logical, TP params);
    public TR visit(UnaryMinus unaryMinus, TP params);
    public TR visit(Variable variable, TP params);
    public TR visit(Assignment assignment, TP params);
    public TR visit(If ifelse, TP params);
    public TR visit(Invocation invocation, TP params);
    public TR visit(Read read, TP params);
    public TR visit(Return returnStatement, TP params);
    public TR visit(While whileStatement, TP params);
    public TR visit(Write write, TP params);
    public TR visit(ArrayType arrayType, TP params);
    public TR visit(CharType charType, TP params);
    public TR visit(DoubleType doubleType, TP params);
    public TR visit(ErrorType errorType, TP params);
    public TR visit(FunctionType funcType, TP params);
    public TR visit(IntType intType, TP params);
    public TR visit(RecordField recordField, TP params);
    public TR visit(RecordType recordType, TP params);
    public TR visit(VoidType voidType, TP params);
    public TR visit(UnaryNot unaryNot, TP param);
}
