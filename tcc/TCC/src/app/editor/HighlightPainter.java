package app.editor;

import javax.swing.SwingUtilities;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;


public class HighlightPainter
{
    private Style normalStyle;
    private StyledDocument document;
        
    public HighlightPainter(StyledDocument document)
    {
        setDocument(document);
        normalStyle = StyleManager.getInstance().getStyle(Styles.NORMAL).getStyle();
    }

    private void setDocument(StyledDocument document2)
    {
        if (document2 == null)
            throw new IllegalArgumentException("Document cannot be null!");

        this.document = document2;
    }

   
    public void highlight(final int offset, final int lenght,
            final Style style)
    {
        if (lenght == 0)
            return;
        
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                document.setCharacterAttributes(offset, lenght, style, true);
            }
        });
    }

    public void cleanUp(int offset, int lenght)
    {
        highlight(offset, lenght, normalStyle);
    }
}
