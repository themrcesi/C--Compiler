package codeGeneration;

public class ValueCGVisitor extends AbstractCGVisitor<,> {


    //################################CONSTANTS###################################
    /*
    value[[CharLiteral: exp -> CHAR_CONSTANT]] =
        <push>exp.type.suffix()< >(int)exp.value
    */

    /*
    value[[IntLiteral: exp -> INT_CONSTANT]] =
        <push>exp.type.suffix()< >exp.value
    */

    /*
    value[[DoubleLiteral: exp -> DOUBLE_CONSTANT]] =
        <push>exp.type.suffix()< >exp.value
    */

    //################################VARIABLE###################################
    /*
    value[[Variable: exp -> ID]] =
        address[[exp]]
        <load> exp.type.suffix()
    */

    /*
    ####################################CAST##################################
    value[[Cast: exp1 -> type exp2]] =
        value[[exp2]]
        exp2.type.convertTo(exp1.type)
    */

    /*
    #############################ARITHMETIC OPERATION#########################
    value[[Arithmetic: exp1 -> exp2 (+|-|*|/) exp3]] =
        value[[exp2]]
        exp2.type.convertTo(exp1.type)  // cg.cast(exp2.type,exp1.type)
        value[[exp3]]
        exp3.type.convertTo(exp1.type)  // cg.cast(exp3.type,exp1.type)
        switch(exp1.operator) {                         cg.arithmetic(exp1.operator, exp1.type)
            case "+": <add> exp1.type.suffix() break;
            case "-": <add> exp1.type.suffix() break;
            case "*": <add> exp1.type.suffix() break;
            case "/": <add> exp1.type.suffix() break;
        }
     */

    /*
    #############################COMPARISON OPERATION#########################
    value[[Comparisson: exp1 -> exp2 (>|<|>=|<=|!=|==) exp3]] =
        value[[exp2]]
        value[[exp3]]
        switch(exp1.operator) {     cg.comparison(exp1.operator)
            case ">": <gt> break;
            case "<": <lt> break;
            case ">=": <ge> break;
            case "<=": <le> break;
            case "==": <eq> break;
            case "!=": <ne> break;
        }
     */

    /*
    value[[Logical: exp1 -> exp2 (&&|||) exp3]] =
        value[[exp2]]
        value[[exp3]]
        switch(exp1.operator) {         cg.logical(exp1.operator)
            case "&&": <and> break;
            case "||": <or>  break;
        }
     */
}
