// Generated from D:/OneDrive - Universidad de Oviedo/Documentos/Universidad/España_3-4/DLP/Programming-Language-Design/Lab3/src/parser\Cmm.g4 by ANTLR 4.8
package parser;
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
		INT_CONSTANT=1, ID=2, REAL_CONSTANT=3, CHAR_CONSTANT=4, WHITE_SPACES=5, 
		ONE_LINE_COMMENT=6, MULTIPLE_LINE_COMMENT=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETTER", "DIGIT", "SPECIAL_CHARACTERS", "FLOATING_POINT", "MANTISSA_EXPONENT", 
			"INT_CONSTANT", "ID", "REAL_CONSTANT", "CHAR_CONSTANT", "WHITE_SPACES", 
			"ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u008f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4(\n\4\3\5\3\5\3\5\7\5-\n\5\f\5\16\5\60\13\5\3\5\5\5\63\n\5\3\5\3\5"+
		"\6\5\67\n\5\r\5\16\58\5\5;\n\5\3\6\3\6\5\6?\n\6\3\6\3\6\5\6C\n\6\3\6\3"+
		"\6\3\7\3\7\3\7\7\7J\n\7\f\7\16\7M\13\7\5\7O\n\7\3\b\3\b\5\bS\n\b\3\b\3"+
		"\b\3\b\7\bX\n\b\f\b\16\b[\13\b\3\t\3\t\5\t_\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\nk\n\n\3\13\6\13n\n\13\r\13\16\13o\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\7\fx\n\f\f\f\16\f{\13\f\3\f\5\f~\n\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\7\r\u0086\n\r\f\r\16\r\u0089\13\r\3\r\3\r\3\r\3\r\3\r\4y\u0087\2"+
		"\16\3\2\5\2\7\2\t\2\13\2\r\3\17\4\21\5\23\6\25\7\27\b\31\t\3\2\t\4\2C"+
		"\\c|\3\2\62;\4\2GGgg\4\2--//\3\2\63;\5\2\13\f\17\17\"\"\4\3\f\f\17\17"+
		"\2\u009c\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7\'\3\2\2\2\t:"+
		"\3\2\2\2\13>\3\2\2\2\rN\3\2\2\2\17R\3\2\2\2\21^\3\2\2\2\23j\3\2\2\2\25"+
		"m\3\2\2\2\27s\3\2\2\2\31\u0081\3\2\2\2\33\34\t\2\2\2\34\4\3\2\2\2\35\36"+
		"\t\3\2\2\36\6\3\2\2\2\37 \7)\2\2 !\7^\2\2!\"\7p\2\2\"(\7)\2\2#$\7)\2\2"+
		"$%\7^\2\2%&\7v\2\2&(\7)\2\2\'\37\3\2\2\2\'#\3\2\2\2(\b\3\2\2\2)*\5\r\7"+
		"\2*.\7\60\2\2+-\5\5\3\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/;\3"+
		"\2\2\2\60.\3\2\2\2\61\63\5\r\7\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2"+
		"\2\2\64\66\7\60\2\2\65\67\5\5\3\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2"+
		"\289\3\2\2\29;\3\2\2\2:)\3\2\2\2:\62\3\2\2\2;\n\3\2\2\2<?\5\t\5\2=?\5"+
		"\r\7\2><\3\2\2\2>=\3\2\2\2?@\3\2\2\2@B\t\4\2\2AC\t\5\2\2BA\3\2\2\2BC\3"+
		"\2\2\2CD\3\2\2\2DE\5\r\7\2E\f\3\2\2\2FO\7\62\2\2GK\t\6\2\2HJ\5\5\3\2I"+
		"H\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LO\3\2\2\2MK\3\2\2\2NF\3\2\2\2"+
		"NG\3\2\2\2O\16\3\2\2\2PS\5\3\2\2QS\7a\2\2RP\3\2\2\2RQ\3\2\2\2SY\3\2\2"+
		"\2TX\5\3\2\2UX\5\5\3\2VX\7a\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X[\3\2\2"+
		"\2YW\3\2\2\2YZ\3\2\2\2Z\20\3\2\2\2[Y\3\2\2\2\\_\5\t\5\2]_\5\13\6\2^\\"+
		"\3\2\2\2^]\3\2\2\2_\22\3\2\2\2`a\7)\2\2ab\13\2\2\2bk\7)\2\2cd\7)\2\2d"+
		"e\7^\2\2ef\3\2\2\2fg\5\r\7\2gh\7)\2\2hk\3\2\2\2ik\5\7\4\2j`\3\2\2\2jc"+
		"\3\2\2\2ji\3\2\2\2k\24\3\2\2\2ln\t\7\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2"+
		"op\3\2\2\2pq\3\2\2\2qr\b\13\2\2r\26\3\2\2\2st\7\61\2\2tu\7\61\2\2uy\3"+
		"\2\2\2vx\13\2\2\2wv\3\2\2\2x{\3\2\2\2yz\3\2\2\2yw\3\2\2\2z}\3\2\2\2{y"+
		"\3\2\2\2|~\t\b\2\2}|\3\2\2\2~\177\3\2\2\2\177\u0080\b\f\2\2\u0080\30\3"+
		"\2\2\2\u0081\u0082\7\61\2\2\u0082\u0083\7,\2\2\u0083\u0087\3\2\2\2\u0084"+
		"\u0086\13\2\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008b\7,\2\2\u008b\u008c\7\61\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\r"+
		"\2\2\u008e\32\3\2\2\2\25\2\'.\628:>BKNRWY^joy}\u0087\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}