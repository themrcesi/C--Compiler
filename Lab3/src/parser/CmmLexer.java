// Generated from D:/OneDrive - Universidad de Oviedo/Documentos/Universidad/Espa�a_3-4/DLP/Programming-Language-Design/Lab3/src/parser\Cmm.g4 by ANTLR 4.8
package parser;

    import ast.*;
    import ast.types.*;
    import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "LETTER", "DIGIT", "SPECIAL_CHARACTERS", "FLOATING_POINT", 
			"MANTISSA_EXPONENT", "INT_CONSTANT", "ID", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"WHITE_SPACES", "ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'main'", "'('", "')'", "'{'", "'}'", "','", "';'", "'['", 
			"']'", "'struct'", "'int'", "'double'", "'char'", "'while'", "'if'", 
			"'else'", "'='", "'read'", "'write'", "'return'", "'.'", "'-'", "'*'", 
			"'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", 
			"'||'", "'!'"
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u014e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3"+
		"$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\5(\u00e7\n(\3)\3)"+
		"\3)\7)\u00ec\n)\f)\16)\u00ef\13)\3)\5)\u00f2\n)\3)\3)\6)\u00f6\n)\r)\16"+
		")\u00f7\5)\u00fa\n)\3*\3*\5*\u00fe\n*\3*\3*\5*\u0102\n*\3*\3*\3+\3+\3"+
		"+\7+\u0109\n+\f+\16+\u010c\13+\5+\u010e\n+\3,\3,\5,\u0112\n,\3,\3,\3,"+
		"\7,\u0117\n,\f,\16,\u011a\13,\3-\3-\5-\u011e\n-\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\5.\u012a\n.\3/\6/\u012d\n/\r/\16/\u012e\3/\3/\3\60\3\60\3\60\3"+
		"\60\7\60\u0137\n\60\f\60\16\60\u013a\13\60\3\60\5\60\u013d\n\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\7\61\u0145\n\61\f\61\16\61\u0148\13\61\3\61\3"+
		"\61\3\61\3\61\3\61\4\u0138\u0146\2\62\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\2O\2Q\2S\2U\'"+
		"W(Y)[*]+_,a-\3\2\t\4\2C\\c|\3\2\62;\4\2GGgg\4\2--//\3\2\63;\5\2\13\f\17"+
		"\17\"\"\4\3\f\f\17\17\2\u015b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5h\3\2\2"+
		"\2\7m\3\2\2\2\to\3\2\2\2\13q\3\2\2\2\rs\3\2\2\2\17u\3\2\2\2\21w\3\2\2"+
		"\2\23y\3\2\2\2\25{\3\2\2\2\27}\3\2\2\2\31\u0084\3\2\2\2\33\u0088\3\2\2"+
		"\2\35\u008f\3\2\2\2\37\u0094\3\2\2\2!\u009a\3\2\2\2#\u009d\3\2\2\2%\u00a2"+
		"\3\2\2\2\'\u00a4\3\2\2\2)\u00a9\3\2\2\2+\u00af\3\2\2\2-\u00b6\3\2\2\2"+
		"/\u00b8\3\2\2\2\61\u00ba\3\2\2\2\63\u00bc\3\2\2\2\65\u00be\3\2\2\2\67"+
		"\u00c0\3\2\2\29\u00c2\3\2\2\2;\u00c4\3\2\2\2=\u00c7\3\2\2\2?\u00c9\3\2"+
		"\2\2A\u00cc\3\2\2\2C\u00cf\3\2\2\2E\u00d2\3\2\2\2G\u00d5\3\2\2\2I\u00d8"+
		"\3\2\2\2K\u00da\3\2\2\2M\u00dc\3\2\2\2O\u00e6\3\2\2\2Q\u00f9\3\2\2\2S"+
		"\u00fd\3\2\2\2U\u010d\3\2\2\2W\u0111\3\2\2\2Y\u011d\3\2\2\2[\u0129\3\2"+
		"\2\2]\u012c\3\2\2\2_\u0132\3\2\2\2a\u0140\3\2\2\2cd\7x\2\2de\7q\2\2ef"+
		"\7k\2\2fg\7f\2\2g\4\3\2\2\2hi\7o\2\2ij\7c\2\2jk\7k\2\2kl\7p\2\2l\6\3\2"+
		"\2\2mn\7*\2\2n\b\3\2\2\2op\7+\2\2p\n\3\2\2\2qr\7}\2\2r\f\3\2\2\2st\7\177"+
		"\2\2t\16\3\2\2\2uv\7.\2\2v\20\3\2\2\2wx\7=\2\2x\22\3\2\2\2yz\7]\2\2z\24"+
		"\3\2\2\2{|\7_\2\2|\26\3\2\2\2}~\7u\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080"+
		"\u0081\7w\2\2\u0081\u0082\7e\2\2\u0082\u0083\7v\2\2\u0083\30\3\2\2\2\u0084"+
		"\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087\32\3\2\2\2\u0088"+
		"\u0089\7f\2\2\u0089\u008a\7q\2\2\u008a\u008b\7w\2\2\u008b\u008c\7d\2\2"+
		"\u008c\u008d\7n\2\2\u008d\u008e\7g\2\2\u008e\34\3\2\2\2\u008f\u0090\7"+
		"e\2\2\u0090\u0091\7j\2\2\u0091\u0092\7c\2\2\u0092\u0093\7t\2\2\u0093\36"+
		"\3\2\2\2\u0094\u0095\7y\2\2\u0095\u0096\7j\2\2\u0096\u0097\7k\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\7g\2\2\u0099 \3\2\2\2\u009a\u009b\7k\2\2\u009b"+
		"\u009c\7h\2\2\u009c\"\3\2\2\2\u009d\u009e\7g\2\2\u009e\u009f\7n\2\2\u009f"+
		"\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7?\2\2\u00a3"+
		"&\3\2\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7c\2\2\u00a7"+
		"\u00a8\7f\2\2\u00a8(\3\2\2\2\u00a9\u00aa\7y\2\2\u00aa\u00ab\7t\2\2\u00ab"+
		"\u00ac\7k\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7g\2\2\u00ae*\3\2\2\2\u00af"+
		"\u00b0\7t\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7w\2\2"+
		"\u00b3\u00b4\7t\2\2\u00b4\u00b5\7p\2\2\u00b5,\3\2\2\2\u00b6\u00b7\7\60"+
		"\2\2\u00b7.\3\2\2\2\u00b8\u00b9\7/\2\2\u00b9\60\3\2\2\2\u00ba\u00bb\7"+
		",\2\2\u00bb\62\3\2\2\2\u00bc\u00bd\7\61\2\2\u00bd\64\3\2\2\2\u00be\u00bf"+
		"\7\'\2\2\u00bf\66\3\2\2\2\u00c0\u00c1\7-\2\2\u00c18\3\2\2\2\u00c2\u00c3"+
		"\7@\2\2\u00c3:\3\2\2\2\u00c4\u00c5\7@\2\2\u00c5\u00c6\7?\2\2\u00c6<\3"+
		"\2\2\2\u00c7\u00c8\7>\2\2\u00c8>\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb"+
		"\7?\2\2\u00cb@\3\2\2\2\u00cc\u00cd\7#\2\2\u00cd\u00ce\7?\2\2\u00ceB\3"+
		"\2\2\2\u00cf\u00d0\7?\2\2\u00d0\u00d1\7?\2\2\u00d1D\3\2\2\2\u00d2\u00d3"+
		"\7(\2\2\u00d3\u00d4\7(\2\2\u00d4F\3\2\2\2\u00d5\u00d6\7~\2\2\u00d6\u00d7"+
		"\7~\2\2\u00d7H\3\2\2\2\u00d8\u00d9\7#\2\2\u00d9J\3\2\2\2\u00da\u00db\t"+
		"\2\2\2\u00dbL\3\2\2\2\u00dc\u00dd\t\3\2\2\u00ddN\3\2\2\2\u00de\u00df\7"+
		")\2\2\u00df\u00e0\7^\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e7\7)\2\2\u00e2\u00e3"+
		"\7)\2\2\u00e3\u00e4\7^\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e7\7)\2\2\u00e6"+
		"\u00de\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e7P\3\2\2\2\u00e8\u00e9\5U+\2\u00e9"+
		"\u00ed\7\60\2\2\u00ea\u00ec\5M\'\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2"+
		"\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00fa\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f2\5U+\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2"+
		"\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\7\60\2\2\u00f4\u00f6\5M\'\2\u00f5\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fa\3\2\2\2\u00f9\u00e8\3\2\2\2\u00f9\u00f1\3\2\2\2\u00faR\3\2\2\2"+
		"\u00fb\u00fe\5Q)\2\u00fc\u00fe\5U+\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3"+
		"\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\t\4\2\2\u0100\u0102\t\5\2\2\u0101"+
		"\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\5U"+
		"+\2\u0104T\3\2\2\2\u0105\u010e\7\62\2\2\u0106\u010a\t\6\2\2\u0107\u0109"+
		"\5M\'\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0105\3\2"+
		"\2\2\u010d\u0106\3\2\2\2\u010eV\3\2\2\2\u010f\u0112\5K&\2\u0110\u0112"+
		"\7a\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0118\3\2\2\2\u0113"+
		"\u0117\5K&\2\u0114\u0117\5M\'\2\u0115\u0117\7a\2\2\u0116\u0113\3\2\2\2"+
		"\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116"+
		"\3\2\2\2\u0118\u0119\3\2\2\2\u0119X\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011e\5Q)\2\u011c\u011e\5S*\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2\2\2"+
		"\u011eZ\3\2\2\2\u011f\u0120\7)\2\2\u0120\u0121\13\2\2\2\u0121\u012a\7"+
		")\2\2\u0122\u0123\7)\2\2\u0123\u0124\7^\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\5U+\2\u0126\u0127\7)\2\2\u0127\u012a\3\2\2\2\u0128\u012a\5O(\2"+
		"\u0129\u011f\3\2\2\2\u0129\u0122\3\2\2\2\u0129\u0128\3\2\2\2\u012a\\\3"+
		"\2\2\2\u012b\u012d\t\7\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b/"+
		"\2\2\u0131^\3\2\2\2\u0132\u0133\7\61\2\2\u0133\u0134\7\61\2\2\u0134\u0138"+
		"\3\2\2\2\u0135\u0137\13\2\2\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2"+
		"\u0138\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013b\u013d\t\b\2\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u013f\b\60\2\2\u013f`\3\2\2\2\u0140\u0141\7\61\2\2\u0141\u0142\7,\2\2"+
		"\u0142\u0146\3\2\2\2\u0143\u0145\13\2\2\2\u0144\u0143\3\2\2\2\u0145\u0148"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u0146\3\2\2\2\u0149\u014a\7,\2\2\u014a\u014b\7\61\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014d\b\61\2\2\u014db\3\2\2\2\25\2\u00e6\u00ed\u00f1\u00f7"+
		"\u00f9\u00fd\u0101\u010a\u010d\u0111\u0116\u0118\u011d\u0129\u012e\u0138"+
		"\u013c\u0146\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}