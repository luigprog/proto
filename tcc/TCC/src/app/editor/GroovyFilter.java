package app.editor;

import java.io.BufferedReader;
import java.io.StringReader;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

public class GroovyFilter implements DocumentListener {

    private StyledDocument document;
    private HighlightPainter painter;

    public GroovyFilter(StyledDocument doc) {
        setDocument(doc);
        painter = new HighlightPainter(doc);
    }

    private void setDocument(StyledDocument document) {
        if (document == null) {
            throw new IllegalArgumentException("StyledDocument cannot be null!");
        }

        this.document = document;
    }

    public StyledDocument getDocument() {
        return document;
    }

    public HighlightPainter getPainter() {
        return painter;
    }

    private void parse(BufferedReader reader) {
        RecognizerLexer lexer = new RecognizerLexer(reader);
        RecognizerParser parser = new RecognizerParser(lexer);
        lexer.setTabSize(1);

        try {
            parser.start(document, painter);
        } catch (Exception e) {
            EditorLog.thrown(getClass(), "parse", e);
        }

    }

    protected void change() {
        try {
            Document doc = getDocument();
            String text = doc.getText(doc.getStartPosition().getOffset(),
                    doc.getEndPosition().getOffset());
            BufferedReader reader = new BufferedReader(new StringReader(text));

            getPainter().cleanUp(0, doc.getEndPosition().getOffset());
            parse(reader);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void startChangeThread(final DocumentEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                change();
            }
        });
    }

    public void removeUpdate(DocumentEvent docEvt) {
        startChangeThread(docEvt);
    }

    public void insertUpdate(DocumentEvent docEvt) {
        startChangeThread(docEvt);
    }

    public void changedUpdate(DocumentEvent e) {
    }
}
