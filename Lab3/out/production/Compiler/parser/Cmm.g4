grammar Cmm;

@header {
    import ast.*;
    import ast.types.*;
    import java.util.*;
}

program returns [Program ast]
        locals[List<Definition> defs = new ArrayList<Definition>()]:
        (d = definition { for(Definition def :$d.ast) $defs.add(def); })* m = main {
            $defs.add($m.ast);
            $ast = new Program(1,1, $defs); } EOF
       ;

main returns [FunctionDefinition ast]:
        t = 'void' n = 'main' '(' ')' '{' b = function_body '}'
        {   FunctionType ft = new FunctionType($n.getLine(), $n.getCharPositionInLine()+1, new VoidType($t.getLine(), $t.getCharPositionInLine()), new ArrayList<VarDefinition>());
            $ast = new FunctionDefinition($n.getLine(), $n.getCharPositionInLine()+1, $n.text, ft, $b.ast); }
        ;

definition returns [List<Definition> ast = new ArrayList<Definition>()]:
        v = variable_definition { for(VarDefinition d: $v.ast) $ast.add(d); }
        |   f = function_definition { $ast.add($f.ast); }
        ;

function_definition returns [FunctionDefinition ast]:
            t = type n = ID '(' p = parameter ')' '{' b = function_body '}'
            {   FunctionType ft = new FunctionType($n.getLine(), $n.getCharPositionInLine()+1, $t.ast, $p.ast);
                $ast = new FunctionDefinition($n.getLine(), $n.getCharPositionInLine()+1, $n.text, ft, $b.ast); }
            |   t2 = 'void' n = ID '(' p = parameter ')' '{' b = function_body '}'
                {   FunctionType ft = new FunctionType($n.getLine(), $n.getCharPositionInLine()+1, new VoidType($t2.getLine(), $t2.getCharPositionInLine()), $p.ast);
                    $ast = new FunctionDefinition($n.getLine(), $n.getCharPositionInLine()+1, $n.text, ft, $b.ast); }
        ;

variable_definition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
        t = type i1 = ID { $ast.add(new VarDefinition($i1.getLine(), $i1.getCharPositionInLine()+1, $t.ast, $i1.text)); }
            (',' i2 = ID { $ast.add(new VarDefinition($i2.getLine(), $i2.getCharPositionInLine()+1, $t.ast, $i2.text)); })* ';'
        ;

function_body returns [List<Statement> ast = new ArrayList<Statement>()]:
        (v = variable_definition { for(VarDefinition vd: $v.ast) $ast.add(vd); })* (s = statement { for(Statement st: $s.ast) $ast.add(st); })*;

parameter returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
        b1 = built_in_type i1 = ID { $ast.add(new VarDefinition($b1.ast.getLine(), $b1.ast.getColumn(), $b1.ast, $i1.text)); }
            (',' b2 = built_in_type i2 = ID { $ast.add(new VarDefinition($b2.ast.getLine(), $b2.ast.getColumn(), $b2.ast, $i2.text)); })*
        |
        ;

type returns [Type ast]
    locals[List<RecordField> rfs = new ArrayList<RecordField>()]:
        bt = built_in_type  { $ast = $bt.ast; }
    |   t = type { $ast = $t.ast; }  ('[' s = INT_CONSTANT ']'   {
            Type prev = $ast;
            if (prev instanceof ArrayType)   {
                ((ArrayType)prev).setType(new ArrayType(prev.getLine(), prev.getColumn(), ((ArrayType)prev).getType(), LexerHelper.lexemeToInt($s.text)));
                $ast = prev;
            }
            else
                $ast = new ArrayType(prev.getLine(), prev.getColumn(), prev, LexerHelper.lexemeToInt($s.text)); })+
    |   n = 'struct' '{' (rf = record_field { for(RecordField r: $rf.ast) $rfs.add(r); })* '}' { $ast = new RecordType($n.getLine(), $n.getCharPositionInLine()+1, $rfs); }
    ;

