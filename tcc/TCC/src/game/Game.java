package game;

import app.VariavelTableNode;
import bsh.EvalError;
import bsh.Interpreter;
import data.storage.PlayerStats;
import data.storage.level.FasesDados;
import game.CollisionManager;
import game.Main;
import game.gameObjects.GameObject;
import game.gameObjects.Objective;
import game.gameObjects.Player;
import game.gameObjects.Star;
import gamer.Sphere1;
import gamer.Sphere2;
import gamer.Sphere3;
import gamer.InfoCenter;
import gamer.Proto;
import gamer.Goal;
import gamer.CurrentSphere;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import util.Universal;

public class Game extends BasicGameState {

    private Player player;
    private ArrayList<GameObject> items = new ArrayList<GameObject>();
    private TiledMap world;
    private CollisionManager cm;
    //-------------------------------------------------------------------- HUD
    public boolean hudIsVisible = true;
    
    private Image esferas_0, esferas_1, esferas_2, esferas_3;
    private Vector2f coord_esferasIndicator = new Vector2f(10, Universal.gameScreen_height - 40);
    
    private Image stopButton;
    private Vector2f coord_stopButton = new Vector2f(Universal.gameScreen_width - 40, Universal.gameScreen_height - 40);
    //-------------------------------------------------------------------- Flags
    public boolean initialized = false;
    public boolean flagExit = false;
    private boolean gameUpdateEnabled = true;
    private boolean gameOverPopupOpened = false;
    private boolean gameWonPopupOpened = false;
    private boolean premioPopupOpened = false;
    
    private boolean timer_winning_started = false;
    //-------------------------------------------------------------------- Gamer
    Interpreter bsh = new Interpreter();
    //------------------------------------------------------------------- Popups
    private Image gameOver_popup;
    
    private Image gameWon_popup;
    private Image premio_popup;
    //-------------------------------------------------------------------- Fonts
    private TrueTypeFont font1; 
    private TrueTypeFont font2; 
   //------------------------------------------------------------ Counter Timer
    private int counter_Celebration = 0;
    //----------------------------------------------------------- Axis References
    private int objectiveX;
    private int objectiveY;
    
    public Game(int state) {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        if(!initialized){
            world = new TiledMap("assets/game/fases/fase" + Universal.currentFaseId + "/world.tmx");

            int tileId;

            int xAxisStart = -1;
            int yAxisStart = -1;
            for (int i = 0; i < world.getWidth(); i++) {
                for (int j = 0; j < world.getHeight(); j++) {
                    tileId = world.getTileId(i, j, world.getLayerIndex("invisible"));

                    //items
                    if (world.getTileProperty(tileId, "name", "null").equalsIgnoreCase("star")
                            && world.getTileProperty(tileId, "type", "null").equalsIgnoreCase("item")) {

                        items.add(new Star(i * 50, j * 50));
                        
                        if(world.getTileProperty(tileId, "index", "null").equalsIgnoreCase("1")){
                            Sphere1.x = i+1;
                            Sphere1.y = j+1;
                        } else if(world.getTileProperty(tileId, "index", "null").equalsIgnoreCase("2")){
                            Sphere2.x = i+1;
                            Sphere2.y = j+1;
                        } else if(world.getTileProperty(tileId, "index", "null").equalsIgnoreCase("3")){
                            Sphere3.x = i+1;
                            Sphere3.y = j+1;
                        }

                        //----- Inicializar proxima esfera para gamer
                        CurrentSphere.x = Sphere1.x;
                        CurrentSphere.y = Sphere1.y;
                        
                    }
                    if (world.getTileProperty(tileId, "name", "null").equalsIgnoreCase("objective")
                            && world.getTileProperty(tileId, "type", "null").equalsIgnoreCase("item")) {

                        items.add(new Objective(i * 50, j * 50));
                        Goal.x = i + 1;
                        Goal.y = j + 1;
                        
                        objectiveX = i + 1;
                        objectiveY = j + 1;
                        
                    }

                    //---//---


                    if (world.getTileProperty(tileId, "name", "null").equalsIgnoreCase("start")) {
                        xAxisStart = i;
                        yAxisStart = j - 1;
                    }
                }

            }
            if (xAxisStart == -1) {
                System.out.println("Posição inicial do player não foi encontrada no tiledMap!");
            }

            player = new Player(xAxisStart * 50, yAxisStart * 50);

            cm = new CollisionManager(player, world, items);

            initCamadaGamer();
            initPopups(gc);
            initFonts();
            initHUD();
            
            initialized = true;
        }
        
        
    }

