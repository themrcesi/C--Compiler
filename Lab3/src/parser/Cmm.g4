grammar Cmm;	

program:
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




