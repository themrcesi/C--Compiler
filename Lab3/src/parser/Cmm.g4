grammar Cmm;

@header {
    import ast.*;
    import ast.types.*;
    import java.util.*;
}

program: (variable_definition|function_definition)* main
       ;

main: 'void' 'main' '(' ')' '{' function_body '}'
    ;

definition: variable_definition
        |   function_definition
        ;

function_definition: (built_in_type|'void') ID '(' parameter ')' '{' function_body '}'
        ;

function_body: variable_definition* statement*;

parameter: built_in_type ID (',' built_in_type ID)*
        |
        ;

variable_definition: type ID (',' ID)* ';'
        ;

type:   built_in_type
    |   type '[' INT_CONSTANT ']'
    |   'struct' '{' record_field* '}'
    ;

record_field: type ID (',' ID)* ';'
            ;

built_in_type:  'int'
            |   'double'
            |   'char'
            ;

statement: 'while' '(' expression ')' block
        |   'if' '(' expression ')' block ('else' block)?
        |   expression '=' expression ';'
        |   'read' argument ';'
        |   'write' argument ';'
        |   'return' (expression|'void') ';'
        |   function_invocation ';'
        ;

function_invocation: ID '(' argument ')';

argument:  expression
        |   expression (',' expression)*
        |
        ;

block returns [List<Statement> ast = new ArrayList<Statement>()]:
        ss = statement   { $ast.add($ss.ast); }
    |   '{' (sm = statement  { $ast.add($sm.ast); })* '}'
    ;

expression returns [Expression ast]:
            fi = function_invocation    { $ast = $fi.ast; }
        |   '(' type = built_in_type ')' e1 = expression    { $ast = new Indexing($type.ast.getLine(), $type.ast.getCharPositionInLine()+1, $type.ast, $e1.ast); }
        |   e1 = expression '[' e2 = expression ']'   { $ast = new Indexing($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $e1.ast, $e2.ast); }
        |   e1 = expression '.' v = ID    { $ast = new Access($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $e1.ast, $v.text); }
        |   t = '-' e1 = expression { $ast = new UnaryMinus($t.getLine(), $t.getCharPositionInLine()+1, $e1.ast); }
        |   e1= expression op = ('*'|'/'|'%') e2 = expression { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $op.text, $e1.ast, $e2.ast); }
        |   e1 = expression op = ('+'|'-') e2 = expression  { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $op.text, $e1.ast, $e2.ast); }
        |   e1 = expression op = ('>'|'>='|'<'|'<='|'!='|'==') e2 = expression  { $ast = new Comparisson($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $op.text, $e1.ast, $e2.ast); }
        |   e1 = expression op = ('&&'|'||') e2 = expression   { $ast = new Logical($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $op.text, $e1.ast, $e2.ast); }
        |   t = '!' e1 = expression { $ast = new UnaryNot($t.getLine(), $t.getCharPositionInLine()+1, $e1.ast); }
        |   t = CHAR_CONSTANT   { $ast = new CharLiteral($t.getLine(), $t.getCharPositionInLine()+1, LexerHelper.lexemeToChar($t.text)); }
        |   t = REAL_CONSTANT   { $ast = new DoubleLiteral($t.getLine(), $t.getCharPositionInLine()+1, LexerHelper.lexemeToReal($t.text)); }
        |   t = INT_CONSTANT    { $ast = new IntLiteral($t.getLine(), $t.getCharPositionInLine()+1, LexerHelper.lexemeToInt($t.text)); }
        |   t = ID  { $ast = new Variable($t.getLine(), $t.getCharPositionInLine()+1, $t.text); }
        ;

fragment
LETTER: [a-zA-Z]
      ;

fragment
DIGIT: [0-9]
    ;

fragment
SPECIAL_CHARACTERS: ('\'\\n\'')
                   | ('\'\\t\'')
            ;

fragment
FLOATING_POINT: (INT_CONSTANT'.'DIGIT*)
               |(INT_CONSTANT?'.'DIGIT+)
    ;

fragment
MANTISSA_EXPONENT: (FLOATING_POINT|INT_CONSTANT)[Ee][+-]?INT_CONSTANT
                ;
  		 
INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;

ID: (LETTER|'_')(LETTER|DIGIT|'_')*
    ;

REAL_CONSTANT: FLOATING_POINT
            | MANTISSA_EXPONENT
            ;

CHAR_CONSTANT: '\''.'\''
            | '\'\\'INT_CONSTANT'\''
            | SPECIAL_CHARACTERS
            ;


WHITE_SPACES: [ \t\n\r]+ -> skip
            ;

ONE_LINE_COMMENT: '//'.*?('\n'|'\r'|EOF) -> skip
                ;

MULTIPLE_LINE_COMMENT: '/*'.*?('*/') -> skip
                    ;