    public void initFonts(){
        font1 = new TrueTypeFont(new java.awt.Font(java.awt.Font.SERIF,java.awt.Font.BOLD , 16), false);
        font2 = new TrueTypeFont(new java.awt.Font(java.awt.Font.SERIF,java.awt.Font.BOLD , 28), false);
    }
    
    public void initHUD() throws SlickException {
        esferas_0 = new Image("assets/game/hud/0esferas.png");
        esferas_1 = new Image("assets/game/hud/1esferas.png");
        esferas_2 = new Image("assets/game/hud/2esferas.png");
        esferas_3 = new Image("assets/game/hud/3esferas.png");
        
        stopButton = new Image("assets/game/hud/stopButton.png");
    }
    
    public void initPopups(GameContainer gc) throws SlickException{
        gameOver_popup = new Image("assets/game/popups/game_over.png");
        gameWon_popup = new Image("assets/game/popups/game_won.png");
        
        if(FasesDados.fase[Universal.currentFaseId].hasPremio){ // se fase tem premio
            premio_popup = new Image("assets/game/fases/fase" + Universal.currentFaseId + "/premio.png"); // carregando imagem de premio da fase
        }

    }
    

    public void inputManager(Input input) {
        if (!player.isFreezed) {
            if(Universal.egg_keyboardControl){
                if (input.isKeyDown(Input.KEY_UP)) {
                    player.climbUp();
                } else if (input.isKeyDown(Input.KEY_DOWN)) {
                    player.climbDown();
                } else if (input.isKeyDown(Input.KEY_LEFT)) {
                    player.moveLeft();

                } else if (input.isKeyDown(Input.KEY_RIGHT)) {
                    player.moveRight();
                } else {
                    player.status = Player.NONE_s;
                }

                if (input.isKeyDown(Input.KEY_A)) {
                    player.jumpLeft();
                    //player.jump();
                }
                if (input.isKeyDown(Input.KEY_S)) {
                    player.jumpRight();
                }
                
            }

            if (input.isKeyDown(Input.KEY_ESCAPE)) {
                flagExit = true;
            }

        }
    }

    public void initCamadaGamer() {
        InfoCenter.carregaMapa();
        InfoCenter.zeraRobotActions();
        Proto.setDirectionToRight();
        
        try { // realizar importações do shell eval
            bsh.eval("import gamer.Proto;");
            bsh.eval("import gamer.Goal;");
            bsh.eval("import gamer.Sphere1;");
            bsh.eval("import gamer.Sphere2;");
            bsh.eval("import gamer.Sphere3;");
            bsh.eval("import gamer.CurrentSphere;");
            bsh.set("none", InfoCenter.map_nada);
            bsh.set("solid", InfoCenter.map_solido);
            bsh.set("stairs", InfoCenter.map_escada);
            bsh.set("goal", InfoCenter.map_objetivo);
            bsh.set("sphere", InfoCenter.map_esfera);
            bsh.set("solid_stairs", InfoCenter.map_solidoEscada);
            
            VariavelTableNode aux;
            for (int i = 0; i < Universal.currentVariables.size(); i++) {
                aux = Universal.currentVariables.get(i);
                
                if(aux.tipo.equals("int")){
                    bsh.set(aux.nome, Integer.parseInt(aux.valor));
                } else if(aux.tipo.equals("boolean")){
                    if(aux.valor.equals("true")){
                        bsh.set(aux.nome, true);
                    } else {
                        bsh.set(aux.nome, false);
                    }
                } else if(aux.tipo.equals("String")){
                    bsh.set(aux.nome, aux.valor);
                }
            }
            
        } catch (EvalError ex) {
            JOptionPane.showMessageDialog(null, "Erro ao importar classes no eval.", "Erro", JOptionPane.ERROR_MESSAGE);
            flagExit = true;
        }
    }
    
