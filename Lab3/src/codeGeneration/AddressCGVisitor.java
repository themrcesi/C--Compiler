package codeGeneration;

import ast.definitions.VarDefinition;
import ast.expressions.Variable;

public class AddressCGVisitor extends AbstractCGVisitor<Void,Void> {

    private CodeGeneration cg;

    public AddressCGVisitor(CodeGeneration cg)
    {
        this.cg = cg;
    }

    //################################VARIABLE##################################
    @Override
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
    public Void visit(Variable variable, Void params) {
        if(variable.getDefinition().getScope()==0) //GLOBAL
            cg.pusha(((VarDefinition)variable.getDefinition()).getOffset());
        else
        {
            cg.pushbp();
            cg.push(variable.getType(),((VarDefinition)variable.getDefinition()).getOffset());
            cg.addi();
        }
        return null;
    }

    /*
    address[[Indexing: exp1 -> exp2 exp3]] =
        address[[exp2]] //base address
        value[[exp3]]   //index
        <pushi > exp1.numberOfBytes()   // nob of array type
        <muli>
        <addi>
     */

    /*
    address[[Access: exp1 -> exp2 ID]] =
        address[[exp2]]
        <pushi > exp2.getType().getField(exp1.member).offset
        <addi>
     */

}