record_field returns [List<RecordField> ast = new ArrayList<RecordField>()]:
            t = type i1 = ID { $ast.add(new RecordField($i1.getLine(), $i1.getCharPositionInLine()+1, $t.ast, $i1.text)); }
                (',' i2 = ID { $ast.add(new RecordField($i2.getLine(), $i2.getCharPositionInLine()+1, $t.ast, $i2.text)); })* ';'
            ;

built_in_type returns [Type ast]:  t = 'int'    { $ast = new IntType($t.getLine(), $t.getCharPositionInLine()+1); }
            |   t = 'double'    { $ast = new DoubleType($t.getLine(), $t.getCharPositionInLine()+1); }
            |   t = 'char'  { $ast = new CharType($t.getLine(), $t.getCharPositionInLine()+1); }
            ;

statement returns [List<Statement> ast = new ArrayList<Statement>()]
        locals[Statement stmt]:
            'while' '(' e1 = expression ')' b = block    { $ast.add(new While($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b.ast)); }
        |   'if' '(' e1 = expression ')' b = block { $stmt = new If($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b.ast); }
                ('else' b2 = block { ((If)$stmt).setElse($b2.ast); })?    { $ast.add($stmt); }
        |   e1 = expression '=' e2 = expression ';'   { $ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast)); }
        |   t = 'read' exs = expressions ';' { for(Expression e: $exs.ast) $ast.add(new Read($t.getLine(), $t.getCharPositionInLine()+1, e)); }
        |   t = 'write' exs = expressions ';' { for(Expression e: $exs.ast) $ast.add(new Write($t.getLine(), $t.getCharPositionInLine()+1, e)); }
        |   t = 'return' e = expression ';' { $ast.add(new Return($t.getLine(), $t.getCharPositionInLine(), $e.ast)); }
        |   f = function_invocation ';' { $ast.add($f.ast); }
        ;

expressions returns [List<Expression> ast = new ArrayList<Expression>()]:
            es = expression  { $ast.add($es.ast); }
        |   em1 = expression { $ast.add($em1.ast); }
                            (',' em2 = expression { $ast.add($em2.ast); })*
        ;

function_invocation returns [Invocation ast]:
        v = ID '(' as = arguments ')' { $ast = new Invocation($v.getLine(), $v.getCharPositionInLine()+1, new Variable($v.getLine(), $v.getCharPositionInLine()+1, $v.text), $as.ast); }
        ;

arguments returns [List<Expression> ast = new ArrayList<Expression>()]:
            es = expression  { $ast.add($es.ast); }
        |   em1 = expression { $ast.add($em1.ast); }
                            (',' em2 = expression { $ast.add($em2.ast); })*
        |
        ;

block returns [List<Statement> ast = new ArrayList<Statement>()]:
        ss = statement   { for(Statement s:$ss.ast) $ast.add(s); }
    |   '{' (sm = statement  { for(Statement s:$sm.ast) $ast.add(s); })* '}'
    ;

expression returns [Expression ast]:
            '(' e1 = expression ')' { $ast = $e1.ast; }
        |   '[' e1 = expression ']' { $ast = $e1.ast; }
        |   e1 = expression '.' v = ID    { $ast = new Access($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $v.text); }
        |   '(' ty = type ')' e1 = expression    { $ast = new Cast($ty.ast.getLine(), $ty.ast.getColumn(), $ty.ast, $e1.ast); }
        |   e1 = expression '[' e2 = expression ']'   { $ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast); }
        |   t = '-' e1 = expression { $ast = new UnaryMinus($t.getLine(), $t.getCharPositionInLine()+1, $e1.ast); }
        |   e1= expression op = ('*'|'/'|'%') e2 = expression { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
        |   e1 = expression op = ('+'|'-') e2 = expression  { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
        |   e1 = expression op = ('>'|'>='|'<'|'<='|'!='|'==') e2 = expression  { $ast = new Comparisson($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
        |   t = '!' e1 = expression { $ast = new UnaryNot($t.getLine(), $t.getCharPositionInLine()+1, $e1.ast); }
        |   e1 = expression op = ('&&'|'||') e2 = expression   { $ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
        |   fi = function_invocation    { $ast = $fi.ast; }
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




