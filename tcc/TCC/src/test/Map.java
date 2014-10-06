/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Gamer
 */
public class Map extends BasicGame {

    /**
     * @param args the command line arguments
     */

    public Map(){
        super("Map");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
       TiledMap map = new TiledMap("assets/game/level1.tmx");
        
        int tileId;
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                tileId = map.getTileId(i, j, map.getLayerIndex("world"));
                System.out.println("x: " + i);
                System.out.println("y: " + j);
                System.out.println("Tile id: " + tileId);
                System.out.println("Type: " + map.getTileProperty(tileId, "type", null));
                System.out.println("Status: " + map.getTileProperty(tileId, "status", null));
                System.out.println("-------------------------------------------------");
            }
            
        }
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
    }
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Map());
        app.setDisplayMode(200, 200, false);
        //app.setSmoothDeltas(true);
        app.setTargetFrameRate(60);
        app.setShowFPS(true);
        app.start();

    }
}
