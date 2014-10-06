package app.editor;

import java.awt.Color;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class SearchMachine
{
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter
    {
        public MyHighlightPainter(Color color)
        {
            super(color);            
        }
    }
    
    private Highlighter.HighlightPainter myHighlightPainter;
    
    private JTextComponent txtComponent;
    
    public SearchMachine(JTextComponent txtComponent)
    {
        setTxtComponent(txtComponent);
        myHighlightPainter = new MyHighlightPainter(Color.YELLOW);
    }
    

    private void setTxtComponent(JTextComponent txtComponent2)
    {
        if (txtComponent2 == null)
            throw new IllegalArgumentException("Text component cannot be null!");
        
        this.txtComponent = txtComponent2;
    }


    public void removeHighlights()
    {
        Highlighter hilite = txtComponent.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (int i = 0; i < hilites.length; i++)
            if (hilites[i].getPainter() instanceof MyHighlightPainter)
                hilite.removeHighlight(hilites[i]);
    }

    public void find(String pattern)
    {    	
        removeHighlights();

        try
        {
            Highlighter hilite = txtComponent.getHighlighter();
            Document doc = txtComponent.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            while ((pos = text.indexOf(pattern, pos)) >= 0)
            {
                hilite.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                pos += pattern.length();
            }
        }
        catch (BadLocationException e)
        {
        	e.printStackTrace();
        }
        
        txtComponent.setCaretPosition(0);
    }


	public boolean next(final String pattern) 
	{
		final int pos;
		String text = txtComponent.getText();
		
        pos = text.indexOf(pattern, txtComponent.getCaretPosition());
                
		if ( pos != -1)
        {	
            select(pos, pos + pattern.length());
            return true;
        }
        
        return false;
	}
	
	public boolean previous(final String pattern) 
	{
		final int pos;
		String text = txtComponent.getText();
		
        pos = text.lastIndexOf(pattern, txtComponent.getCaretPosition() - pattern.length() - 1);
        
		if ( pos != -1)
        {
            select(pos, pos + pattern.length());
            return true;
        }
        
        return false;
	}
    
    private synchronized void select(final int posStart, final int posEnd)    
    {
    	txtComponent.setCaretPosition(posStart);
    	txtComponent.moveCaretPosition(posEnd);
        txtComponent.setSelectedTextColor(Color.RED);
    }

    
    public void replaceSelected(final String newString)
    {
    	txtComponent.replaceSelection(newString);
    }    
    
    public void replaceNext(String oldString, String newString)
    {
        if (next(oldString))
            txtComponent.replaceSelection(newString);                
    }
    
    public void replaceAll(String oldString, String newString)
    {           
        find(oldString);
        
        while( next(oldString) )
            replaceSelected(newString);        
    }
   
    
    class Select implements Runnable
    {
        int pos, pos2;
        
        public Select(int pos, int pos2)
        {
            this.pos  = pos;
            this.pos2 = pos2;
        }
        
        public void run()
        {
        	txtComponent.select(pos, pos2);
        }
    }
}


