// Generated from D:/OneDrive - Universidad de Oviedo/Documentos/Universidad/España_3-4/DLP/Programming-Language-Design/Lab3/src/parser\Cmm.g4 by ANTLR 4.8
package parser;

    import ast.*;
    import ast.types.*;
    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, INT_CONSTANT=37, ID=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, WHITE_SPACES=41, ONE_LINE_COMMENT=42, 
		MULTIPLE_LINE_COMMENT=43;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_definition = 2, RULE_function_definition = 3, 
		RULE_variable_definition = 4, RULE_function_body = 5, RULE_parameter = 6, 
		RULE_type = 7, RULE_record_field = 8, RULE_built_in_type = 9, RULE_statement = 10, 
		RULE_expressions = 11, RULE_function_invocation = 12, RULE_arguments = 13, 
		RULE_block = 14, RULE_expression = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "definition", "function_definition", "variable_definition", 
			"function_body", "parameter", "type", "record_field", "built_in_type", 
			"statement", "expressions", "function_invocation", "arguments", "block", 
			"expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'main'", "'('", "')'", "'{'", "'}'", "','", "';'", "'['", 
			"']'", "'struct'", "'int'", "'double'", "'char'", "'while'", "'if'", 
			"'else'", "'='", "'read'", "'write'", "'return'", "'.'", "'-'", "'*'", 
			"'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'!'", 
			"'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT_CONSTANT", "ID", "REAL_CONSTANT", "CHAR_CONSTANT", "WHITE_SPACES", 
			"ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> defs = new ArrayList<Definition>();
		public DefinitionContext d;
		public MainContext m;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(32);
					((ProgramContext)_localctx).d = definition();
					 for(Definition def :((ProgramContext)_localctx).d.ast) _localctx.defs.add(def); 
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(40);
			((ProgramContext)_localctx).m = main();

			            _localctx.defs.add(((ProgramContext)_localctx).m.ast);
			            ((ProgramContext)_localctx).ast =  new Program(1,1, _localctx.defs); 
			setState(42);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Token t;
		public Token n;
		public Function_bodyContext b;
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			((MainContext)_localctx).t = match(T__0);
			setState(45);
			((MainContext)_localctx).n = match(T__1);
			setState(46);
			match(T__2);
			setState(47);
			match(T__3);
			setState(48);
			match(T__4);
			setState(49);
			((MainContext)_localctx).b = function_body();
			setState(50);
			match(T__5);
			   FunctionType ft = new FunctionType(((MainContext)_localctx).n.getLine(), ((MainContext)_localctx).n.getCharPositionInLine()+1, new VoidType(((MainContext)_localctx).t.getLine(), ((MainContext)_localctx).t.getCharPositionInLine()), new ArrayList<VarDefinition>());
			            ((MainContext)_localctx).ast =  new FunctionDefinition(((MainContext)_localctx).n.getLine(), ((MainContext)_localctx).n.getCharPositionInLine()+1, (((MainContext)_localctx).n!=null?((MainContext)_localctx).n.getText():null), ft, ((MainContext)_localctx).b.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Variable_definitionContext v;
		public Function_definitionContext f;
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				((DefinitionContext)_localctx).v = variable_definition();
				 for(VarDefinition d: ((DefinitionContext)_localctx).v.ast) _localctx.ast.add(d); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				((DefinitionContext)_localctx).f = function_definition();
				 _localctx.ast.add(((DefinitionContext)_localctx).f.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public TypeContext t;
		public Token n;
		public ParameterContext p;
		public Function_bodyContext b;
		public Token t2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_definition);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				((Function_definitionContext)_localctx).t = type(0);
				setState(62);
				((Function_definitionContext)_localctx).n = match(ID);
				setState(63);
				match(T__2);
				setState(64);
				((Function_definitionContext)_localctx).p = parameter();
				setState(65);
				match(T__3);
				setState(66);
				match(T__4);
				setState(67);
				((Function_definitionContext)_localctx).b = function_body();
				setState(68);
				match(T__5);
				   FunctionType ft = new FunctionType(((Function_definitionContext)_localctx).n.getLine(), ((Function_definitionContext)_localctx).n.getCharPositionInLine()+1, ((Function_definitionContext)_localctx).t.ast, ((Function_definitionContext)_localctx).p.ast);
				                ((Function_definitionContext)_localctx).ast =  new FunctionDefinition(((Function_definitionContext)_localctx).n.getLine(), ((Function_definitionContext)_localctx).n.getCharPositionInLine()+1, (((Function_definitionContext)_localctx).n!=null?((Function_definitionContext)_localctx).n.getText():null), ft, ((Function_definitionContext)_localctx).b.ast); 
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				((Function_definitionContext)_localctx).t2 = match(T__0);
				setState(72);
				((Function_definitionContext)_localctx).n = match(ID);
				setState(73);
				match(T__2);
				setState(74);
				((Function_definitionContext)_localctx).p = parameter();
				setState(75);
				match(T__3);
				setState(76);
				match(T__4);
				setState(77);
				((Function_definitionContext)_localctx).b = function_body();
				setState(78);
				match(T__5);
				   FunctionType ft = new FunctionType(((Function_definitionContext)_localctx).n.getLine(), ((Function_definitionContext)_localctx).n.getCharPositionInLine()+1, new VoidType(((Function_definitionContext)_localctx).t2.getLine(), ((Function_definitionContext)_localctx).t2.getCharPositionInLine()), ((Function_definitionContext)_localctx).p.ast);
				                    ((Function_definitionContext)_localctx).ast =  new FunctionDefinition(((Function_definitionContext)_localctx).n.getLine(), ((Function_definitionContext)_localctx).n.getCharPositionInLine()+1, (((Function_definitionContext)_localctx).n!=null?((Function_definitionContext)_localctx).n.getText():null), ft, ((Function_definitionContext)_localctx).b.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_definitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext t;
		public Token i1;
		public Token i2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((Variable_definitionContext)_localctx).t = type(0);
			setState(84);
			((Variable_definitionContext)_localctx).i1 = match(ID);
			 _localctx.ast.add(new VarDefinition(((Variable_definitionContext)_localctx).i1.getLine(), ((Variable_definitionContext)_localctx).i1.getCharPositionInLine()+1, ((Variable_definitionContext)_localctx).t.ast, (((Variable_definitionContext)_localctx).i1!=null?((Variable_definitionContext)_localctx).i1.getText():null))); 
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(86);
				match(T__6);
				setState(87);
				((Variable_definitionContext)_localctx).i2 = match(ID);
				 _localctx.ast.add(new VarDefinition(((Variable_definitionContext)_localctx).i2.getLine(), ((Variable_definitionContext)_localctx).i2.getCharPositionInLine()+1, ((Variable_definitionContext)_localctx).t.ast, (((Variable_definitionContext)_localctx).i2!=null?((Variable_definitionContext)_localctx).i2.getText():null))); 
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Variable_definitionContext v;
		public StatementContext s;
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				{
				setState(96);
				((Function_bodyContext)_localctx).v = variable_definition();
				 for(VarDefinition vd: ((Function_bodyContext)_localctx).v.ast) _localctx.ast.add(vd); 
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__33) | (1L << INT_CONSTANT) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(104);
				((Function_bodyContext)_localctx).s = statement();
				 for(Statement st: ((Function_bodyContext)_localctx).s.ast) _localctx.ast.add(st); 
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public Built_in_typeContext b1;
		public Token i1;
		public Built_in_typeContext b2;
		public Token i2;
		public List<Built_in_typeContext> built_in_type() {
			return getRuleContexts(Built_in_typeContext.class);
		}
		public Built_in_typeContext built_in_type(int i) {
			return getRuleContext(Built_in_typeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				((ParameterContext)_localctx).b1 = built_in_type();
				setState(113);
				((ParameterContext)_localctx).i1 = match(ID);
				 _localctx.ast.add(new VarDefinition(((ParameterContext)_localctx).b1.ast.getLine(), ((ParameterContext)_localctx).b1.ast.getColumn(), ((ParameterContext)_localctx).b1.ast, (((ParameterContext)_localctx).i1!=null?((ParameterContext)_localctx).i1.getText():null))); 
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(115);
					match(T__6);
					setState(116);
					((ParameterContext)_localctx).b2 = built_in_type();
					setState(117);
					((ParameterContext)_localctx).i2 = match(ID);
					 _localctx.ast.add(new VarDefinition(((ParameterContext)_localctx).b2.ast.getLine(), ((ParameterContext)_localctx).b2.ast.getColumn(), ((ParameterContext)_localctx).b2.ast, (((ParameterContext)_localctx).i2!=null?((ParameterContext)_localctx).i2.getText():null))); 
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<RecordField> rfs = new ArrayList<RecordField>();
		public TypeContext t;
		public Built_in_typeContext bt;
		public Token n;
		public Record_fieldContext rf;
		public Token s;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public List<Record_fieldContext> record_field() {
			return getRuleContexts(Record_fieldContext.class);
		}
		public Record_fieldContext record_field(int i) {
			return getRuleContext(Record_fieldContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
			case T__13:
				{
				setState(129);
				((TypeContext)_localctx).bt = built_in_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).bt.ast; 
				}
				break;
			case T__10:
				{
				setState(132);
				((TypeContext)_localctx).n = match(T__10);
				setState(133);
				match(T__4);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
					{
					{
					setState(134);
					((TypeContext)_localctx).rf = record_field();
					 for(RecordField r: ((TypeContext)_localctx).rf.ast) _localctx.rfs.add(r); 
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(T__5);
				 ((TypeContext)_localctx).ast =  new RecordType(((TypeContext)_localctx).n.getLine(), ((TypeContext)_localctx).n.getCharPositionInLine()+1, _localctx.rfs); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(146);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(147);
					match(T__8);
					setState(148);
					((TypeContext)_localctx).s = match(INT_CONSTANT);
					setState(149);
					match(T__9);
					 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).t.ast.getLine(), ((TypeContext)_localctx).t.ast.getColumn(), ((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).s!=null?((TypeContext)_localctx).s.getText():null))); 
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Record_fieldContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public TypeContext t;
		public Token i1;
		public Token i2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Record_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record_field; }
	}

	public final Record_fieldContext record_field() throws RecognitionException {
		Record_fieldContext _localctx = new Record_fieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_record_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			((Record_fieldContext)_localctx).t = type(0);
			setState(157);
			((Record_fieldContext)_localctx).i1 = match(ID);
			 _localctx.ast.add(new RecordField(((Record_fieldContext)_localctx).i1.getLine(), ((Record_fieldContext)_localctx).i1.getCharPositionInLine()+1, ((Record_fieldContext)_localctx).t.ast, (((Record_fieldContext)_localctx).i1!=null?((Record_fieldContext)_localctx).i1.getText():null))); 
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(159);
				match(T__6);
				setState(160);
				((Record_fieldContext)_localctx).i2 = match(ID);
				 _localctx.ast.add(new RecordField(((Record_fieldContext)_localctx).i2.getLine(), ((Record_fieldContext)_localctx).i2.getCharPositionInLine()+1, ((Record_fieldContext)_localctx).t.ast, (((Record_fieldContext)_localctx).i2!=null?((Record_fieldContext)_localctx).i2.getText():null))); 
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Built_in_typeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_built_in_type);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				((Built_in_typeContext)_localctx).t = match(T__11);
				 ((Built_in_typeContext)_localctx).ast =  new IntType(((Built_in_typeContext)_localctx).t.getLine(), ((Built_in_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				((Built_in_typeContext)_localctx).t = match(T__12);
				 ((Built_in_typeContext)_localctx).ast =  new DoubleType(((Built_in_typeContext)_localctx).t.getLine(), ((Built_in_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				((Built_in_typeContext)_localctx).t = match(T__13);
				 ((Built_in_typeContext)_localctx).ast =  new CharType(((Built_in_typeContext)_localctx).t.getLine(), ((Built_in_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Statement stmt;
		public ExpressionContext e1;
		public BlockContext b;
		public BlockContext b2;
		public ExpressionContext e2;
		public Token t;
		public ExpressionsContext exs;
		public ExpressionContext e;
		public Function_invocationContext f;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(T__14);
				setState(178);
				match(T__2);
				setState(179);
				((StatementContext)_localctx).e1 = expression(0);
				setState(180);
				match(T__3);
				setState(181);
				((StatementContext)_localctx).b = block();
				 _localctx.ast.add(new While(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b.ast)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(T__15);
				setState(185);
				match(T__2);
				setState(186);
				((StatementContext)_localctx).e1 = expression(0);
				setState(187);
				match(T__3);
				setState(188);
				((StatementContext)_localctx).b = block();
				 ((StatementContext)_localctx).stmt =  new If(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b.ast); 
				setState(194);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(190);
					match(T__16);
					setState(191);
					((StatementContext)_localctx).b2 = block();
					 ((If)_localctx.stmt).setElse(((StatementContext)_localctx).b2.ast); 
					}
					break;
				}
				 _localctx.ast.add(_localctx.stmt); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				((StatementContext)_localctx).e1 = expression(0);
				setState(199);
				match(T__17);
				setState(200);
				((StatementContext)_localctx).e2 = expression(0);
				setState(201);
				match(T__7);
				 _localctx.ast.add(new Assignment(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				((StatementContext)_localctx).t = match(T__18);
				setState(205);
				((StatementContext)_localctx).exs = expressions();
				setState(206);
				match(T__7);
				 for(Expression e: ((StatementContext)_localctx).exs.ast) _localctx.ast.add(new Read(((StatementContext)_localctx).t.getLine(), ((StatementContext)_localctx).t.getCharPositionInLine()+1, e)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				((StatementContext)_localctx).t = match(T__19);
				setState(210);
				((StatementContext)_localctx).exs = expressions();
				setState(211);
				match(T__7);
				 for(Expression e: ((StatementContext)_localctx).exs.ast) _localctx.ast.add(new Write(((StatementContext)_localctx).t.getLine(), ((StatementContext)_localctx).t.getCharPositionInLine()+1, e)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(214);
				((StatementContext)_localctx).t = match(T__20);
				setState(215);
				((StatementContext)_localctx).e = expression(0);
				setState(216);
				match(T__7);
				 _localctx.ast.add(new Return(((StatementContext)_localctx).t.getLine(), ((StatementContext)_localctx).t.getCharPositionInLine(), ((StatementContext)_localctx).e.ast)); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				((StatementContext)_localctx).f = function_invocation();
				setState(220);
				match(T__7);
				 _localctx.ast.add(((StatementContext)_localctx).f.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext es;
		public ExpressionContext em1;
		public ExpressionContext em2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressions);
		int _la;
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				((ExpressionsContext)_localctx).es = expression(0);
				 _localctx.ast.add(((ExpressionsContext)_localctx).es.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				((ExpressionsContext)_localctx).em1 = expression(0);
				 _localctx.ast.add(((ExpressionsContext)_localctx).em1.ast); 
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(230);
					match(T__6);
					setState(231);
					((ExpressionsContext)_localctx).em2 = expression(0);
					 _localctx.ast.add(((ExpressionsContext)_localctx).em2.ast); 
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_invocationContext extends ParserRuleContext {
		public Invocation ast;
		public Token v;
		public ArgumentsContext as;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_invocation; }
	}

	public final Function_invocationContext function_invocation() throws RecognitionException {
		Function_invocationContext _localctx = new Function_invocationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			((Function_invocationContext)_localctx).v = match(ID);
			setState(242);
			match(T__2);
			setState(243);
			((Function_invocationContext)_localctx).as = arguments();
			setState(244);
			match(T__3);
			 ((Function_invocationContext)_localctx).ast =  new Invocation(((Function_invocationContext)_localctx).v.getLine(), ((Function_invocationContext)_localctx).v.getCharPositionInLine()+1, new Variable(((Function_invocationContext)_localctx).v.getLine(), ((Function_invocationContext)_localctx).v.getCharPositionInLine()+1, (((Function_invocationContext)_localctx).v!=null?((Function_invocationContext)_localctx).v.getText():null)), ((Function_invocationContext)_localctx).as.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext es;
		public ExpressionContext em1;
		public ExpressionContext em2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arguments);
		int _la;
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				((ArgumentsContext)_localctx).es = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).es.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				((ArgumentsContext)_localctx).em1 = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).em1.ast); 
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(252);
					match(T__6);
					setState(253);
					((ArgumentsContext)_localctx).em2 = expression(0);
					 _localctx.ast.add(((ArgumentsContext)_localctx).em2.ast); 
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext ss;
		public StatementContext sm;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__8:
			case T__14:
			case T__15:
			case T__18:
			case T__19:
			case T__20:
			case T__22:
			case T__33:
			case INT_CONSTANT:
			case ID:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				((BlockContext)_localctx).ss = statement();
				 for(Statement s:((BlockContext)_localctx).ss.ast) _localctx.ast.add(s); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(T__4);
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__33) | (1L << INT_CONSTANT) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(268);
					((BlockContext)_localctx).sm = statement();
					 for(Statement s:((BlockContext)_localctx).sm.ast) _localctx.ast.add(s); 
					}
					}
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(276);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public TypeContext ty;
		public Token t;
		public Function_invocationContext fi;
		public Token op;
		public ExpressionContext e2;
		public Token v;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(280);
				match(T__2);
				setState(281);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(282);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast; 
				}
				break;
			case 2:
				{
				setState(285);
				match(T__8);
				setState(286);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(287);
				match(T__9);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast; 
				}
				break;
			case 3:
				{
				setState(290);
				match(T__2);
				setState(291);
				((ExpressionContext)_localctx).ty = type(0);
				setState(292);
				match(T__3);
				setState(293);
				((ExpressionContext)_localctx).e1 = expression(13);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).ty.ast.getLine(), ((ExpressionContext)_localctx).ty.ast.getColumn(), ((ExpressionContext)_localctx).ty.ast, ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 4:
				{
				setState(296);
				((ExpressionContext)_localctx).t = match(T__22);
				setState(297);
				((ExpressionContext)_localctx).e1 = expression(11);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).t.getLine(), ((ExpressionContext)_localctx).t.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 5:
				{
				setState(300);
				((ExpressionContext)_localctx).t = match(T__33);
				setState(301);
				((ExpressionContext)_localctx).e1 = expression(7);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).t.getLine(), ((ExpressionContext)_localctx).t.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 6:
				{
				setState(304);
				((ExpressionContext)_localctx).fi = function_invocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).fi.ast; 
				}
				break;
			case 7:
				{
				setState(307);
				((ExpressionContext)_localctx).t = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).t.getLine(), ((ExpressionContext)_localctx).t.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).t!=null?((ExpressionContext)_localctx).t.getText():null))); 
				}
				break;
			case 8:
				{
				setState(309);
				((ExpressionContext)_localctx).t = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).t.getLine(), ((ExpressionContext)_localctx).t.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).t!=null?((ExpressionContext)_localctx).t.getText():null))); 
				}
				break;
			case 9:
				{
				setState(311);
				((ExpressionContext)_localctx).t = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).t.getLine(), ((ExpressionContext)_localctx).t.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).t!=null?((ExpressionContext)_localctx).t.getText():null))); 
				}
				break;
			case 10:
				{
				setState(313);
				((ExpressionContext)_localctx).t = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).t.getLine(), ((ExpressionContext)_localctx).t.getCharPositionInLine()+1, (((ExpressionContext)_localctx).t!=null?((ExpressionContext)_localctx).t.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(349);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(347);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(318);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(319);
						((ExpressionContext)_localctx).e2 = expression(11);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(323);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__26) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(324);
						((ExpressionContext)_localctx).e2 = expression(10);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(328);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(329);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Comparisson(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(333);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(334);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(337);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(338);
						match(T__21);
						setState(339);
						((ExpressionContext)_localctx).v = match(ID);
						 ((ExpressionContext)_localctx).ast =  new Access(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).v!=null?((ExpressionContext)_localctx).v.getText():null)); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(342);
						match(T__8);
						setState(343);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(344);
						match(T__9);
						 ((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					}
					} 
				}
				setState(351);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0163\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5T\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6\3\6\3\7\3\7\3\7\7\7f\n\7"+
		"\f\7\16\7i\13\7\3\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\b{\n\b\f\b\16\b~\13\b\3\b\5\b\u0081\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\t\u008c\n\t\f\t\16\t\u008f\13\t\3\t\3\t\5\t\u0093"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u009a\n\t\f\t\16\t\u009d\13\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u00a5\n\n\f\n\16\n\u00a8\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00b2\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c5\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00e2\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ed"+
		"\n\r\f\r\16\r\u00f0\13\r\5\r\u00f2\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0103\n\17\f\17\16\17"+
		"\u0106\13\17\3\17\5\17\u0109\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7"+
		"\20\u0112\n\20\f\20\16\20\u0115\13\20\3\20\5\20\u0118\n\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u013e\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u015e\n\21"+
		"\f\21\16\21\u0161\13\21\3\21\2\4\20 \22\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \2\6\3\2\32\34\4\2\31\31\35\35\3\2\36#\3\2%&\2\u017d\2\'\3\2"+
		"\2\2\4.\3\2\2\2\6=\3\2\2\2\bS\3\2\2\2\nU\3\2\2\2\fg\3\2\2\2\16\u0080\3"+
		"\2\2\2\20\u0092\3\2\2\2\22\u009e\3\2\2\2\24\u00b1\3\2\2\2\26\u00e1\3\2"+
		"\2\2\30\u00f1\3\2\2\2\32\u00f3\3\2\2\2\34\u0108\3\2\2\2\36\u0117\3\2\2"+
		"\2 \u013d\3\2\2\2\"#\5\6\4\2#$\b\2\1\2$&\3\2\2\2%\"\3\2\2\2&)\3\2\2\2"+
		"\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\5\4\3\2+,\b\2\1\2,-\7\2"+
		"\2\3-\3\3\2\2\2./\7\3\2\2/\60\7\4\2\2\60\61\7\5\2\2\61\62\7\6\2\2\62\63"+
		"\7\7\2\2\63\64\5\f\7\2\64\65\7\b\2\2\65\66\b\3\1\2\66\5\3\2\2\2\678\5"+
		"\n\6\289\b\4\1\29>\3\2\2\2:;\5\b\5\2;<\b\4\1\2<>\3\2\2\2=\67\3\2\2\2="+
		":\3\2\2\2>\7\3\2\2\2?@\5\20\t\2@A\7(\2\2AB\7\5\2\2BC\5\16\b\2CD\7\6\2"+
		"\2DE\7\7\2\2EF\5\f\7\2FG\7\b\2\2GH\b\5\1\2HT\3\2\2\2IJ\7\3\2\2JK\7(\2"+
		"\2KL\7\5\2\2LM\5\16\b\2MN\7\6\2\2NO\7\7\2\2OP\5\f\7\2PQ\7\b\2\2QR\b\5"+
		"\1\2RT\3\2\2\2S?\3\2\2\2SI\3\2\2\2T\t\3\2\2\2UV\5\20\t\2VW\7(\2\2W]\b"+
		"\6\1\2XY\7\t\2\2YZ\7(\2\2Z\\\b\6\1\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^"+
		"\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\n\2\2a\13\3\2\2\2bc\5\n\6\2cd\b\7\1\2"+
		"df\3\2\2\2eb\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2ho\3\2\2\2ig\3\2\2\2"+
		"jk\5\26\f\2kl\b\7\1\2ln\3\2\2\2mj\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2"+
		"\2p\r\3\2\2\2qo\3\2\2\2rs\5\24\13\2st\7(\2\2t|\b\b\1\2uv\7\t\2\2vw\5\24"+
		"\13\2wx\7(\2\2xy\b\b\1\2y{\3\2\2\2zu\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2"+
		"\2\2}\u0081\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080r\3\2\2\2\u0080\177"+
		"\3\2\2\2\u0081\17\3\2\2\2\u0082\u0083\b\t\1\2\u0083\u0084\5\24\13\2\u0084"+
		"\u0085\b\t\1\2\u0085\u0093\3\2\2\2\u0086\u0087\7\r\2\2\u0087\u008d\7\7"+
		"\2\2\u0088\u0089\5\22\n\2\u0089\u008a\b\t\1\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0088\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\b\2\2\u0091"+
		"\u0093\b\t\1\2\u0092\u0082\3\2\2\2\u0092\u0086\3\2\2\2\u0093\u009b\3\2"+
		"\2\2\u0094\u0095\f\4\2\2\u0095\u0096\7\13\2\2\u0096\u0097\7\'\2\2\u0097"+
		"\u0098\7\f\2\2\u0098\u009a\b\t\1\2\u0099\u0094\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\21\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u009f\5\20\t\2\u009f\u00a0\7(\2\2\u00a0\u00a6\b\n\1\2\u00a1"+
		"\u00a2\7\t\2\2\u00a2\u00a3\7(\2\2\u00a3\u00a5\b\n\1\2\u00a4\u00a1\3\2"+
		"\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7\n\2\2\u00aa\23\3\2\2"+
		"\2\u00ab\u00ac\7\16\2\2\u00ac\u00b2\b\13\1\2\u00ad\u00ae\7\17\2\2\u00ae"+
		"\u00b2\b\13\1\2\u00af\u00b0\7\20\2\2\u00b0\u00b2\b\13\1\2\u00b1\u00ab"+
		"\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\25\3\2\2\2\u00b3"+
		"\u00b4\7\21\2\2\u00b4\u00b5\7\5\2\2\u00b5\u00b6\5 \21\2\u00b6\u00b7\7"+
		"\6\2\2\u00b7\u00b8\5\36\20\2\u00b8\u00b9\b\f\1\2\u00b9\u00e2\3\2\2\2\u00ba"+
		"\u00bb\7\22\2\2\u00bb\u00bc\7\5\2\2\u00bc\u00bd\5 \21\2\u00bd\u00be\7"+
		"\6\2\2\u00be\u00bf\5\36\20\2\u00bf\u00c4\b\f\1\2\u00c0\u00c1\7\23\2\2"+
		"\u00c1\u00c2\5\36\20\2\u00c2\u00c3\b\f\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00c0"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b\f\1\2\u00c7"+
		"\u00e2\3\2\2\2\u00c8\u00c9\5 \21\2\u00c9\u00ca\7\24\2\2\u00ca\u00cb\5"+
		" \21\2\u00cb\u00cc\7\n\2\2\u00cc\u00cd\b\f\1\2\u00cd\u00e2\3\2\2\2\u00ce"+
		"\u00cf\7\25\2\2\u00cf\u00d0\5\30\r\2\u00d0\u00d1\7\n\2\2\u00d1\u00d2\b"+
		"\f\1\2\u00d2\u00e2\3\2\2\2\u00d3\u00d4\7\26\2\2\u00d4\u00d5\5\30\r\2\u00d5"+
		"\u00d6\7\n\2\2\u00d6\u00d7\b\f\1\2\u00d7\u00e2\3\2\2\2\u00d8\u00d9\7\27"+
		"\2\2\u00d9\u00da\5 \21\2\u00da\u00db\7\n\2\2\u00db\u00dc\b\f\1\2\u00dc"+
		"\u00e2\3\2\2\2\u00dd\u00de\5\32\16\2\u00de\u00df\7\n\2\2\u00df\u00e0\b"+
		"\f\1\2\u00e0\u00e2\3\2\2\2\u00e1\u00b3\3\2\2\2\u00e1\u00ba\3\2\2\2\u00e1"+
		"\u00c8\3\2\2\2\u00e1\u00ce\3\2\2\2\u00e1\u00d3\3\2\2\2\u00e1\u00d8\3\2"+
		"\2\2\u00e1\u00dd\3\2\2\2\u00e2\27\3\2\2\2\u00e3\u00e4\5 \21\2\u00e4\u00e5"+
		"\b\r\1\2\u00e5\u00f2\3\2\2\2\u00e6\u00e7\5 \21\2\u00e7\u00ee\b\r\1\2\u00e8"+
		"\u00e9\7\t\2\2\u00e9\u00ea\5 \21\2\u00ea\u00eb\b\r\1\2\u00eb\u00ed\3\2"+
		"\2\2\u00ec\u00e8\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00e3\3\2"+
		"\2\2\u00f1\u00e6\3\2\2\2\u00f2\31\3\2\2\2\u00f3\u00f4\7(\2\2\u00f4\u00f5"+
		"\7\5\2\2\u00f5\u00f6\5\34\17\2\u00f6\u00f7\7\6\2\2\u00f7\u00f8\b\16\1"+
		"\2\u00f8\33\3\2\2\2\u00f9\u00fa\5 \21\2\u00fa\u00fb\b\17\1\2\u00fb\u0109"+
		"\3\2\2\2\u00fc\u00fd\5 \21\2\u00fd\u0104\b\17\1\2\u00fe\u00ff\7\t\2\2"+
		"\u00ff\u0100\5 \21\2\u0100\u0101\b\17\1\2\u0101\u0103\3\2\2\2\u0102\u00fe"+
		"\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0109\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u00f9\3\2"+
		"\2\2\u0108\u00fc\3\2\2\2\u0108\u0107\3\2\2\2\u0109\35\3\2\2\2\u010a\u010b"+
		"\5\26\f\2\u010b\u010c\b\20\1\2\u010c\u0118\3\2\2\2\u010d\u0113\7\7\2\2"+
		"\u010e\u010f\5\26\f\2\u010f\u0110\b\20\1\2\u0110\u0112\3\2\2\2\u0111\u010e"+
		"\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0118\7\b\2\2\u0117\u010a\3\2"+
		"\2\2\u0117\u010d\3\2\2\2\u0118\37\3\2\2\2\u0119\u011a\b\21\1\2\u011a\u011b"+
		"\7\5\2\2\u011b\u011c\5 \21\2\u011c\u011d\7\6\2\2\u011d\u011e\b\21\1\2"+
		"\u011e\u013e\3\2\2\2\u011f\u0120\7\13\2\2\u0120\u0121\5 \21\2\u0121\u0122"+
		"\7\f\2\2\u0122\u0123\b\21\1\2\u0123\u013e\3\2\2\2\u0124\u0125\7\5\2\2"+
		"\u0125\u0126\5\20\t\2\u0126\u0127\7\6\2\2\u0127\u0128\5 \21\17\u0128\u0129"+
		"\b\21\1\2\u0129\u013e\3\2\2\2\u012a\u012b\7\31\2\2\u012b\u012c\5 \21\r"+
		"\u012c\u012d\b\21\1\2\u012d\u013e\3\2\2\2\u012e\u012f\7$\2\2\u012f\u0130"+
		"\5 \21\t\u0130\u0131\b\21\1\2\u0131\u013e\3\2\2\2\u0132\u0133\5\32\16"+
		"\2\u0133\u0134\b\21\1\2\u0134\u013e\3\2\2\2\u0135\u0136\7*\2\2\u0136\u013e"+
		"\b\21\1\2\u0137\u0138\7)\2\2\u0138\u013e\b\21\1\2\u0139\u013a\7\'\2\2"+
		"\u013a\u013e\b\21\1\2\u013b\u013c\7(\2\2\u013c\u013e\b\21\1\2\u013d\u0119"+
		"\3\2\2\2\u013d\u011f\3\2\2\2\u013d\u0124\3\2\2\2\u013d\u012a\3\2\2\2\u013d"+
		"\u012e\3\2\2\2\u013d\u0132\3\2\2\2\u013d\u0135\3\2\2\2\u013d\u0137\3\2"+
		"\2\2\u013d\u0139\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u015f\3\2\2\2\u013f"+
		"\u0140\f\f\2\2\u0140\u0141\t\2\2\2\u0141\u0142\5 \21\r\u0142\u0143\b\21"+
		"\1\2\u0143\u015e\3\2\2\2\u0144\u0145\f\13\2\2\u0145\u0146\t\3\2\2\u0146"+
		"\u0147\5 \21\f\u0147\u0148\b\21\1\2\u0148\u015e\3\2\2\2\u0149\u014a\f"+
		"\n\2\2\u014a\u014b\t\4\2\2\u014b\u014c\5 \21\13\u014c\u014d\b\21\1\2\u014d"+
		"\u015e\3\2\2\2\u014e\u014f\f\b\2\2\u014f\u0150\t\5\2\2\u0150\u0151\5 "+
		"\21\t\u0151\u0152\b\21\1\2\u0152\u015e\3\2\2\2\u0153\u0154\f\20\2\2\u0154"+
		"\u0155\7\30\2\2\u0155\u0156\7(\2\2\u0156\u015e\b\21\1\2\u0157\u0158\f"+
		"\16\2\2\u0158\u0159\7\13\2\2\u0159\u015a\5 \21\2\u015a\u015b\7\f\2\2\u015b"+
		"\u015c\b\21\1\2\u015c\u015e\3\2\2\2\u015d\u013f\3\2\2\2\u015d\u0144\3"+
		"\2\2\2\u015d\u0149\3\2\2\2\u015d\u014e\3\2\2\2\u015d\u0153\3\2\2\2\u015d"+
		"\u0157\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160!\3\2\2\2\u0161\u015f\3\2\2\2\32\'=S]go|\u0080\u008d\u0092\u009b"+
		"\u00a6\u00b1\u00c4\u00e1\u00ee\u00f1\u0104\u0108\u0113\u0117\u013d\u015d"+
		"\u015f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}