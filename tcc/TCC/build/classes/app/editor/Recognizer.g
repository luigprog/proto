header
{
	package com.anlugifa.editor.parser;
	import javax.swing.text.StyledDocument;
	import javax.swing.text.Style;
	import javax.swing.text.Element;
	import com.anlugifa.editor.base.*;
	import javax.swing.text.BadLocationException;
	import com.anlugifa.editor.xml.*;
}

class RecognizerParser extends Parser;

options
{	
	defaultErrorHandler = false;
	k=5;
}
{
	private StyledDocument document;
	private HighlightPainter painter;
	
	public int getOffset(int line, int column)
    {
    	Element root = document.getDefaultRootElement();
		int lineStart = root.getElement( line ).getStartOffset();
	    return lineStart + column;
    }
    
    public Style getStyle(Styles style)
    {
    	return StyleManager.getInstance().getStyle(style).getStyle();
    }
    
    public void paint(Token token, Style style)
    {
    	if (token == null)
	    	return;
	    	
    	int line 	= token.getLine() - 1;
    	int column  = token.getColumn() - 1;
    	String word = token.getText();
    	
    	paint(word, line, column, style);
    }
    
    public void paint(String word, int line, int column, Style style)
    {   
		int offset = getOffset(line, column);
		painter.highlight(offset, word.length(), style);			
    }    
}

start [StyledDocument document, HighlightPainter painter]
	  {
	  	this.document = document;
	  	this.painter = painter;
  	  }
	  : ( word | keywords )*
	  ;
	  
word : values
	 | comments
	 | types
	 | STRING_LIT   { paint(LT(0), getStyle(Styles.STRING)); }	 	 	 	  
	 ;
	 
values : number
	   | character	   
	   ;

comments: ( SL_COMMENT | ML_COMMENT	)
		  { paint(LT(0), getStyle(Styles.INVALID)); }
		; 
	   
number :( a:INTLT		 
	    | c:HEX_DIGIT 	 
	    ) { paint(LT(0), getStyle(Styles.NUMBER)); }
  	   ;
	 
character : c:CHARLIT 
		  { paint(c, getStyle(Styles.CHARACTER)); }	
		  ;

types	:
		( "int"
	  	| "float"
	  	| "double"
	  	| "byte"
	  	| "char"
	  	| "boolean"
	  	| "short"	  	
	  	| "long"
	  	)
	  	{
	  		paint(LT(0), getStyle( Styles.TYPE )); 
	  	}
	  	;
	  	  
keywords 
	  :
	  ( "abstract"
	  | "continue"
	  | "for"
	  | "new"
	  |	"switch"
	  | "assert"
	  | "default"
	  |	"goto"
	  | "package"
	  | "synchronized"
	  | "do"
	  | "if"
	  | "private"
	  | "this"
	  | "break"
	  | "implements"
	  | "protected"
	  | "throw"
	  | "else"
	  | "import"
	  | "public"
	  | "throws"
	  | "case"
	  | "enum"
	  | "instanceof"
	  | "return"
	  | "transient"
	  | "catch"
	  | "extends"
	  | "try"
	  | "final"
	  | "interface"
	  | "static"
	  | "class"
	  | "finally"
	  | "strictfp"
	  | "volatile"
	  | "const"
	  | "native"
	  | "super"
	  | "while"
	  | "void"
	  ) 
	  { 
	  	paint(LT(0), getStyle( Styles.STRUCTURAL )); 
	  }
	  ;

class RecognizerLexer extends Lexer;

options
{
	
	// this defines the set of Unicode characters that
    // characters in the inputstream must belong to
    charVocabulary = '\3'..'\377' | '\u1000'..'\u1fff';
    
    // don't automatically test for literals
    testLiterals=false;
	
	k=5;
}

protected
WS: ( ' '
    | '\t' 
    | '\f'
    | ( "\r\n"  // DOS/Windows
      | '\r'    // Macintosh
      | '\n'    // Unix
      )    
    { newline(); }
    )
  ;
 
protected DIGIT : '0'..'9' ;
 
protected LETTER : ('a'..'z' | 'A'..'Z')
				 ;
  
INTLT : (a:DIGIT)+
	  ;

HEX_DIGIT: "0x" (DIGIT|'a'..'f'|'A'..'F')*
		 ;

SL_COMMENT : "//" (~('\n'|'\r'))*
	    ;
 
ML_COMMENT : "/*"
		    ( options { generateAmbigWarnings=false; }
	        :  { LA(2)!='/' }? '*'
      	    | '\r' '\n' {newline();}
      	   	| '\r' {newline();}
           	| '\n' {newline();}
           	| ~('*'|'\n'|'\r')
		    )*
		    ("*/")?
			;

CHARLIT
  : '\'' (~('\''))* ('\'')?
  ;		

protected
Escape
        : '\\'
        	( options{warnWhenFollowAmbig=false;}: 
          		~('0'..'7' | 'x')
          		| ('0'..'3') ( options{warnWhenFollowAmbig=false;}: DIGIT )*
          		| ('4'..'7') ( options{warnWhenFollowAmbig=false;}: DIGIT )*
          		| 'x' 		 ( options{warnWhenFollowAmbig=false;}: DIGIT | 'a'..'f' | 'A'..'F' )+
			)
        ;

STRING_LIT
        :
                '"'
                ( ('\\' ~('\n'))=> Escape
                | ( '\r'        { newline(); }
                  | '\n'        { newline(); }
                  | '\\' '\n'   { newline(); }
                  )
                | ~( '"' | '\r' | '\n' | '\\' )
                )*
                ('"')?
        ;

DELIMETER
        : (WS
        | '.'  		
		| ':'
		| ';'
		| ','
		| '='
		| '[' | ']' 
		| '(' | ')'
		| '{' | '}' 	
		| '<' | "<=" | '>' | ">="
		| '+' | '-' | '*' | '/' | '%'
		| "||" | "&&"
		| ">>" | "<<"
		| "==" 
		| "~=="
		| '!' | '#' | '&' | '~' | '$' | '`' | '^' | '\'' | '|'
		)
		{ $setType(Token.SKIP); }
		;

protected
MISC: '-' | '_';


IDENT
  options {  testLiterals=true; }
  : LETTER (LETTER | DIGIT | MISC)*
  { $setType(Token.SKIP); }
  ;
