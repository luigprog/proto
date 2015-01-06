package game.gameObjects;

import gamer.Sphere2;
import gamer.Sphere3;
import gamer.CurrentSphere;
import gamer.Goal;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Star extends GameObject {

    private Animation animation;
    public int width = 50;
    public int height = 50;
    private boolean activated = false;

    public Star(float x, float y) {
        super(GameObject.TYPE_ITEM, GameObject.NAME_STAR);

        this.x = x;
        this.y = y;
        
        this.init();
    }

    //################################################################################################################################# Init
    @Override
    public void init() {
        this.body = new Rectangle(x, y, width, height);
        
        try {
            this.initAnimations();
        } catch (SlickException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initAnimations() throws SlickException {
        Image[] arrayAnimation = {
            new Image("assets/game/items/esfera/img1.png"),
            new Image("assets/game/items/esfera/img2.png"),
            new Image("assets/game/items/esfera/img3.png")
        };

        animation = new Animation(arrayAnimation, new int[]{200, 200, 200}, false);
        

    }

    //################################################################################################################################# Update
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        if(!activated)
            animation.update(delta);
    }

    @Override
    public void onTouch(GameObject other) {
    }

    @Override
    public void onActivate(GameObject activator) {
        if(!activated){
            if(activator.name == GameObject.NAME_PLAYER){
                this.activated = true;
                Player aux = (Player)activator;
                aux.starsQuant++;
                // mudar parte gamer--------------------------------------------
                if(aux.starsQuant == 1){
                    CurrentSphere.x = Sphere2.x;
                    CurrentSphere.y = Sphere2.y;
                } else if (aux.starsQuant == 2){
                    CurrentSphere.x = Sphere3.x;
                    CurrentSphere.y = Sphere3.y;
                } else if (aux.starsQuant == 3){
                    // caso o player tenha as 3 esferas, entao agora a esfera atual aponta para o Objetivo
                    CurrentSphere.x = Goal.x;
                    CurrentSphere.y = Goal.y;
                }
                //--------------------------------------------------------------
            } 
        }
    }

    //################################################################################################################################# Render
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        if(!activated)
            animation.draw(body.getCenterX() - (animation.getWidth() / 2), body.getY() + body.getHeight() - animation.getHeight());
    }

    //--------------------------------------------------------------------------
}
