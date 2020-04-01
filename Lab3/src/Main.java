import ast.ASTNode;
import ast.Program;
import codeGeneration.OffsetVisitor;
import errorHandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import parser.*;

import org.antlr.v4.runtime.*;
import semantics.IdentificationVisitor;
import semantics.TypeCheckingVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		CmmParser parser = new CmmParser(tokens);
		
		Program root = parser.program().ast;

		IdentificationVisitor ivisitor = new IdentificationVisitor();
		root.accept(ivisitor,null);
		TypeCheckingVisitor tvisitor = new TypeCheckingVisitor();
		root.accept(tvisitor,null);

		OffsetVisitor oVisitor = new OffsetVisitor();
		root.accept(oVisitor, null);

		IntrospectorModel model = new IntrospectorModel("Root", root);
		new IntrospectorTree("Tree", model);

		ErrorHandler.getInstanceOf().showErrors(System.err);
	}
	

}
