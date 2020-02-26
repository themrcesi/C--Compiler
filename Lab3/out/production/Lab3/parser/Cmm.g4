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

definition returns [Definition ast]:
        v = variable_definition { $ast = $v.ast; }
        |   f = function_definition { $ast = $f.ast; }
        ;

function_definition returns [FunctionDefinition ast]:
         t = type n = ID '(' p = parameter ')' '{' b = function_body '}'
        ;

function_body: variable_definition* statement*;

parameter returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
        b1 = built_in_type i1 = ID { $ast.add(new VarDefinition($b1.ast.getLine(), $b1.ast.getCharPositionInLine(), $b1.ast, $i1.text)); }
            (',' b2 = built_in_type i2 = ID { $ast.add(new VarDefinition($b2.ast.getLine(), $b2.ast.getCharPositionInLine(), $b2.ast, $i2.text)); })*
        |
        ;

variable_definition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
        t = type i1 = ID { $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getCharPositionInLine()+1, $t.ast, $i1.text)); }
            (',' i2 = ID { $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getCharPositionInLine()+1, $t.ast, $i2.text)); })* ';'
        ;

type returns [Type ast]
    locals[List<RecordField> rfs = new ArrayList<RecordField>()]:
        bt = built_in_type  { $ast = $bt.ast; }
    |   t = type '[' s = INT_CONSTANT ']'   { $ast = new ArrayType($t.ast.getLine(), $t.ast.getCharPositionInLine()+1, LexerHelper.lexemeToInt($s.text)); }
    |   n = 'struct' '{' (rf = record_field { for(RecordField r: $rf) $rfs.add(r); })* '}' { $ast = new RecordType($n.getLine(), $n.getCharPositionInLine()+1, $rfs); }
    |   v = 'void' { $ast = new VoidType($v.getLine(), $v.getCharPositionInLine()+1); }
    ;

record_field returns [List<RecordField> ast = new ArrayList<RecordField>()]:
            t = type i1 = ID { $ast.add(new RecordField($t.ast.getLine(), $t.getCharPositionInLine()+1, $t.ast, $i1.text)); }
                (',' i2 = ID { $ast.add(new RecordField($t.ast.getLine(), $t.getCharPositionInLine()+1, $t.ast, $i2.text)); })* ';'
            ;

built_in_type returns [Type ast]:  t = 'int'    { $ast = new IntType($t.getLine(), $t.getCharPositionInLine()+1); }
            |   t = 'double'    { $ast = new DoubleType($t.getLine(), $t.getCharPositionInLine()+1); }
            |   t = 'char'  { $ast = new CharType($t.getLine(), $t.getCharPositionInLine()+1); }
            ;

statement returns [List<Statement> ast = new ArrayList<Statement>()]
        locals[Statement stmt]:
            'while' '(' e1 = expression ')' b = block    { $ast.add(new While($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $e1.ast, $b.ast)); }
        |   'if' '(' e1 = expression ')' b = block { $stmt = new If($e1.ast.getLine(), $e1.ast.getCharPositionInLine()+1, $e1.ast, $b.ast); }
                ('else' b2 = block { ((If)$stmt).setElse($b2.ast); })?    { $ast.add($stmt); }
        |   e1 = expression '=' e2 = expression ';'   { $ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getCharPositionInLine(), $e1.ast, $e2.ast)); }
        |   t = 'read' exs = expressions ';' { for(Expression e: $exs) $ast.add(new Read($t.getLine(), $t.getCharPositionInLine()+1, e)); }
        |   t = 'write' exs = expressions ';' { for(Expression e: $exs) $ast.add(new Read($t.getLine(), $t.getCharPositionInLine()+1, e)); }
        |   t = 'return' e = expression ';' { $ast.add(new Return($t.getLine(), $t.getCharPositionInLine(), $e.ast)); }
        |   f = function_invocation ';' { $ast.add($f.ast); }
        ;

expressions returns [List<Expression> ast = new ArrayList<Expression>()]:
            es = expression  { $ast.add($es.ast); }
        |   em1 = expression { $ast.add($em1.ast); }
                            (',' em2 = expression { $ast.add($em2.ast); })*
        ;

function_invocation returns [Invocation ast]:
        v = ID '(' as = arguments ')' { $ast = new Invocation($v.getLine(), $v.getCharPositionInLine()+1, new Variable($v.text), $as.ast); }
        ;

arguments returns [List<Expression> ast = new ArrayList<Expression>()]:
            es = expression  { $ast.add($es.ast); }
        |   em1 = expression { $ast.add($em1.ast); }
                            (',' em2 = expression { $ast.add($em2.ast); })*
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




