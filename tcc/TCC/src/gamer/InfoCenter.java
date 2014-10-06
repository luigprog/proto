package gamer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import util.Universal;

public class InfoCenter {

    //-------------------------------------------------------------------- PROTO
        // atribs
    public static int sentido = 1; // 0:esquerda    1:direita
        // actions
    public static boolean moverDireita;
    public static boolean moverEsqueda;
    public static boolean pularDireita;
    public static boolean pular;
    public static boolean pularEsquerda;
    public static boolean subir;
    public static boolean descer;
        // functions
    public static void zeraRobotActions() {
        moverDireita = false;
        moverEsqueda = false;
        pularDireita = false;
        pular = false;
        pularEsquerda = false;
        subir = false;
        descer = false;
    }
    
    //---------------------------------------------------------------------- MAP
    public static int map_nada = 0;
    public static int map_solido = 1;
    public static int map_escada = 2;
    public static int map_objetivo = 3;
    public static int map_esfera = 4;
    public static int map_solidoEscada = 5;
    
    public static int map[][] = new int[20][10];

    public static void carregaMapa() {

        try {
            FileReader arq = new FileReader("assets/game/fases/fase" + Universal.currentFaseId + "/map.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();

            String aux[];
            
            int j = 0;
            while (linha != null) {
                
                aux = linha.split(",");
                
                for (int i = 0; i < 20; i++) {
                    map[i][j] = Integer.parseInt(aux[i]);
                    
                }
                j++;
                linha = lerArq.readLine(); // lê da segunda até a última linha } 
            }
            
            arq.close();
        } catch(IOException e){
            
        }
        
        //printMap();

    }
    
    public static void printMap(){
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20; i++) {
                System.out.print("[" + map[i][j] + "]");
                
            }
            System.out.println();
        }
    }
    
}
