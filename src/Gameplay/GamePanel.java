package Gameplay;

import Entity.Enemy;
import Entity.Player;
import Main.GameFrame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    private Thread gameThread;
    private final KeyInput keyInput = new KeyInput();
    private final int FPS = 60;
    private final Player player = new Player(keyInput);
    private final Enemy enemy = new Enemy();
    private final Background bg = new Background();


    public GamePanel() throws Exception{

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
        this.enemy.update();
        //background change
        if (Player.getX() > 1550) {
            Player.setX(0);
            Background.change();
            Player.setY(Background.getY());
        }
        if (Player.getX() < -200) {
            Player.setX(1400);
            Background.change();
            Player.setY(Background.getY());
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        this.bg.draw(g2);
        this.player.draw(g2);
        if (Background.hasEnemy()) {
            this.enemy.draw(g2);
        }
        g2.dispose();
    }
}
