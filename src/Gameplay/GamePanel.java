package Gameplay;

import Entity.Player;
import Main.GameFrame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    private Thread gameThread;
    private KeyInput keyInput = new KeyInput();
    private final int FPS = 60;
    private Player player = new Player(this, keyInput);
    private GameFrame gameFrame;


    public GamePanel(GameFrame gameFrame) throws Exception{
        this.gameFrame = gameFrame;

        this.setLayout(null);
        this.setBounds(0,0,1600,900);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyInput);
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setVisible(false);
        //
        this.startGameThread();
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (this.gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                this.update();
                this.repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                //System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update() {
        this.player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);

        g2.dispose();
    }
}
