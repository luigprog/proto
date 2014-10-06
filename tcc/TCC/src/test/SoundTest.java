package test;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SoundTest {
    
    public static void main(String[] args) throws SlickException {
     
        Sound sound = new Sound("assets/game/audio/walk1.wav");
        sound.play();
    } 
}
