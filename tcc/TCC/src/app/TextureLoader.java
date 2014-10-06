package app;

public class TextureLoader {
    
    private static TextureLoader instance = null;
    
    
    
    private TextureLoader(){
    
    }
    
    public static TextureLoader getInstance(){
        if(instance == null)
            instance = new TextureLoader();
        return instance;
    }
    
}
