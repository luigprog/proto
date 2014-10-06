package game.gameObjects;

import static game.gameObjects.GameObject.TYPE_SOLID;
import gamer.InfoCenter;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends GameObject {

    private Animation current,
            movingRight, movingLeft,
            jumping, jumpingRight, jumpingLeft,
            climbing,
            idle,amortecendoRight, amortecendoLeft, winning1, falling;
    
    public int width = 20;
    public int height = 100;
    public int speed = 2;
    
    public int starsQuant = 0;
    
    //------------------------------------------------------------------- Physic
    private float gravity = 0.2f;
    private float jumpForce = 0; // limit 5
    
    // --------------------------------------------------------- Support Actions
    private int move_x_destiny;
    private int jump_x_destiny;
    // ------------------------------------------------------------------ Status
    public int status;
    public int substatus;

    public static final int NONE_s = -1;
    public static final int MOVE_LEFT_s = 0;
    public static final int MOVE_RIGHT_s = 1;
    public static final int JUMP_RIGHT_s = 2;
    public static final int JUMP_s = 33;
    public static final int JUMP_LEFT_s = 4;
    public static final int CLIMB_s = 5;
    public static final int WINNING_s = 6;
    public static final int AMORTECENDO_RIGHT_s = 7;
    public static final int AMORTECENDO_LEFT_s = 8;
    public static final int FALLING_s = 9;
    
    public static final int CLIMB_UP_ss = 1001;
    public static final int CLIMB_DOWN_ss = 1002;
    // -------------------------------------------------------------- Utilidades
    public boolean isFreezed = false; // indica quando o jogo ta "parado", o player ta fazendo alguma ação parecida com uma animação.
    public boolean physAndLogic = true;
    
    
    public Player(float x, float y) {
        super(GameObject.TYPE_ACTOR, GameObject.NAME_PLAYER);
        this.x = x + 15;
        this.y = y;

        this.init();
    }

    //################################################################################################################################# Init
    @Override
    public void init() {
        this.body = new Rectangle(x, y, width, height);
        this.status = NONE_s;
        try {
            this.initAnimations();
        } catch (SlickException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initAnimations() throws SlickException {
        Image[] idleA = {
            new Image("assets/game/playerAnimations/idle/img1.png"),
            new Image("assets/game/playerAnimations/idle/img2.png"),
            new Image("assets/game/playerAnimations/idle/img3.png"),
            new Image("assets/game/playerAnimations/idle/img4.png"),
            new Image("assets/game/playerAnimations/idle/img5.png"),
            new Image("assets/game/playerAnimations/idle/img6.png"),
            new Image("assets/game/playerAnimations/idle/img7.png"),
            new Image("assets/game/playerAnimations/idle/img8.png"),
            new Image("assets/game/playerAnimations/idle/img9.png"),
            new Image("assets/game/playerAnimations/idle/img10.png"),
            new Image("assets/game/playerAnimations/idle/img11.png"),
            new Image("assets/game/playerAnimations/idle/img12.png"),
            new Image("assets/game/playerAnimations/idle/img13.png"),
            new Image("assets/game/playerAnimations/idle/img14.png"),
            new Image("assets/game/playerAnimations/idle/img15.png"),
            new Image("assets/game/playerAnimations/idle/img16.png"),
            new Image("assets/game/playerAnimations/idle/img17.png"),
            new Image("assets/game/playerAnimations/idle/img18.png")
        
        };

        Image[] moveRight = {new Image("assets/game/playerAnimations/move/right/img1.png"),
            new Image("assets/game/playerAnimations/move/right/img2.png"),
            new Image("assets/game/playerAnimations/move/right/img3.png"),
            new Image("assets/game/playerAnimations/move/right/img4.png")
        };

        Image[] moveLeft = {new Image("assets/game/playerAnimations/move/left/img1.png"),
            new Image("assets/game/playerAnimations/move/left/img2.png"),
            new Image("assets/game/playerAnimations/move/left/img3.png"),
            new Image("assets/game/playerAnimations/move/left/img4.png")
        };


        Image[] jumpRight = {new Image("assets/game/playerAnimations/jump/jumpRight.png")};

        Image[] jumpLeft = {new Image("assets/game/playerAnimations/jump/jumpLeft.png")};

        Image[] climb = {new Image("assets/game/playerAnimations/climb/img1.png"),
                        new Image("assets/game/playerAnimations/climb/img2.png")
        };
        
        Image[] fallA = {new Image("assets/game/playerAnimations/falling/img1.png"),
                        new Image("assets/game/playerAnimations/falling/img2.png")
        };
        
        Image[] amorteceRight = {new Image("assets/game/playerAnimations/amortece_right/img1.png"),
                            new Image("assets/game/playerAnimations/amortece_right/img2.png")
        };
        
        Image[] amorteceLeft = {new Image("assets/game/playerAnimations/amortece_left/img1.png"),
                            new Image("assets/game/playerAnimations/amortece_left/img2.png")
        };
        
        Image[] winningA1 = {new Image("assets/game/playerAnimations/winning/1/img1.png"),
                            new Image("assets/game/playerAnimations/winning/1/img2.png"),
                            new Image("assets/game/playerAnimations/winning/1/img3.png"),
                            new Image("assets/game/playerAnimations/winning/1/img4.png"),
                            new Image("assets/game/playerAnimations/winning/1/img5.png"),
                            new Image("assets/game/playerAnimations/winning/1/img6.png"),
                            new Image("assets/game/playerAnimations/winning/1/img7.png"),
                            new Image("assets/game/playerAnimations/winning/1/img8.png"),
                            new Image("assets/game/playerAnimations/winning/1/img9.png"),
                            new Image("assets/game/playerAnimations/winning/1/img10.png"),
                            new Image("assets/game/playerAnimations/winning/1/img11.png"),
                            new Image("assets/game/playerAnimations/winning/1/img12.png"),
                            new Image("assets/game/playerAnimations/winning/1/img13.png")
        };

        idle = new Animation(idleA, new int[]{200,200,200,200,600,200,200,200,200,600,200,200,200,600,200,200,600,200}, false);
        movingRight = new Animation(moveRight, new int[]{150, 150, 150, 150}, false);
        movingLeft = new Animation(moveLeft, new int[]{150, 150, 150, 150}, false);
        jumpingLeft = new Animation(jumpLeft, new int[]{200}, false);
        jumpingRight = new Animation(jumpRight, new int[]{200}, false);
        climbing = new Animation(climb, new int[]{250, 250}, false);
        
        amortecendoRight = new Animation(amorteceRight, new int[]{200, 200}, false);
        amortecendoRight.setLooping(false);
        
        amortecendoLeft = new Animation(amorteceLeft, new int[]{200, 200}, false);
        amortecendoLeft.setLooping(false);
        
        winning1 = new Animation(winningA1, new int[]{200, 200, 200,200,200,200,200,200,200,200,200,200,200}, false);
        winning1.setLooping(false);
        
        falling = new Animation(fallA, new int[]{200, 200}, false);
        falling.setLooping(false);
        
        //*****
        current = idle;

    }

    //################################################################################################################################# Update
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        if(physAndLogic)
            physAndLogicUpdate();
        
        if (status == NONE_s) {
            
            current = idle;
        }
        
        else if(status == CLIMB_s){
            
            if (substatus == CLIMB_UP_ss) {
                this.y -= speed;
                this.body.setY(y);
                current = climbing;
                
            } else if (substatus == CLIMB_DOWN_ss) {
                this.y += speed;
                this.body.setY(y);
                current = climbing;
            }
        }

        else if (status == MOVE_RIGHT_s) {
            if(this.x < this.move_x_destiny){
                this.x += speed;
                this.body.setX(x);
            } else {
                isFreezed = false;
                status = NONE_s;
            }

   
                current = movingRight;
            
        } 
        else if (status == MOVE_LEFT_s) {
            if(this.x > this.move_x_destiny){
                this.x -= speed;
                this.body.setX(x);
            } else {
                isFreezed = false;
                status = NONE_s;
            }
          
                current = movingLeft;

        }
        else if(status == JUMP_RIGHT_s){
            if(this.x < this.jump_x_destiny){
                this.x += speed;
                this.body.setX(x);
            } else {
                //isFreezed = false;
                //status = NONE_s;
            }
            current = jumpingRight;
        }
        else if(status == JUMP_s){
            if(InfoCenter.sentido == 1)
                current = jumpingRight;
            else
                current = jumpingLeft;

        }
        else if(status == JUMP_LEFT_s){
            if(this.x > this.jump_x_destiny){
                this.x -= speed;
                this.body.setX(x);
            } else {
                //isFreezed = false;
                //status = NONE_s;
            }
            current = jumpingLeft;
        }
        else if(status == WINNING_s){
            current = winning1;
            
        } 
        else if(status == AMORTECENDO_RIGHT_s){
            current = amortecendoRight;
            
            if(current.isStopped()){
                status = NONE_s;
                isFreezed = false;
            }
        }
        else if(status == AMORTECENDO_LEFT_s){
            current = amortecendoLeft;
            
            if(current.isStopped()){
                status = NONE_s;
                isFreezed = false;
            }
        }
        else if(status == FALLING_s){
            current = falling;
        }
        
      

        
        current.update(delta);
    }
    
    private void physAndLogicUpdate(){
        //******************************************************** Update Status
        if(bottomCollider.type == GameObject.TYPE_SOLID){
            if(status == CLIMB_s){
                isFreezed = false;
                status = NONE_s;
            } else if (status == JUMP_LEFT_s){
                status = AMORTECENDO_LEFT_s;
                amortecendoLeft.restart(); // dar restart na animação que pode estar parada
            } else if (status == JUMP_RIGHT_s){
                status = AMORTECENDO_RIGHT_s;
                amortecendoRight.restart(); // dar restart na animação que pode estar parada
            } else if (status == JUMP_s){
                if(InfoCenter.sentido == 1){ // direita
                    status = AMORTECENDO_RIGHT_s;
                    amortecendoRight.restart(); // dar restart na animação que pode estar parada
                } else { // esquerda
                    status = AMORTECENDO_LEFT_s;
                    amortecendoLeft.restart(); // dar restart na animação que pode estar parada
                }
            }
            
            
            //status = NONE_s;
        }
        
        //**********************************************************************
        
        if (rightCollider.type == GameObject.TYPE_SOLID && status != CLIMB_s) {
            if(status != MOVE_LEFT_s)
                status = NONE_s;
            
            isFreezed = false;

        }

        if (leftCollider.type == GameObject.TYPE_SOLID && status != CLIMB_s) {
            if(status != MOVE_RIGHT_s)
                status = NONE_s;
            
            isFreezed = false;
        }

        if (bottomCollider.type == GameObject.TYPE_SOLID && status != CLIMB_s) {
            jumpForce = 0;
            //JUMP_RIGHT = false;
            //JUMP_LEFT = false;
            y = ((int) y / 50) * 50; // corrigindo problema de inprecisão da colisão de queda(ela é variante por causa da gravidade)
            body.setY(y);            // este cálculo força para que quando errada, ela se ajeite.
            
        }

        if (topCollider.type == GameObject.TYPE_SOLID && status != CLIMB_s) {
            jumpForce = 1;
            //JUMP_RIGHT = false;
            //JUMP_LEFT = false;

        }

        if(
            bottomCollider.type == GameObject.TYPE_NULL &&
            status == NONE_s
                
        ){
            //falling.restart();
            status = FALLING_s;
        }
        

        // aplicar jump force, fazer gravidade agir
        this.y += jumpForce;
        this.body.setY(y);
        if (jumpForce <= 5.8f) {
            jumpForce += gravity;
        }

        if ((centerCollider.name == GameObject.NAME_STAIRS || centerCollider.name == GameObject.NAME_STAIRS_AND_GROUND) 
                && status == CLIMB_s) {
            
            jumpForce = 0;
        }




        //**********************************************************************
    }

    @Override
    public void onTouch(GameObject other) {
    }

    @Override
    public void onActivate(GameObject activator) {
    }

    //################################################################################################################################# Render
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        g.setColor(Color.red);
        current.draw(body.getCenterX() - (current.getWidth() / 2), body.getY() + body.getHeight() - current.getHeight());
        //g.draw(body);
    }

    //################################################################################################################################# Actions

    public void moveRight() {
        if(status != CLIMB_s){
            if(bottomCollider.type == TYPE_SOLID){
                status = MOVE_RIGHT_s;
                isFreezed = true;

                move_x_destiny = ((getX_Axis(this) + 1) * 50) + 15;
            }
        }
    }

    public void moveLeft() {
        if(status != CLIMB_s){
            if(bottomCollider.type == TYPE_SOLID){
                
                status = MOVE_LEFT_s;
                isFreezed = true;

                move_x_destiny = ((getX_Axis(this) - 1) * 50) + 15;
            }
        }
    }

    //Pulo reto
    public void jump() {
        if(bottomCollider.type == TYPE_SOLID){
            status = JUMP_s;
            jumpForce = - 6;
            this.y += -5;
            this.body.setY(y);
            isFreezed = true;
        }
                
    }
    
    public void jumpRight() {
        if(bottomCollider.type == TYPE_SOLID){
            status = JUMP_RIGHT_s;
            jumpForce = - 6;
            this.y += -5;
            this.body.setY(y);
            isFreezed = true;
            jump_x_destiny = ((getX_Axis(this) + 2) * 50) + 15;
        }
                
    }
    
    public void jumpLeft() {
        if(bottomCollider.type == TYPE_SOLID){
            status = JUMP_LEFT_s;
            jumpForce = - 6;
            this.y += -5;
            this.body.setY(y);
            isFreezed = true;
            jump_x_destiny = ((getX_Axis(this) - 2) * 50) + 15;
        }
                
    }

    public void climbUp() {
        if(centerCollider.name == GameObject.NAME_STAIRS ){
            isFreezed = true;
            //código para centralizar o player na escada primeiro antes de começar a subir
            int xAxis = (int) (this.x / 50);
            this.x = (xAxis * 50) + 15;
            this.body.setX(x);
            
            status = CLIMB_s;
            substatus = CLIMB_UP_ss;
            this.y += -1;
            this.body.setY(y);
        } else {
            status = NONE_s;
        }
    }
    
    public void climbDown() {
        if(bottomCollider.name == GameObject.NAME_STAIRS_AND_GROUND){
            isFreezed = true;
            
            //código para centralizar o player na escada primeiro antes de começar a descer
            int xAxis = (int) (bottomCollider.x / 50);
            this.x = (xAxis * 50) + 15;
            this.body.setX(x);
            
            status = CLIMB_s;
            substatus = CLIMB_DOWN_ss;
            this.y += 10;
            this.body.setY(y);
        } 
        else {
            status = NONE_s;
        }
    }
    //################################################################################################################################# Others
    public int getX_Axis(GameObject obj){
        return (int) (obj.x / 50);
    }
}
