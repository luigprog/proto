package game;

import game.gameObjects.Player;
import game.gameObjects.GameObject;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class CollisionManager {

    private Player player;
    private TiledMap world;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private ArrayList<GameObject> items = new ArrayList<GameObject>();
    private GameObject nullCollider = new GameObject(GameObject.TYPE_NULL, GameObject.NAME_NULL, -1, -1, null);

    public CollisionManager(Player player, TiledMap world, ArrayList<GameObject> items) {
        this.player = player;
        this.world = world;
        this.items = items;
        
        init();
    }
    
    private void init(){
        int tileId;
        
        for (int i = -2; i < world.getHeight(); i++) {
            objects.add(new GameObject(GameObject.TYPE_SOLID, GameObject.NAME_GROUND,
                                -1 * 50, i * 50, new Rectangle(-1 * 50, i * 50, 50, 50)));
            
        }
        for (int i = -2; i < world.getHeight(); i++) {
            objects.add(new GameObject(GameObject.TYPE_SOLID, GameObject.NAME_GROUND,
                                20 * 50, i * 50, new Rectangle(20 * 50, i * 50, 50, 50)));
            
        }
        
        
        for (int i = 0; i < world.getWidth(); i++) {
            for (int j = 0; j < world.getHeight(); j++) {
                tileId = world.getTileId(i, j, world.getLayerIndex("main"));
                
                if(world.getTileProperty(tileId, "type", "null").equalsIgnoreCase("solid") &&
                   world.getTileProperty(tileId, "name", "null").equalsIgnoreCase("ground")     ){
                    
                    objects.add(new GameObject(GameObject.TYPE_SOLID, GameObject.NAME_GROUND,
                                i * 50, j * 50, new Rectangle(i * 50, j * 50, 50, 50)));
                    
                }
                
                if(world.getTileProperty(tileId, "type", "null").equalsIgnoreCase("nonsolid") &&
                   world.getTileProperty(tileId, "name", "null").equalsIgnoreCase("stairs")     ){
                    
                    objects.add(new GameObject(GameObject.TYPE_NONSOLID, GameObject.NAME_STAIRS,
                                i * 50, j * 50, new Rectangle(i * 50, j * 50, 50, 50)));
                    
                }
                
                if(world.getTileProperty(tileId, "type", "null").equalsIgnoreCase("solid") &&
                   world.getTileProperty(tileId, "name", "null").equalsIgnoreCase("stairsGround")     ){
                    objects.add(new GameObject(GameObject.TYPE_SOLID, GameObject.NAME_STAIRS_AND_GROUND,
                                i * 50, j * 50, new Rectangle(i * 50, j * 50, 50, 50)));
                    
                }
                
            }
            
        }
    }
    
    public void update(){
        player.rightCollider = nullCollider;
        player.leftCollider = nullCollider;
        player.bottomCollider = nullCollider;
        player.topCollider = nullCollider;
        player.centerCollider = nullCollider;
        
        for (GameObject obj : items) { // items
            if(player.body.intersects(obj.body)){
                /*if(obj.type == GameObject.TYPE_ITEM && obj.name == GameObject.NAME_STAR){
                   obj.onActivate(player);
                }
                if(obj.type == GameObject.TYPE_ITEM && obj.name == GameObject.NAME_OBJECTIVE){
                   obj.onActivate(player);
                }*/
                obj.onActivate(player);
                
            }
            
        }
        
        for (GameObject obj : objects) {
            
            if(player.body.intersects(obj.body)){
                
                if(player.y + player.height - 6 <= obj.y){
                    if(player.x > obj.x && player.x + player.width < obj.x + 50){
                       player.bottomCollider = obj; 
                    } else if (player.x < obj.x + 49 && player.x > obj.x){
                        player.bottomCollider = obj;
                    } else if (player.x + player.width > obj.x + 1 && player.x + player.width < obj.x + 50){
                        player.bottomCollider = obj;
                    }
                }
                
                if(player.y + 6 >= obj.y + 50 -6) {
                    if(player.x > obj.x && player.x + player.width < obj.x + 50){
                       player.topCollider = obj; 
                    } else if (player.x < obj.x + 49 && player.x > obj.x){
                        player.topCollider = obj;
                    } else if (player.x + player.width > obj.x + 1 && player.x + player.width < obj.x + 50){
                        player.topCollider = obj;
                    }
                   
                }
                
                if(player.x < obj.x && obj.y < player.y + player.height - 6){
                    player.rightCollider = obj;
                }
                
                if(player.x > obj.x && obj.y < player.y + player.height - 6){
                    player.leftCollider = obj;
                }
            }
            
            if(player.x > obj.x && player.x + player.width < obj.x + 50 &&
                    player.y + 50 <= obj.y && player.y + 100 >= obj.y){
                if(obj.type != GameObject.TYPE_SOLID)
                    player.centerCollider = obj;
                if(obj.name == GameObject.NAME_STAIRS_AND_GROUND)
                    player.centerCollider = obj;
            }
            
        }
                
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        /*g.setColor(Color.white);
        for (GameObject item : objects) {
            item.render(gc, sbg, g);
        }*/
    }
    
    
    
}
