package gamer;

/**
 * The robot's class.This class contains methods to make Proto move, jump, climb, scan the scenario, etc.
 * @author Luigi Garcia
 */
public class Proto {
    
    /** (Readonly)The horizontal position value at the "grid". */
    public static int x;
    /** (Readonly)The vertical position value at the "grid". */
    public static int y;
    
    //##########################################################################
    
    /*
     * sentido: InfoCenter
     * esquerda = 0
     * direita  = 1
     */
    
    /**
     * Set the robot direction to left.
     */
    public static void setDirectionToLeft(){
        InfoCenter.sentido = 0;
    }
    
    /**
     * Set the robot direction to right.
     */
    public static void setDirectionToRight(){
        InfoCenter.sentido = 1;
    }
    
    /**
     * Invert the robot direction: left becomes right and right becomes left.
     */
    public static void reverseDirection(){
        if(InfoCenter.sentido == 0){
            InfoCenter.sentido = 1;
        } else {
            InfoCenter.sentido = 0;
        }
    }
    
    /**
     * Set the direction based on some x position.The direction will point(right or left) to this x value.
     */
    public static void flipDirectionTo(int x){
        if(Proto.x > x)
            setDirectionToLeft();
        else
            setDirectionToRight();            
    }
    //##########################################################################
    
    /**
     * Makes the robot walk one "square" to the current direction(right or left).
     */
    public static void moveToDirection(){
        if(InfoCenter.sentido == 0){ moveLeft(); } else { moveRight(); }
    }
    
    /**
     * Makes the robot walk one "square" to right.
     */
    public static void moveRight(){
        InfoCenter.zeraRobotActions();
        InfoCenter.moverDireita = true;
    }
    
    /**
     * Makes the robot walk one "square" to left.
     */
    public static void moveLeft(){
        InfoCenter.zeraRobotActions();
        InfoCenter.moverEsqueda = true;
    }
    
    //##########################################################################
    
    /**
     * Makes the robot jump to the current direction(useful to avoid holes and obstacles).
     */
    public static void jumpToDirection(){
        if(InfoCenter.sentido == 0){ jumpLeft(); } else { jumpRight(); }
    }
    
    /**
     * Makes the robot jump to right(useful to avoid holes and obstacles).
     */
    public static void jumpRight(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pularDireita = true;
    }
    
    /**
     * Makes the robot jump to left(useful to avoid holes and obstacles).
     */
    public static void jumpLeft(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pularEsquerda = true;
    }
    
    /**
     * Makes the robot jump up, only in the vertical axis.
     */
    public static void jump(){
        InfoCenter.zeraRobotActions();
        InfoCenter.pular = true;
    }
    
    //##########################################################################
    /**
     * Climb up the stairs(If there are no stairs where the robot is, it does nothing).
     */
    public static void climbUp(){
        InfoCenter.zeraRobotActions();
        InfoCenter.subir = true;
    }
    
    /**
     * Climb down the stairs(If there are no stairs where the robot is, it does nothing).
     */
    public static void climbDown(){
        InfoCenter.zeraRobotActions();
        InfoCenter.descer = true;
    }
    
    //##########################################################################
    /**
     * Scan some "square" in the scenario, base on Proto's current position(works like a raycast).Example: if the robot's position is (2,4) and you scan(1,0), this actually will scan the square at (3,4).
     * @param x horizontal value.
     * @param y vertical value.
     * @return The returns can be one of this constants: none, solid, stairs, goal, sphere, solid_stairs.
     */
    public static int scan(int x, int y){
        return scan(x, y, false);
    }
    
    /**
     * Scan some "square" in the scenario, base on Proto's current position(works like a raycast).Example: if the robot's position is (2,4) and you scan(1,0), this actually will scan the square at (3,4).
     * @param x horizontal value.
     * @param y vertical value.
     * @param multiplyDirection if true, this will multiply the x value by the direction, example: if you scan (1,0,true) and the current direction is left, the scan will actually be (-1,0,true).
     * @return The returns can be one of this constants: none, solid, stairs, goal, sphere, solid_stairs.
     */
    public static int scan(int x, int y, boolean multiplyDirection){
        if(multiplyDirection){
            x = (InfoCenter.sentido == 0? x*-1:x);
        }
        return globalScan(Proto.x + x, Proto.y + y);
    }
    
    /**
     * Scan some "square" in the scenario based on zero point(does not work like a raycast).
     * @param x horizontal value.
     * @param y vertical value.
     * @return The returns can be one of this constants: none, solid, stairs, goal, sphere, solid_stairs.
     */
    public static int globalScan(int x, int y){
        if(x>0 && y > 0 && x <= 20 && y <= 10){
            if((x == Sphere1.x && y == Sphere1.y) || (x == Sphere2.x && y == Sphere2.y) || (x == Sphere3.x && y == Sphere3.y))
                return InfoCenter.map_esfera;
            else if (x == Goal.x && y == Goal.y)
                 return InfoCenter.map_objetivo;
            else
                return InfoCenter.map[x-1][y-1];
        } else {
            return 0;
        }
    }
}
