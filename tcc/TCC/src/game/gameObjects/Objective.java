package game.gameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Objective extends GameObject {

    private Animation animation;
    public int width = 15;
    public int height = 50;
    public boolean activated = false;

    public Objective(float x, float y) {
        super(GameObject.TYPE_ITEM, GameObject.NAME_OBJECTIVE);

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
            new Image("assets/game/items/objective/1.png"),
            new Image("assets/game/items/objective/2.png"),
            new Image("assets/game/items/objective/3.png"),
            new Image("assets/game/items/objective/4.png"),
            new Image("assets/game/items/objective/5.png"),
            new Image("assets/game/items/objective/6.png"),
            new Image("assets/game/items/objective/7.png"),  
            new Image("assets/game/items/objective/8.png")  
        };

        animation = new Animation(arrayAnimation, new int[]{100, 100, 100, 100, 100, 100, 100, 100}, false);
        

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
    }

    //################################################################################################################################# Render
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        if(!activated)
            animation.draw(body.getX(), body.getY() + body.getHeight() - animation.getHeight());
    }

    //--------------------------------------------------------------------------
}
