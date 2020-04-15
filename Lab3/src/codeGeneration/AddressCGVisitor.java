package codeGeneration;

public class AddressCGVisitor extends AbstractCGVisitor<,> {

        //################################VARIABLE###################################
        /*
        address[[Variable: exp -> ID]] =
            if(exp.definition.scope==0)         // this is global
		        <pusha > exp.definition.offset
	        else {                              // this is local
	            <push bp>
		        <pusha > exp.definition.offset
		        <addi>
            }
        */


}
