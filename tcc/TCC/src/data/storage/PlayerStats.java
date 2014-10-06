package data.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import util.Universal;

public class PlayerStats {
    
    private static PlayerStats instance = null;
    private String path = Universal.playerFolderPath + java.io.File.separator + "playerStats.properties";
    private Properties properties;
    
    public static PlayerStats getInstance(){
        if(instance == null)
            instance = new PlayerStats();
        return instance;
    }
    
    private PlayerStats(){
        properties = new Properties();
        
        try {
            if (!new File(path).exists()) { // Verifica se path existe. 
                properties.setProperty(encode("total"), encode("0"));
                properties.setProperty(encode("level"), encode("Iniciante"));
                properties.setProperty(encode("fase1"), encode("0"));
                properties.store(new FileOutputStream(path), null);
            }
        } catch (Exception ex) {
            //
        }
        
        
        try {
            properties.load(new FileInputStream(path));

        } catch (IOException ex) {
            //
        }
        
    }
    
    private void store(){
        try {
            properties.store(new FileOutputStream(path), null);
        } catch (Exception ex) {
        }
    }
    
    public void setFasePoints(int faseNumber, String value){
        properties.setProperty(encode("fase" + faseNumber), encode(value));
        
        int pointAux = 0;
        for (int i = 1; i <= Universal.quantidadeFases; i++) {
            if(properties.getProperty(encode("fase" + i)) == null){
                break;
            } else {
                pointAux += Integer.parseInt(decode(properties.getProperty(encode("fase" + i))));
            }    
        }
        properties.setProperty(encode("total"), encode(pointAux + ""));
        
        String levelAux = "";
        if(pointAux < 400){
            levelAux = "Iniciante";
        } else if (pointAux < 600){
            levelAux = "Regular";
        } else {
            levelAux = "Expert";
        }
        properties.setProperty(encode("level"), encode(levelAux));
        
        store();
    }
    
    public String getProperty(String name){
        if(properties.getProperty(encode(name)) == null){
            return null;
        }else {
            return decode(properties.getProperty(encode(name)));
        } 
    }
    
    private String encode(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        str = new String(encoder.encodeBuffer(str.getBytes()));
        return str;
    }

    private String decode(String str) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            str = new String(decoder.decodeBuffer(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    
}
