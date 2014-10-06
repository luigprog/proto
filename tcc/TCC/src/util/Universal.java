package util;

import app.VariavelTableNode;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Universal {
 
    public static String plataforma = "Windows";
    
    public static String playerFolderPath = System.getProperty("user.home") + java.io.File.separator + "tcc";
    public static int quantidadeFases = 7;
    
    public static int currentFaseId;
    public static String currentCode;
    public static ArrayList<VariavelTableNode> currentVariables;
    
    public static JFrame currentJframe;
    
    public static boolean egg_keyboardControl = false;
    
    public static int splashScreenTime = 5000; // tempo que a splash screen vai ficar visível até chamar o menu principal
    
    public static int gameScreen_width = 1000;
    public static int gameScreen_height = 500;
    
    
    
}
