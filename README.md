# C-- Compiler

This is a compiler for the [C--](https://en.wikipedia.org/wiki/C--) language developed in Java using [ANTLR](https://www.antlr.org/).

It was developed in the course Programming Language Design of the [Software Engineer Degree](https://ingenieriainformatica.uniovi.es/infoacademica/grado) at the [University of Oviedo](http://www.uniovi.es/).

## Language description
The description of the language is the following:
+ A program is a sequence of variable and function definitions.
+ The syntax of a variable definition is a type followed by a non-empty enumeration of comma-separated identifiers. 
  + Variable definitions must end with the ";" character.
+ Functions are defined specifying the return type, the function identifier and a list of coma-separated parameters between ( and ). 
  + The return type and parameter types must be built-in (i.e., no arrays or records).
  + The function body goes between { and }.
  + The bodies of functions are sequences of variable definitions followed by sequences of statements. Both must end with the ";" character.
+ The last and mandatory function is "main", which returns void and receives no parameters.
+ Data types
  + Built-in types are "int", "double" and "char". 
  + Array types can be created with the "[]" type constructor, following the Java syntax but specifying the size of the array with an integer constant (like C). 
  + The "struct" type constructor is added for specifying record types. Records have no type identifier, and fields are declared as var definitions between { and }. 
  + Type definition (i.e., typedef) is not supported.
+ Statements
  + The syntax of a write statement is the "write" keyword followed by a non-empty comma-separated list of expressions. 
  + The read statement is similar, but using the "read" keyword.
  Assignments are built with two expressions separated by the "=" operator.
  + If / else and while statements follow the C syntax. 
  + The return <expression> statement is also supported (the expression is mandatory).
  + A function invocation may be an expression or a statement. A procedure invocation is always a statement.
+ Expressions
  + The cast expression follows the C syntax.
  + Expressions are built with:
    + Integer, real and character constants without sign.
    + Identifiers.
    + The following operators applied to one or two expressions (descending order of precedence):
      + ( )		Non associative
      + []		Non associative
      + .		Non associative
      +  (unary)	Non associative
      +  \* / %		Left associative
      +  \+ -		Left associative
      +  \> >= < <= != ==		Left associative
      +  && || !		Left associative

## Phases

Building the compiler, the work could be divided into:
1. Lexical Analysis: recognize all the accepted lexemes and generate the associated tokens.
2. Syntactical Analysis: build the AST from the tokens.
3. Semantical Analisis: annotate the AST with extra information.
   1. Identification Phase
   2. Type Checking Phase
4. Code Generation: writting the MAPL code for every AST element.

## Executing programs

In the `/examples` folder you can find some basic programs as example. 

1. You need to execute the project passing as input the program file and the output file for the MAPL code.
2. Execute the output file with the MAPL application in `/MAPL`.


