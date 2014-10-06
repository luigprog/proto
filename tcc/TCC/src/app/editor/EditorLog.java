package app.editor;

public class EditorLog 
{
	public static void thrown(Class cls, String method, Throwable e)
	{		
		e.printStackTrace();
	}
}
