package app;

import data.storage.PlayerStats;
import java.io.File;
import util.Universal;

public class MainOld {

    public static void main(String[] args) {
        //################################################# Player Folder Config
        try {
            if (!new File(Universal.playerFolderPath).exists()) { // Verifica se o diretório existe.   
                (new File(Universal.playerFolderPath)).mkdir();   // Cria o diretório   
            }
        } catch (Exception ex) {
            //
        }
        //########################################################### Properties
        PlayerStats.getInstance();
        //############################################################# Init App
        new App().setVisible(true);
    }
    
}