    public void codeProcess() {
        if (!player.isFreezed) {
            // atualizar x e y da classe Robo para o user usar
            Proto.x = (int) (player.x / 50) + 1;
            Proto.y = (int) (player.y / 50) + 2;
            
            //System.out.println("Coordenadas do Robo: [" + Robo.x + ", " + Robo.y + "]");
            
            //zera actions
            InfoCenter.zeraRobotActions();
            
            try {
                
                bsh.eval(Universal.currentCode);
                                
            } catch (EvalError ex) {
                //Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                //JOptionPane.showMessageDialog(null, "Seu código contém algum erro.", "Erro", JOptionPane.ERROR_MESSAGE);
                flagExit = true;
            }
            
            if(InfoCenter.moverDireita){
                player.moveRight();
            } else if (InfoCenter.moverEsqueda){
                player.moveLeft();
            } else if (InfoCenter.pularDireita){
                player.jumpRight();
            } else if (InfoCenter.pularEsquerda){
                player.jumpLeft();
            } else if (InfoCenter.pular){
                player.jump();
            } else if (InfoCenter.subir){
                player.climbUp();
            } else if (InfoCenter.descer){
                player.climbDown();
            }
            
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if (flagExit) {
            System.gc();
            gc.exit();
        }
        
        if(gameUpdateEnabled){
            /*
             * O teste a baixo é para saber se o player chegou no objetivo.
             * Para sim, ativar o estado winning;
             */
            if(!player.isFreezed){ 
                if(getPlayerX_Axis() == objectiveX && getPlayerY_Axis() == objectiveY && player.status != Player.WINNING_s){
                    player.status = Player.WINNING_s;
                    player.physAndLogic = false;
                    player.isFreezed = true;
                    /*for (GameObject item : items) { // descobre onde está o objetive, e ativa ele, para não aparecer mais na tela.
                         if(item.name == GameObject.NAME_OBJECTIVE){
                             item.onActivate(null);
                         }
                    }*/
                }
            }
            
            cm.update();
            inputManager(gc.getInput());
            if (Universal.egg_keyboardControl) {

            } else {
                codeProcess();
            }

            cm.update();

            
            player.update(gc, sbg, delta);

            for (GameObject item : items) {
                item.update(gc, sbg, delta);
            }
            
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Update Game Controller
            
                        
            if(player.y > 800){ // morte
                gameUpdateEnabled = false;
                gameWonPopupOpened = false;
                gameOverPopupOpened = true;
                premioPopupOpened = false;

            }
            if(player.status == Player.WINNING_s){ // comemoração
                counter_Celebration++;
                if(counter_Celebration > 200){
                    gameUpdateEnabled = false;
                    gameOverPopupOpened = false;
                    gameWonPopupOpened = true;
                    premioPopupOpened = false;
                }
                
            }
            
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        } else if(gameOverPopupOpened){
            if(gc.getInput().isMousePressed(0)){
                if(gc.getInput().getMouseX() > 575 &&
                   gc.getInput().getMouseX() < 750 &&
                   gc.getInput().getMouseY() > 330 &&
                   gc.getInput().getMouseY() < 375 )
                {
                    
                    flagExit = true;
                    
                }
            }
            
        
        } else if(gameWonPopupOpened){
            if(gc.getInput().isMousePressed(0)){
                if(gc.getInput().getMouseX() > 575 &&
                   gc.getInput().getMouseX() < 750 &&
                   gc.getInput().getMouseY() > 330 &&
                   gc.getInput().getMouseY() < 375 )
                {
                    
                    int pontuacao = (40 + (player.starsQuant * 20)) - (Universal.currentVariables.size() * 2);
                    
                    if(pontuacao > Integer.parseInt(PlayerStats.getInstance().getProperty("fase" + Universal.currentFaseId))){
                        PlayerStats.getInstance().setFasePoints(Universal.currentFaseId, pontuacao + "");
                    }
                    if(PlayerStats.getInstance().getProperty("fase" + Universal.currentFaseId + 1) == null){
                        PlayerStats.getInstance().setFasePoints(Universal.currentFaseId + 1, "0");
                    }
                    
                    if(FasesDados.fase[Universal.currentFaseId].hasPremio){ // se fase tem premio abre a tela de premio
                        gameUpdateEnabled = false;
                        gameOverPopupOpened = false;
                        gameWonPopupOpened = false;
                        premioPopupOpened = true;
                        
                    } else { // se não ja finaliza o jogo e fecha a tela de execução do robo
                        // fim do jogo ao vencer a fase
                        flagExit = true;
                    }
                }
            }
        } else if (premioPopupOpened){ // tela de premio
            if(gc.getInput().isMousePressed(0)){
                if(gc.getInput().getMouseX() > 575 &&
                   gc.getInput().getMouseX() < 750 &&
                   gc.getInput().getMouseY() > 330 &&
                   gc.getInput().getMouseY() < 375 )
                { // testando o clique
                    
                    flagExit = true;
                    
                }
            }
        }
        
        if(hudIsVisible){
                if(gc.getInput().getMouseX() > coord_stopButton.x &&
                   gc.getInput().getMouseX() < coord_stopButton.x + stopButton.getWidth() &&
                   gc.getInput().getMouseY() > coord_stopButton.y &&
                   gc.getInput().getMouseY() < coord_stopButton.y + stopButton.getHeight() )
                {
                    if(gc.getInput().isMousePressed(0)){
                        // apertou o botao stop/abortar fase
                        flagExit = true;
                    }
                }
            
        }
        

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        world.render(0, 0);
        
        for (GameObject item : items) {
            item.render(gc, sbg, g);
        }
        
        player.render(gc, sbg, g);
        cm.render(gc, sbg, g);

        
        if(gameOverPopupOpened){
            gameOver_popup.draw(0, 0);
        } else if (gameWonPopupOpened){
            gameWon_popup.draw(0, 0);
            font1.drawString(500, 195, player.starsQuant + "");
            font1.drawString(500, 238, Universal.currentVariables.size() + "");
            font2.drawString(500, 270, (40 + (player.starsQuant * 20)) - (Universal.currentVariables.size() * 2) + "");
        } else if(premioPopupOpened){
            premio_popup.draw(0, 0);
        }
        
        // HUD
        if(hudIsVisible){
            switch (player.starsQuant) {
                case 0:
                    esferas_0.draw(coord_esferasIndicator.x, coord_esferasIndicator.y);
                    break;
                case 1:
                    esferas_1.draw(coord_esferasIndicator.x, coord_esferasIndicator.y);
                    break;
                case 2:
                    esferas_2.draw(coord_esferasIndicator.x, coord_esferasIndicator.y);
                    break;
                case 3:
                    esferas_3.draw(coord_esferasIndicator.x, coord_esferasIndicator.y);
                    break;    
                
            }
            
            stopButton.draw(coord_stopButton.x, coord_stopButton.y);
            
        }
        
    }

    //################################################################################################################################# Others
    public int getX_Axis(GameObject obj){
        return (int) (obj.x / 50);
    }
    
    public int getY_Axis(GameObject obj){
        return (int) (obj.x / 50);
    }
    
    public int getPlayerX_Axis(){
        return (int) (player.x / 50) + 1;
    }

    public int getPlayerY_Axis(){
        return (int) (player.y / 50) + 2;
    }
    
    @Override
    public int getID() {
        return 0;
    }
}
