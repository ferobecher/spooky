package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    private static Action action;
    private static int x, y;
    private BufferedImage shownImage;
    public Enemy() {
        x = 1200;
        y = 530;
        action = Action.ENEMY_IDLE;
    }

    public void update() {
        this.shownImage = action.animate();
        if (action != Action.ENEMY_DEAD && Arrow.isShot() && Arrow.getX() > x) {
            action = Action.ENEMY_DEAD;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(this.shownImage, x, y, this.shownImage.getWidth()*3, this.shownImage.getHeight()*3, null);
    }
    public static void changeX(int addition) {
        x += addition;
    }
    public static void changeY(int addition) {
        y += addition;
    }
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public static void die() {
        action = Action.ENEMY_DEAD;
    }
}
