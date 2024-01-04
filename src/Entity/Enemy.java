package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy {
    private static EnemyAction action;
    private int x, y;
    private BufferedImage shownImage;
    private boolean dead;
    public Enemy() throws IOException {
        this.x = 1200;
        this.y = 530;
        action = EnemyAction.IDLE;
        this.dead = false;
    }

    public void update() {
        this.shownImage = action.animate();
        if (!dead && Arrow.isShot() && Arrow.getX() > this.x) {
            action = EnemyAction.DEAD;
            this.dead = true;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(this.shownImage, this.x, this.y, this.shownImage.getWidth()*3, this.shownImage.getHeight()*3, null);
    }
}
