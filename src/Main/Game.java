package Main;

import Sounds.Sounds;
public class Game {
    
    public static void main(String[] args) throws Exception {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        new Sounds();
        Sounds.playMusic();
    }
}
