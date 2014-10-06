package gamer;

public class Proto {
    
    public static int x;
    public static int y;
    
    //##########################################################################
    
    /*
     * sentido: InfoCenter
     * esquerda = 0
     * direita  = 1
     */
    
    public static void setarSentidoParaEsquerda(){
        InfoCenter.sentido = 0;
    }
    
    public static void setarSentidoParaDireita(){
        InfoCenter.sentido = 1;
    }
    
    public static void sortearSentido(){
        if((int) ((int) 1 + (Math.random() * 2)) == 1){
            InfoCenter.sentido = 1;
        } else {
            InfoCenter.sentido = 0;
        }
    }
    
    public static void inverterSentido(){
        if(InfoCenter.sentido == 0){
            InfoCenter.sentido = 1;
        } else {
            InfoCenter.sentido = 0;
        }
    }
    
    //##########################################################################
    
    public static void moverParaSentido(){
        if(InfoCenter.sentido == 0){ moverEsquerda(); } else { moverDireita(); }
    }
    
    public static void moverDireita(){
        InfoCenter.zeraRobotActions();
        InfoCenter.moverDireita = true;
    }
    
    public static void moverEsquerda(){
        InfoCenter.zeraRobotActions();
        InfoCenter.moverEsqueda = true;
    }
    
    //##########################################################################
    
    public static void pularParaSentido(){
        if(InfoCenter.sentido == 0){ pularEsquerda(); } else { pularDireita(); }
    }
    
    public static void pularDireita(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pularDireita = true;
    }
    
    public static void pularEsquerda(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pularEsquerda = true;
    }
    
    public static void pular(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pular = true;
    }
    
    //##########################################################################
    
    public static void subir(){
        InfoCenter.zeraRobotActions();
        InfoCenter.subir = true;
    }
    
    
    public static void descer(){
        InfoCenter.zeraRobotActions();
        InfoCenter.descer = true;
    }
    
    //##########################################################################
    
    public static int escanear(int x, int y){
        if(x>0 && y > 0 && x <= 20 && y <= 10){
            return InfoCenter.map[x-1][y-1];
        } else {
            return 0;
        }
        
    }
}
