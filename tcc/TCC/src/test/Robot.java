package test;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Robot {
    
    /*private int speed = 2;
    private Animation current,movingRight, movingLeft, jumping, climbing, standing;
    //--------------------------------------------------------------------- Jump
    private boolean JUMP = false;
    private float jumpDestiny;
    private float forceJump = 0;
    private boolean FALL = false;
    //------------------------------------------------------------------- Physic
    private float gravity = 0.2f;
    
    public Robot(){
        this.x = 0;
        this.y = 0;
        this.init();
    }
    
    public Robot(int x, int y){
        this.x = x;
        this.y = y;
        this.init();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        super.update(gc, sbg, delta); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        super.render(gc, sbg, g); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    private void init() {
        try {
            this.initAnimations();  
        } catch (SlickException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(){
        if(JUMP){
            y += forceJump;
            if(forceJump < 5)
                forceJump += gravity;
        }
    }

    private void initAnimations() throws SlickException{
        Image[] stand = {new Image("assets/game/stand/stand.png")};
        
        Image[] moveRight = {   new Image("assets/game/move/moveRight1.png"),
                                new Image("assets/game/move/moveRight2.png"),
                                new Image("assets/game/move/moveRight3.png")
        };
        
        Image[] moveLeft = {    new Image("assets/game/move/moveLeft1.png"),
                                new Image("assets/game/move/moveLeft2.png"),
                                new Image("assets/game/move/moveLeft3.png")
        };
        
        Image[] jump = {new Image("assets/game/jump/jump.png")};
        
        Image[] climb = {new Image("assets/game/stand/stand.png")};
        
        standing = new Animation(stand, new int[] {200}, false);
        movingRight = new Animation(moveRight, new int[] {200,200,200}, false);
        movingLeft = new Animation(moveLeft, new int[] {200,200,200}, false);
        jumping = new Animation(jump, new int[] {200}, false);
        climbing = new Animation(climb, new int[] {200}, false);
        
        atual = standing;
    }
    
    public Animation getActualAnimation(){
        
        return atual;     
    }
    
    public void draw(){
        atual.draw(x,y);
    }
    
    public void moveRight(int delta){
        this.x += speed;
        if(!JUMP)
        atual = movingRight;
        
        atual.update(delta);
    }
    
    public void moveLeft(int delta){
        this.x -= speed;
        if(!JUMP)
        atual = movingLeft;
        
        atual.update(delta);
    }
    
    public void stand(int delta){
        atual = standing;
        atual.update(delta);
    }
    
    public void jump(int delta){
        if(!JUMP){
            JUMP = true;
            atual = jumping;
            this.forceJump = -5;
        }
    }*/
    
}
