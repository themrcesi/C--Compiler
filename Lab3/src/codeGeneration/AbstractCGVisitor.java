package codeGeneration;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public class AbstractCGVisitor<TP,TR> implements Visitor<TP,TR> {

    @Override
    public TR visit(Program program, TP params) {
        throw new IllegalStateException("Program is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(FunctionDefinition funcDef, TP params) {
        throw new IllegalStateException("Function definition is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(VarDefinition varDef, TP params) {
        throw new IllegalStateException("Variable definition is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Access access, TP params) {
        throw new IllegalStateException("Access is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP params) {
        throw new IllegalStateException("Arithmetic operation is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Cast cast, TP params) {
        throw new IllegalStateException("Cast is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP params) {
        throw new IllegalStateException("Char literal is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Comparisson comparisson, TP params) {
        throw new IllegalStateException("Comparison operator is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP params) {
        throw new IllegalStateException("Double literal is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Indexing indexing, TP params) {
        throw new IllegalStateException("Indexing is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP params) {
        throw new IllegalStateException("Int literal is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Logical logical, TP params) {
        throw new IllegalStateException("Logical operation is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP params) {
        throw new IllegalStateException("Unary minus is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Variable variable, TP params) {
        throw new IllegalStateException("Variable is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Assignment assignment, TP params) {
        throw new IllegalStateException("Asignment is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(If ifelse, TP params) {
        throw new IllegalStateException("If is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Invocation invocation, TP params) {
        throw new IllegalStateException("Invocation is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Read read, TP params) {
        throw new IllegalStateException("Read is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Return returnStatement, TP params) {
        throw new IllegalStateException("Return is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(While whileStatement, TP params) {
        throw new IllegalStateException("While is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(Write write, TP params) {
        throw new IllegalStateException("Write is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(ArrayType arrayType, TP params) {
        throw new IllegalStateException("Array type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(CharType charType, TP params) {
        throw new IllegalStateException("Char type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(DoubleType doubleType, TP params) {
        throw new IllegalStateException("Double type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(ErrorType errorType, TP params) {
        throw new IllegalStateException("Error type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(FunctionType funcType, TP params) {
        throw new IllegalStateException("Function type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(IntType intType, TP params) {
        throw new IllegalStateException("Int type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(RecordField recordField, TP params) {
        throw new IllegalStateException("Record field is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(RecordType recordType, TP params) {
        throw new IllegalStateException("Record type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(VoidType voidType, TP params) {
        throw new IllegalStateException("Void type is not supported by '"+this.getClass().getName()+"'");
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        throw new IllegalStateException("Unary not is not supported by '"+this.getClass().getName()+"'");
    }
}
