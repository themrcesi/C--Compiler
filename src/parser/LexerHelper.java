package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods
	public static char lexemeToChar(String str) {
		str = str.replace("'", "");
		if(str.contains("\\")) {
			str = str.replace("\\", "");
			try {
				Integer a = Integer.parseInt(str);
				return (char) a.intValue();
			}
			catch(Exception e) {}
			if(str.contains("n"))
				return '\n';
			if(str.contains("t"))
				return '\t';
		}
		return str.charAt(0);
	}

	public static double lexemeToReal(String str) {
		try {
			if(str.toLowerCase().contains("e")) {
				return Double.parseDouble(str.toLowerCase().split("e")[0]) * Math.pow(10, Double.parseDouble(str.toLowerCase().split("e")[1]));
			}
			else {
				return Double.parseDouble(str.toLowerCase());
			}
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
	
}
