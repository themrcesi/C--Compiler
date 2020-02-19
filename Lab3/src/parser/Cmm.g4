grammar Cmm;	

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
        |   function_invocation
        ;

function_invocation: ID '(' argument ')' ';';

argument:  expression
        |   expression (',' expression)*
        |
        ;

block:  statement
    |   '{' statement* '}'
    ;

expression: function_invocation
        |   '(' built_in_type ')' expression
        |   expression '[' expression ']'
        |   expression '.' ID
        |   '-' expression
        |   expression ('*'|'/'|'%') expression
        |   expression ('+'|'-') expression
        |   expression ('>'|'>='|'<'|'<='|'!='|'==') expression
        |   expression ('&&'|'||') expression
        |   '!' expression
        |   CHAR_CONSTANT
        |   REAL_CONSTANT
        |   INT_CONSTANT
        |   ID
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




