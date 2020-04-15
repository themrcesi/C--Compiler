package codeGeneration;

public class ExecuteCGVisitor extends AbstractCGVisitor<,> {

        /*
        ###################################READ#####################################
        execute[[Read: st -> exp]] =
            address[[exp]]
            <in> exp.type.suffix()
            <store> exp.type.suffix()
        */

        /*
        ##################################WRITE#####################################
        execute[[Write: st -> exp]] =
            value[[exp]]
            <out> exp.type.suffix()
        */

        /*
        #############################ASSIGNMENT####################################
        execute[[Assignment: st -> exp1 exp2]] =
            address[[exp1]]
            value[[exp2]]
            <load> exp1.type.suffix()
        */

        /*
        #####################################VAR DEFINITIONS######################
        execute[[VarDefinition: varDefinition -> type ID]] =
	        <' * > type.toString() ID <( offset > varDefinition.offset <)>
         */

        /*
        #####################################FUNC DEFINITIONS######################
        execute[[FuncDefinition: funcDefinition -> type ID varDefinition* statement*]] =
            ID<:>
            execute[[type]]
            <' * Local variables:>
            varDefinition*.foreach(vd -> execute[[vd]]())

            int bytesParams = 0;
            for(VarDefinition vd: type.parameters)
                bytesParams += vd.type.numberOfBytes()

            int bytesLocals = 0;
            if(varDefinition*.size()>0)
                bytesLocals = -varDefinition*.get(varDefinition*.size()-1).offset
            <enter > bytesLocals

            int bytesReturn = type.returnType.numberOfBytes();

            statement*.foreach(st -> execute[[st]](bytesLocals, bytesParams, bytesReturn))

            if(bytesReturn==0) //no return
                <ret > bytesReturn, bytesLocals, bytesParams
         */

        /*
        execute [[FuncType : type1 -> type2 varDefinition*]] =
            <' * Parameters:>
            varDefinition*.forEach(vd -> {
                execute[[vd]]()
            })
        */

        /*
        execute[[Return: statement -> expression]](int bytesLocals, int byteParams, int bytesReturn) =
            value[[exp]]
            ret bytesReturn, bytesLocals, bytesParams
         */

        /*
        ###############################################PROGRAM#########################################
        execute[[Program: program -> varDefinition* funcDefinition*]] =
            < ' * Global variables:>
            varDefinition.forEach(vd -> execute[[vd]]())

            <call main>
            <halt>

            funcDefinition*.forEach(fd -> execute[[fd]]())
         */

}
