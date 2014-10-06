package app.editor;

import javax.swing.text.StyledDocument;
import javax.swing.text.Style;
import javax.swing.text.Element;
import javax.swing.text.BadLocationException;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class RecognizerParser extends antlr.LLkParser implements RecognizerParserTokenTypes {

    private StyledDocument document;
    private HighlightPainter painter;

    public int getOffset(int line, int column) {
        Element root = document.getDefaultRootElement();
        int lineStart = root.getElement(line).getStartOffset();
        return lineStart + column;
    }

    public Style getStyle(Styles style) {
        return StyleManager.getInstance().getStyle(style).getStyle();
    }

    public void paint(Token token, Style style) {
        if (token == null) {
            return;
        }

        int line = token.getLine() - 1;
        int column = token.getColumn() - 1;
        String word = token.getText();

        paint(word, line, column, style);
    }

    public void paint(String word, int line, int column, Style style) {
        int offset = getOffset(line, column);
        painter.highlight(offset, word.length(), style);
    }

    protected RecognizerParser(TokenBuffer tokenBuf, int k) {
        super(tokenBuf, k);
        tokenNames = _tokenNames;
    }

    public RecognizerParser(TokenBuffer tokenBuf) {
        this(tokenBuf, 5);
    }

    protected RecognizerParser(TokenStream lexer, int k) {
        super(lexer, k);
        tokenNames = _tokenNames;
    }

    public RecognizerParser(TokenStream lexer) {
        this(lexer, 5);
    }

    public RecognizerParser(ParserSharedInputState state) {
        super(state, 5);
        tokenNames = _tokenNames;
    }

    public final void start(
            StyledDocument document, HighlightPainter painter) throws RecognitionException, TokenStreamException {


        this.document = document;
        this.painter = painter;


        {
            _loop567:
            do {
                switch (LA(1)) {
                    case STRING_LIT:
                    case SL_COMMENT:
                    case ML_COMMENT:
                    case INTLT:
                    case HEX_DIGIT:
                    case CHARLIT:
                    case LITERAL_int:
                    case LITERAL_float:
                    case LITERAL_double:
                    case LITERAL_byte:
                    case LITERAL_char:
                    case LITERAL_boolean:
                    case LITERAL_short:
                    case LITERAL_long: {
                        word();
                        break;
                    }
                    case LITERAL_abstract:
                    case LITERAL_continue:
                    case LITERAL_for:
                    case LITERAL_new:
                    case LITERAL_switch:
                    case LITERAL_assert:
                    case LITERAL_default:
                    case LITERAL_goto:
                    case LITERAL_package:
                    case LITERAL_synchronized:
                    case LITERAL_do:
                    case LITERAL_if:
                    case LITERAL_private:
                    case LITERAL_this:
                    case LITERAL_break:
                    case LITERAL_implements:
                    case LITERAL_protected:
                    case LITERAL_throw:
                    case LITERAL_else:
                    case LITERAL_import:
                    case LITERAL_public:
                    case LITERAL_throws:
                    case LITERAL_case:
                    case LITERAL_enum:
                    case LITERAL_instanceof:
                    case LITERAL_return:
                    case LITERAL_transient:
                    case LITERAL_catch:
                    case LITERAL_extends:
                    case LITERAL_try:
                    case LITERAL_final:
                    case LITERAL_interface:
                    case LITERAL_static:
                    case LITERAL_class:
                    case LITERAL_finally:
                    case LITERAL_strictfp:
                    case LITERAL_volatile:
                    case LITERAL_const:
                    case LITERAL_native:
                    case LITERAL_super:
                    case LITERAL_while:
                    case LITERAL_void: {
                        keywords();
                        break;
                    }
                    default: {
                        break _loop567;
                    }
                }
            } while (true);
        }
    }

    public final void word() throws RecognitionException, TokenStreamException {


        switch (LA(1)) {
            case INTLT:
            case HEX_DIGIT:
            case CHARLIT: {
                values();
                break;
            }
            case SL_COMMENT:
            case ML_COMMENT: {
                comments();
                break;
            }
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_double:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_boolean:
            case LITERAL_short:
            case LITERAL_long: {
                types();
                break;
            }
            case STRING_LIT: {
                match(STRING_LIT);
                paint(LT(0), getStyle(Styles.STRING));
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
    }

    public final void keywords() throws RecognitionException, TokenStreamException {


        {
            switch (LA(1)) {
                case LITERAL_abstract: {
                    match(LITERAL_abstract);
                    break;
                }
                case LITERAL_continue: {
                    match(LITERAL_continue);
                    break;
                }
                case LITERAL_for: {
                    match(LITERAL_for);
                    break;
                }
                case LITERAL_new: {
                    match(LITERAL_new);
                    break;
                }
                case LITERAL_switch: {
                    match(LITERAL_switch);
                    break;
                }
                case LITERAL_assert: {
                    match(LITERAL_assert);
                    break;
                }
                case LITERAL_default: {
                    match(LITERAL_default);
                    break;
                }
                case LITERAL_goto: {
                    match(LITERAL_goto);
                    break;
                }
                case LITERAL_package: {
                    match(LITERAL_package);
                    break;
                }
                case LITERAL_synchronized: {
                    match(LITERAL_synchronized);
                    break;
                }
                case LITERAL_do: {
                    match(LITERAL_do);
                    break;
                }
                case LITERAL_if: {
                    match(LITERAL_if);
                    break;
                }
                case LITERAL_private: {
                    match(LITERAL_private);
                    break;
                }
                case LITERAL_this: {
                    match(LITERAL_this);
                    break;
                }
                case LITERAL_break: {
                    match(LITERAL_break);
                    break;
                }
                case LITERAL_implements: {
                    match(LITERAL_implements);
                    break;
                }
                case LITERAL_protected: {
                    match(LITERAL_protected);
                    break;
                }
                case LITERAL_throw: {
                    match(LITERAL_throw);
                    break;
                }
                case LITERAL_else: {
                    match(LITERAL_else);
                    break;
                }
                case LITERAL_import: {
                    match(LITERAL_import);
                    break;
                }
                case LITERAL_public: {
                    match(LITERAL_public);
                    break;
                }
                case LITERAL_throws: {
                    match(LITERAL_throws);
                    break;
                }
                case LITERAL_case: {
                    match(LITERAL_case);
                    break;
                }
                case LITERAL_enum: {
                    match(LITERAL_enum);
                    break;
                }
                case LITERAL_instanceof: {
                    match(LITERAL_instanceof);
                    break;
                }
                case LITERAL_return: {
                    match(LITERAL_return);
                    break;
                }
                case LITERAL_transient: {
                    match(LITERAL_transient);
                    break;
                }
                case LITERAL_catch: {
                    match(LITERAL_catch);
                    break;
                }
                case LITERAL_extends: {
                    match(LITERAL_extends);
                    break;
                }
                case LITERAL_try: {
                    match(LITERAL_try);
                    break;
                }
                case LITERAL_final: {
                    match(LITERAL_final);
                    break;
                }
                case LITERAL_interface: {
                    match(LITERAL_interface);
                    break;
                }
                case LITERAL_static: {
                    match(LITERAL_static);
                    break;
                }
                case LITERAL_class: {
                    match(LITERAL_class);
                    break;
                }
                case LITERAL_finally: {
                    match(LITERAL_finally);
                    break;
                }
                case LITERAL_strictfp: {
                    match(LITERAL_strictfp);
                    break;
                }
                case LITERAL_volatile: {
                    match(LITERAL_volatile);
                    break;
                }
                case LITERAL_const: {
                    match(LITERAL_const);
                    break;
                }
                case LITERAL_native: {
                    match(LITERAL_native);
                    break;
                }
                case LITERAL_super: {
                    match(LITERAL_super);
                    break;
                }
                case LITERAL_while: {
                    match(LITERAL_while);
                    break;
                }
                case LITERAL_void: {
                    match(LITERAL_void);
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }

        paint(LT(0), getStyle(Styles.STRUCTURAL));

    }

    public final void values() throws RecognitionException, TokenStreamException {


        switch (LA(1)) {
            case INTLT:
            case HEX_DIGIT: {
                number();
                break;
            }
            case CHARLIT: {
                character();
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
    }

    public final void comments() throws RecognitionException, TokenStreamException {


        {
            switch (LA(1)) {
                case SL_COMMENT: {
                    match(SL_COMMENT);
                    break;
                }
                case ML_COMMENT: {
                    match(ML_COMMENT);
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        paint(LT(0), getStyle(Styles.INVALID));
    }

    public final void types() throws RecognitionException, TokenStreamException {


        {
            switch (LA(1)) {
                case LITERAL_int: {
                    match(LITERAL_int);
                    break;
                }
                case LITERAL_float: {
                    match(LITERAL_float);
                    break;
                }
                case LITERAL_double: {
                    match(LITERAL_double);
                    break;
                }
                case LITERAL_byte: {
                    match(LITERAL_byte);
                    break;
                }
                case LITERAL_char: {
                    match(LITERAL_char);
                    break;
                }
                case LITERAL_boolean: {
                    match(LITERAL_boolean);
                    break;
                }
                case LITERAL_short: {
                    match(LITERAL_short);
                    break;
                }
                case LITERAL_long: {
                    match(LITERAL_long);
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }

        paint(LT(0), getStyle(Styles.TYPE));

    }

    public final void number() throws RecognitionException, TokenStreamException {

        Token a = null;
        Token c = null;

        {
            switch (LA(1)) {
                case INTLT: {
                    a = LT(1);
                    match(INTLT);
                    break;
                }
                case HEX_DIGIT: {
                    c = LT(1);
                    match(HEX_DIGIT);
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        paint(LT(0), getStyle(Styles.NUMBER));
    }

    public final void character() throws RecognitionException, TokenStreamException {

        Token c = null;

        c = LT(1);
        match(CHARLIT);
        paint(c, getStyle(Styles.CHARACTER));
    }
    public static final String[] _tokenNames = {
        "<0>",
        "EOF",
        "<2>",
        "NULL_TREE_LOOKAHEAD",
        "STRING_LIT",
        "SL_COMMENT",
        "ML_COMMENT",
        "INTLT",
        "HEX_DIGIT",
        "CHARLIT",
        "\"int\"",
        "\"float\"",
        "\"double\"",
        "\"byte\"",
        "\"char\"",
        "\"boolean\"",
        "\"short\"",
        "\"long\"",
        "\"abstract\"",
        "\"continue\"",
        "\"for\"",
        "\"new\"",
        "\"switch\"",
        "\"assert\"",
        "\"default\"",
        "\"goto\"",
        "\"package\"",
        "\"synchronized\"",
        "\"do\"",
        "\"if\"",
        "\"private\"",
        "\"this\"",
        "\"break\"",
        "\"implements\"",
        "\"protected\"",
        "\"throw\"",
        "\"else\"",
        "\"import\"",
        "\"public\"",
        "\"throws\"",
        "\"case\"",
        "\"enum\"",
        "\"instanceof\"",
        "\"return\"",
        "\"transient\"",
        "\"catch\"",
        "\"extends\"",
        "\"try\"",
        "\"final\"",
        "\"interface\"",
        "\"static\"",
        "\"class\"",
        "\"finally\"",
        "\"strictfp\"",
        "\"volatile\"",
        "\"const\"",
        "\"native\"",
        "\"super\"",
        "\"while\"",
        "\"void\"",
        "WS",
        "DIGIT",
        "LETTER",
        "Escape",
        "DELIMETER",
        "MISC",
        "IDENT"
    };
}
