package Entity;

import Gameplay.GamePanel;
import Gameplay.KeyInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity{
    BufferedImage left, right = null;
    GamePanel gamePanel;
    KeyInput keyInput;

    public Player(GamePanel gamePanel, KeyInput keyInput) throws IOException {
        this.gamePanel = gamePanel;
        this.keyInput = keyInput;
        this.setDefaultValues();
        this.getPlayerImage();
    }
    public void getPlayerImage() throws IOException {
        this.left = ImageIO.read(new File("res/pics/player/playerLeft.png"));
        this.right = ImageIO.read(new File("res/pics/player/playerRight.png"));
    }
    public void setDefaultValues() {
        this.x = 200;
        this.y = 325;
        this.speed = 4;
        direction = "right";
    }
    public void update() {
        if (this.keyInput.getUpPressed()) {
            this.y -= this.speed;
            direction = "up";
        }
        if (this.keyInput.getRightPressed()) {
            this.x += this.speed;
            direction = "right";
        }
        if (this.keyInput.getDownPressed()) {
            this.y += this.speed;
            direction = "down";
        }
        if (this.keyInput.getLeftPressed()) {
            this.x -= this.speed;
            direction = "left";
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = switch (direction) {
            case "left" -> this.left;
            case "right" -> this.right;
            default -> this.right;
        };
        g2.drawImage(image, x, y, 400, 400, null);
    }
}
