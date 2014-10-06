package game.gameObjects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class GameObject {
    
    public static final int TYPE_NULL = -1; 
            public static final int NAME_NULL = 100; 
    //~~~~~~~~~~~~~~~~~~~~~~       
    public static final int TYPE_ACTOR = 0; 
            public static final int NAME_PLAYER = 108; 
    //~~~~~~~~~~~~~~~~~~~~~~        
    public static final int TYPE_ITEM = 1; 
            public static final int NAME_START = 102; 
            public static final int NAME_STAR = 105; 
            public static final int NAME_OBJECTIVE = 107; 
    //~~~~~~~~~~~~~~~~~~~~~~               
    public static final int TYPE_SOLID = 2; 
            public static final int NAME_GROUND = 101;
            public static final int NAME_STAIRS_AND_GROUND = 104; 
    //~~~~~~~~~~~~~~~~~~~~~~
    public static final int TYPE_NONSOLID = 3; 
            public static final int NAME_STAIRS = 103; 
    //~~~~~~~~~~~~~~~~~~~~~~
    public static final int TYPE_MOVABLE = 4; 

    
    public int type;
    public int name;
    public float x;
    public float y;
    public Shape body; 
    public GameObject leftCollider = null;
    public GameObject rightCollider = null;
    public GameObject topCollider = null;
    public GameObject bottomCollider = null;
    public GameObject centerCollider = null;
    
    public GameObject(int type, int name){
        this.type = type;
        this.name = name;
    }

    public GameObject(int type, int name,float x, float y, Shape body) {
        this.type = type;
        this.name = name;
        this.x = x;
        this.y = y;
        this.body = body;
    }
    
    
    
    public void init(){
        
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
        g.draw(body);
    }
    
    public void onTouch(GameObject other){
        
    }
    
    public void onActivate(GameObject activator){
        
    }
    
    public void cleanColliders(){
        leftCollider = null;
        rightCollider = null;
        topCollider = null;
        bottomCollider = null;
        centerCollider = null;
    }
    
}
