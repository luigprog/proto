package game;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame {

    //------------------------------------------------------------------- Config
    public static final String gamename = "";
    public static int width = 1000;
    public static int height = 500;
    public static int fps = 60;
    //------------------------------------------------------------------- States
    public static final int game = 0;

    public Main(String gamename) {
        super(gamename);
        this.addState(new Game(game));        
        
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(game).init(gc, this);
        this.enterState(game);
    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Main(gamename));
            appgc.setDisplayMode(width, height, false);
            appgc.setTargetFrameRate(fps);
            appgc.setIcon("assets/game/icon.png");
            appgc.setShowFPS(false);
            appgc.setForceExit(false);
            appgc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public boolean closeRequested() {
//        super.closeRequested(); //To change body of generated methods, choose Tools | Templates.
//    
//        return false;
//    }
    
    
    
}
