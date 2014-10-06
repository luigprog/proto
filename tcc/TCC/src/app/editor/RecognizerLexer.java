package app.editor;

import javax.swing.text.StyledDocument;
import javax.swing.text.Style;
import javax.swing.text.Element;
import javax.swing.text.BadLocationException;
import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class RecognizerLexer extends antlr.CharScanner implements RecognizerParserTokenTypes, TokenStream {

    public RecognizerLexer(InputStream in) {
        this(new ByteBuffer(in));
    }

    public RecognizerLexer(Reader in) {
        this(new CharBuffer(in));
    }

    public RecognizerLexer(InputBuffer ib) {
        this(new LexerSharedInputState(ib));
    }

    public RecognizerLexer(LexerSharedInputState state) {
        super(state);
        caseSensitiveLiterals = true;
        setCaseSensitive(true);
        literals = new Hashtable();
        literals.put(new ANTLRHashString("public", this), new Integer(38));
        literals.put(new ANTLRHashString("static", this), new Integer(50));
        literals.put(new ANTLRHashString("short", this), new Integer(16));
        literals.put(new ANTLRHashString("synchronized", this), new Integer(27));
        literals.put(new ANTLRHashString("super", this), new Integer(57));
        literals.put(new ANTLRHashString("boolean", this), new Integer(15));
        literals.put(new ANTLRHashString("abstract", this), new Integer(18));
        literals.put(new ANTLRHashString("for", this), new Integer(20));
        literals.put(new ANTLRHashString("if", this), new Integer(29));
        literals.put(new ANTLRHashString("class", this), new Integer(51));
        literals.put(new ANTLRHashString("throw", this), new Integer(35));
        literals.put(new ANTLRHashString("try", this), new Integer(47));
        literals.put(new ANTLRHashString("float", this), new Integer(11));
        literals.put(new ANTLRHashString("while", this), new Integer(58));
        literals.put(new ANTLRHashString("final", this), new Integer(48));
        literals.put(new ANTLRHashString("throws", this), new Integer(39));
        literals.put(new ANTLRHashString("char", this), new Integer(14));
        literals.put(new ANTLRHashString("native", this), new Integer(56));
        literals.put(new ANTLRHashString("strictfp", this), new Integer(53));
        literals.put(new ANTLRHashString("break", this), new Integer(32));
        literals.put(new ANTLRHashString("const", this), new Integer(55));
        literals.put(new ANTLRHashString("this", this), new Integer(31));
        literals.put(new ANTLRHashString("switch", this), new Integer(22));
        literals.put(new ANTLRHashString("catch", this), new Integer(45));
        literals.put(new ANTLRHashString("transient", this), new Integer(44));
        literals.put(new ANTLRHashString("private", this), new Integer(30));
        literals.put(new ANTLRHashString("enum", this), new Integer(41));
        literals.put(new ANTLRHashString("double", this), new Integer(12));
        literals.put(new ANTLRHashString("else", this), new Integer(36));
        literals.put(new ANTLRHashString("extends", this), new Integer(46));
        literals.put(new ANTLRHashString("protected", this), new Integer(34));
        literals.put(new ANTLRHashString("continue", this), new Integer(19));
        literals.put(new ANTLRHashString("case", this), new Integer(40));
        literals.put(new ANTLRHashString("byte", this), new Integer(13));
        literals.put(new ANTLRHashString("void", this), new Integer(59));
        literals.put(new ANTLRHashString("implements", this), new Integer(33));
        literals.put(new ANTLRHashString("import", this), new Integer(37));
        literals.put(new ANTLRHashString("interface", this), new Integer(49));
        literals.put(new ANTLRHashString("do", this), new Integer(28));
        literals.put(new ANTLRHashString("long", this), new Integer(17));
        literals.put(new ANTLRHashString("assert", this), new Integer(23));
        literals.put(new ANTLRHashString("int", this), new Integer(10));
        literals.put(new ANTLRHashString("package", this), new Integer(26));
        literals.put(new ANTLRHashString("volatile", this), new Integer(54));
        literals.put(new ANTLRHashString("goto", this), new Integer(25));
        literals.put(new ANTLRHashString("return", this), new Integer(43));
        literals.put(new ANTLRHashString("finally", this), new Integer(52));
        literals.put(new ANTLRHashString("default", this), new Integer(24));
        literals.put(new ANTLRHashString("new", this), new Integer(21));
        literals.put(new ANTLRHashString("instanceof", this), new Integer(42));
        //lsg
        literals.put(new ANTLRHashString("String", this), new Integer(10));
        
    }

    public Token nextToken() throws TokenStreamException {
        Token theRetToken = null;
        tryAgain:
        for (;;) {
            Token _token = null;
            int _ttype = Token.INVALID_TYPE;
            resetText();
            try {  
                try {   
                    switch (LA(1)) {
                        case '"': {
                            mSTRING_LIT(true);
                            theRetToken = _returnToken;
                            break;
                        }
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z': {
                            mIDENT(true);
                            theRetToken = _returnToken;
                            break;
                        }
                        default:
                            if ((LA(1) == '0') && (LA(2) == 'x')) {
                                mHEX_DIGIT(true);
                                theRetToken = _returnToken;
                            } else if ((LA(1) == '/') && (LA(2) == '/')) {
                                mSL_COMMENT(true);
                                theRetToken = _returnToken;
                            } else if ((LA(1) == '/') && (LA(2) == '*')) {
                                mML_COMMENT(true);
                                theRetToken = _returnToken;
                            } else if (((LA(1) >= '0' && LA(1) <= '9')) && (true)) {
                                mINTLT(true);
                                theRetToken = _returnToken;
                            } else if ((LA(1) == '\'') && (true) && (true) && (true) && (true)) {
                                mCHARLIT(true);
                                theRetToken = _returnToken;
                            } else if ((_tokenSet_0.member(LA(1))) && (true) && (true) && (true) && (true)) {
                                mDELIMETER(true);
                                theRetToken = _returnToken;
                            } else {
                                if (LA(1) == EOF_CHAR) {
                                    uponEOF();
                                    _returnToken = makeToken(Token.EOF_TYPE);
                                } else {
                                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                                }
                            }
                    }
                    if (_returnToken == null) {
                        continue tryAgain; 
                    }
                    _ttype = _returnToken.getType();
                    _returnToken.setType(_ttype);
                    return _returnToken;
                } catch (RecognitionException e) {
                    throw new TokenStreamRecognitionException(e);
                }
            } catch (CharStreamException cse) {
                if (cse instanceof CharStreamIOException) {
                    throw new TokenStreamIOException(((CharStreamIOException) cse).io);
                } else {
                    throw new TokenStreamException(cse.getMessage());
                }
            }
        }
    }

    protected final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = WS;
        int _saveIndex;

        {
            switch (LA(1)) {
                case ' ': {
                    match(' ');
                    break;
                }
                case '\t': {
                    match('\t');
                    break;
                }
                case '\u000c': {
                    match('\f');
                    break;
                }
                case '\n':
                case '\r': {
                    {
                        if ((LA(1) == '\r') && (LA(2) == '\n')) {
                            match("\r\n");
                        } else if ((LA(1) == '\r') && (true)) {
                            match('\r');
                        } else if ((LA(1) == '\n')) {
                            match('\n');
                        } else {
                            throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                        }

                    }
                    if (inputState.guessing == 0) {
                        newline();
                    }
                    break;
                }
                default: {
                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                }
            }
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    protected final void mDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = DIGIT;
        int _saveIndex;

        matchRange('0', '9');
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    protected final void mLETTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = LETTER;
        int _saveIndex;

        {
            switch (LA(1)) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z': {
                    matchRange('a', 'z');
                    break;
                }
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z': {
                    matchRange('A', 'Z');
                    break;
                }
                default: {
                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                }
            }
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mINTLT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = INTLT;
        int _saveIndex;
        Token a = null;

        {
            int _cnt587 = 0;
            _loop587:
            do {
                if (((LA(1) >= '0' && LA(1) <= '9'))) {
                    mDIGIT(true);
                    a = _returnToken;
                } else {
                    if (_cnt587 >= 1) {
                        break _loop587;
                    } else {
                        throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                    }
                }

                _cnt587++;
            } while (true);
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mHEX_DIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = HEX_DIGIT;
        int _saveIndex;

        match("0x");
        {
            _loop590:
            do {
                switch (LA(1)) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9': {
                        mDIGIT(false);
                        break;
                    }
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f': {
                        matchRange('a', 'f');
                        break;
                    }
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F': {
                        matchRange('A', 'F');
                        break;
                    }
                    default: {
                        break _loop590;
                    }
                }
            } while (true);
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = SL_COMMENT;
        int _saveIndex;

        match("//");
        {
            _loop594:
            do {
                if ((_tokenSet_1.member(LA(1)))) {
                    {
                        match(_tokenSet_1);
                    }
                } else {
                    break _loop594;
                }

            } while (true);
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mML_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = ML_COMMENT;
        int _saveIndex;

        match("/*");
        {
            _loop598:
            do {
                if ((LA(1) == '\r') && (LA(2) == '\n') && (true) && (true) && (true)) {
                    match('\r');
                    match('\n');
                    if (inputState.guessing == 0) {
                        newline();
                    }
                } else if (((LA(1) == '*') && (true) && (true) && (true) && (true)) && (LA(2) != '/')) {
                    match('*');
                } else if ((LA(1) == '\r') && (true) && (true) && (true) && (true)) {
                    match('\r');
                    if (inputState.guessing == 0) {
                        newline();
                    }
                } else if ((LA(1) == '\n')) {
                    match('\n');
                    if (inputState.guessing == 0) {
                        newline();
                    }
                } else if ((_tokenSet_2.member(LA(1)))) {
                    {
                        match(_tokenSet_2);
                    }
                } else {
                    break _loop598;
                }

            } while (true);
        }
        {
            if ((LA(1) == '*')) {
                match("*/");
            } else {
            }

        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mCHARLIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = CHARLIT;
        int _saveIndex;

        match('\'');
        {
            _loop603:
            do {
                if ((_tokenSet_3.member(LA(1)))) {
                    {
                        match(_tokenSet_3);
                    }
                } else {
                    break _loop603;
                }

            } while (true);
        }
        {
            if ((LA(1) == '\'')) {
                match('\'');
            } else {
            }

        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    protected final void mEscape(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = Escape;
        int _saveIndex;

        match('\\');
        {
            switch (LA(1)) {
                case '0':
                case '1':
                case '2':
                case '3': {
                    {
                        matchRange('0', '3');
                    }
                    {
                        _loop610:
                        do {
                            if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true) && (true) && (true)) {
                                mDIGIT(false);
                            } else {
                                break _loop610;
                            }

                        } while (true);
                    }
                    break;
                }
                case '4':
                case '5':
                case '6':
                case '7': {
                    {
                        matchRange('4', '7');
                    }
                    {
                        _loop613:
                        do {
                            if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true) && (true) && (true)) {
                                mDIGIT(false);
                            } else {
                                break _loop613;
                            }

                        } while (true);
                    }
                    break;
                }
                case 'x': {
                    match('x');
                    {
                        int _cnt615 = 0;
                        _loop615:
                        do {
                            if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true) && (true) && (true)) {
                                mDIGIT(false);
                            } else if (((LA(1) >= 'a' && LA(1) <= 'f')) && (true) && (true) && (true) && (true)) {
                                matchRange('a', 'f');
                            } else if (((LA(1) >= 'A' && LA(1) <= 'F')) && (true) && (true) && (true) && (true)) {
                                matchRange('A', 'F');
                            } else {
                                if (_cnt615 >= 1) {
                                    break _loop615;
                                } else {
                                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                                }
                            }

                            _cnt615++;
                        } while (true);
                    }
                    break;
                }
                default:
                    if ((_tokenSet_4.member(LA(1)))) {
                        {
                            match(_tokenSet_4);
                        }
                    } else {
                        throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                    }
            }
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mSTRING_LIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = STRING_LIT;
        int _saveIndex;

        match('"');
        {
            _loop623:
            do {
                boolean synPredMatched620 = false;
                if (((LA(1) == '\\') && (_tokenSet_5.member(LA(2))) && (true) && (true) && (true))) {
                    int _m620 = mark();
                    synPredMatched620 = true;
                    inputState.guessing++;
                    try {
                        {
                            match('\\');
                            {
                                match(_tokenSet_6);
                            }
                        }
                    } catch (RecognitionException pe) {
                        synPredMatched620 = false;
                    }
                    rewind(_m620);
                    inputState.guessing--;
                }
                if (synPredMatched620) {
                    mEscape(false);
                } else if ((LA(1) == '\n' || LA(1) == '\r' || LA(1) == '\\') && (true) && (true) && (true) && (true)) {
                    {
                        switch (LA(1)) {
                            case '\r': {
                                match('\r');
                                if (inputState.guessing == 0) {
                                    newline();
                                }
                                break;
                            }
                            case '\n': {
                                match('\n');
                                if (inputState.guessing == 0) {
                                    newline();
                                }
                                break;
                            }
                            case '\\': {
                                match('\\');
                                match('\n');
                                if (inputState.guessing == 0) {
                                    newline();
                                }
                                break;
                            }
                            default: {
                                throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                            }
                        }
                    }
                } else if ((_tokenSet_7.member(LA(1)))) {
                    {
                        match(_tokenSet_7);
                    }
                } else {
                    break _loop623;
                }

            } while (true);
        }
        {
            if ((LA(1) == '"')) {
                match('"');
            } else {
            }

        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mDELIMETER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = DELIMETER;
        int _saveIndex;

        {
            switch (LA(1)) {
                case '\t':
                case '\n':
                case '\u000c':
                case '\r':
                case ' ': {
                    mWS(false);
                    break;
                }
                case '.': {
                    match('.');
                    break;
                }
                case ':': {
                    match(':');
                    break;
                }
                case ';': {
                    match(';');
                    break;
                }
                case ',': {
                    match(',');
                    break;
                }
                case '[': {
                    match('[');
                    break;
                }
                case ']': {
                    match(']');
                    break;
                }
                case '(': {
                    match('(');
                    break;
                }
                case ')': {
                    match(')');
                    break;
                }
                case '{': {
                    match('{');
                    break;
                }
                case '}': {
                    match('}');
                    break;
                }
                case '+': {
                    match('+');
                    break;
                }
                case '-': {
                    match('-');
                    break;
                }
                case '*': {
                    match('*');
                    break;
                }
                case '/': {
                    match('/');
                    break;
                }
                case '%': {
                    match('%');
                    break;
                }
                case '!': {
                    match('!');
                    break;
                }
                case '#': {
                    match('#');
                    break;
                }
                case '$': {
                    match('$');
                    break;
                }
                case '`': {
                    match('`');
                    break;
                }
                case '^': {
                    match('^');
                    break;
                }
                case '\'': {
                    match('\'');
                    break;
                }
                default:
                    if ((LA(1) == '<') && (LA(2) == '=')) {
                        match("<=");
                    } else if ((LA(1) == '>') && (LA(2) == '=')) {
                        match(">=");
                    } else if ((LA(1) == '|') && (LA(2) == '|')) {
                        match("||");
                    } else if ((LA(1) == '&') && (LA(2) == '&')) {
                        match("&&");
                    } else if ((LA(1) == '>') && (LA(2) == '>')) {
                        match(">>");
                    } else if ((LA(1) == '<') && (LA(2) == '<')) {
                        match("<<");
                    } else if ((LA(1) == '=') && (LA(2) == '=')) {
                        match("==");
                    } else if ((LA(1) == '~') && (LA(2) == '=')) {
                        match("~==");
                    } else if ((LA(1) == '=') && (true)) {
                        match('=');
                    } else if ((LA(1) == '<') && (true)) {
                        match('<');
                    } else if ((LA(1) == '>') && (true)) {
                        match('>');
                    } else if ((LA(1) == '&') && (true)) {
                        match('&');
                    } else if ((LA(1) == '~') && (true)) {
                        match('~');
                    } else if ((LA(1) == '|') && (true)) {
                        match('|');
                    } else {
                        throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
                    }
            }
        }
        if (inputState.guessing == 0) {
            _ttype = Token.SKIP;
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    protected final void mMISC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = MISC;
        int _saveIndex;

        switch (LA(1)) {
            case '-': {
                match('-');
                break;
            }
            case '_': {
                match('_');
                break;
            }
            default: {
                throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
            }
        }
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    public final void mIDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
        int _ttype;
        Token _token = null;
        int _begin = text.length();
        _ttype = IDENT;
        int _saveIndex;

        mLETTER(false);
        {
            _loop630:
            do {
                switch (LA(1)) {
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'O':
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                    case 'T':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z': {
                        mLETTER(false);
                        break;
                    }
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9': {
                        mDIGIT(false);
                        break;
                    }
                    case '-':
                    case '_': {
                        mMISC(false);
                        break;
                    }
                    default: {
                        break _loop630;
                    }
                }
            } while (true);
        }
        if (inputState.guessing == 0) {
            _ttype = Token.SKIP;
        }
        _ttype = testLiteralsTable(_ttype);
        if (_createToken && _token == null && _ttype != Token.SKIP) {
            _token = makeToken(_ttype);
            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
        }
        _returnToken = _token;
    }

    private static final long[] mk_tokenSet_0() {
        long[] data = new long[131];
        data[0] = 8935423114204952064L;
        data[1] = 8646911290591150080L;
        return data;
    }
    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

    private static final long[] mk_tokenSet_1() {
        long[] data = new long[260];
        data[0] = -9224L;
        for (int i = 1; i <= 3; i++) {
            data[i] = -1L;
        }
        for (int i = 64; i <= 127; i++) {
            data[i] = -1L;
        }
        return data;
    }
    public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());

    private static final long[] mk_tokenSet_2() {
        long[] data = new long[260];
        data[0] = -4398046520328L;
        for (int i = 1; i <= 3; i++) {
            data[i] = -1L;
        }
        for (int i = 64; i <= 127; i++) {
            data[i] = -1L;
        }
        return data;
    }
    public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());

    private static final long[] mk_tokenSet_3() {
        long[] data = new long[260];
        data[0] = -549755813896L;
        for (int i = 1; i <= 3; i++) {
            data[i] = -1L;
        }
        for (int i = 64; i <= 127; i++) {
            data[i] = -1L;
        }
        return data;
    }
    public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());

    private static final long[] mk_tokenSet_4() {
        long[] data = new long[260];
        data[0] = -71776119061217288L;
        data[1] = -72057594037927937L;
        for (int i = 2; i <= 3; i++) {
            data[i] = -1L;
        }
        for (int i = 64; i <= 127; i++) {
            data[i] = -1L;
        }
        return data;
    }
    public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());

    private static final long[] mk_tokenSet_5() {
        long[] data = new long[260];
        data[0] = -8L;
        for (int i = 1; i <= 3; i++) {
            data[i] = -1L;
        }
        for (int i = 64; i <= 127; i++) {
            data[i] = -1L;
        }
        return data;
    }
    public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());

    private static final long[] mk_tokenSet_6() {
        long[] data = new long[260];
        data[0] = -1032L;
        for (int i = 1; i <= 3; i++) {
            data[i] = -1L;
        }
        for (int i = 64; i <= 127; i++) {
            data[i] = -1L;
        }
        return data;
    }
    public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());

    private static final long[] mk_tokenSet_7() {
        long[] data = new long[260];
        data[0] = -17179878408L;
        data[1] = -268435457L;
        for (int i = 2; i <= 3; i++) {
            data[i] = -1L;
        }
        for (int i = 64; i <= 127; i++) {
            data[i] = -1L;
        }
        return data;
    }
    public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
}
