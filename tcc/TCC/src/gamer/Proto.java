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
    
    public static void setDirectionToLeft(){
        InfoCenter.sentido = 0;
    }
    
    public static void setDirectionToRight(){
        InfoCenter.sentido = 1;
    }
    
    public static void randomizeDirection(){
        if((int) ((int) 1 + (Math.random() * 2)) == 1){
            InfoCenter.sentido = 1;
        } else {
            InfoCenter.sentido = 0;
        }
    }
    
    public static void reverseDirection(){
        if(InfoCenter.sentido == 0){
            InfoCenter.sentido = 1;
        } else {
            InfoCenter.sentido = 0;
        }
    }
    
    public static void flipDirectionTo(int x){
        if(Proto.x > x)
            setDirectionToLeft();
        else
            setDirectionToRight();            
    }
    //##########################################################################
    
    public static void moveToDirection(){
        if(InfoCenter.sentido == 0){ moveLeft(); } else { moveRight(); }
    }
    
    public static void moveRight(){
        InfoCenter.zeraRobotActions();
        InfoCenter.moverDireita = true;
    }
    
    public static void moveLeft(){
        InfoCenter.zeraRobotActions();
        InfoCenter.moverEsqueda = true;
    }
    
    //##########################################################################
    
    public static void jumpToDirection(){
        if(InfoCenter.sentido == 0){ jumpLeft(); } else { jumpRight(); }
    }
    
    public static void jumpRight(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pularDireita = true;
    }
    
    public static void jumpLeft(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pularEsquerda = true;
    }
    
    public static void jump(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pular = true;
    }
    
    //##########################################################################
    
    public static void climbUp(){
        InfoCenter.zeraRobotActions();
        InfoCenter.subir = true;
    }
    
    
    public static void climbDown(){
        InfoCenter.zeraRobotActions();
        InfoCenter.descer = true;
    }
    
    //##########################################################################
    public static int scan(int x, int y){
        return scan(x, y, false);
    }
    
    public static int scan(int x, int y, boolean multiplyDirection){
        if(multiplyDirection){
            x = (InfoCenter.sentido == 0? x*-1:x);
        }
        return globalScan(Proto.x + x, Proto.y + y);
    }
    
    public static int globalScan(int x, int y){
        if(x>0 && y > 0 && x <= 20 && y <= 10){
            return InfoCenter.map[x-1][y-1];
        } else {
            return 0;
        }
    }
}
