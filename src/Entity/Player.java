package Entity;

import Gameplay.Background;
import Gameplay.KeyInput;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {
    private int x, y, speed;
    private final KeyInput keyInput;
    private final Arrow arrow;
    private static PlayerAction action;
    private BufferedImage shownImage;
    private boolean slowed;
    private boolean isShooting;

    public Player(KeyInput keyInput) throws IOException {
        this.keyInput = keyInput;
        this.arrow = new Arrow();
        this.slowed = false;
        this.setDefaultValues();
    }
    public void setDefaultValues() {
        this.x = 200;
        this.y = 530;
        this.speed = 4;
        action = PlayerAction.IDLE;
    }
    public void update() {

        double slow = 1;
        if (slowed) slow = 0.3;

        //release to idle
        if (this.keyInput.getSpaceReleased() ||
                this.keyInput.getFReleased() ||
                this.keyInput.getCReleased() ||
                this.keyInput.getVReleased()) {
            action.resetIterator();
            action = PlayerAction.IDLE;
        }
        if (!isShooting && (
                this.keyInput.getLeftReleased() ||
                this.keyInput.getRightReleased() ||
                this.keyInput.getUpReleased() ||
                this.keyInput.getDownReleased() ||
                this.keyInput.getShiftReleased())) {
            action.resetIterator();
            action = PlayerAction.IDLE;
        }

        //key handling
        if (this.keyInput.getRightPressed()) {
            this.x += this.speed * slow;
            if(!isShooting) {
                action = PlayerAction.WALK;
            }
        }
        if (this.keyInput.getLeftPressed()) {
            this.x -= this.speed * slow;
            if(!isShooting) {
                action = PlayerAction.WALK;
            }
        }
        if (this.keyInput.getUpPressed()) {
            if(!isShooting) {
                action = PlayerAction.JUMP;
            }
        }
        if (this.keyInput.getShiftPressed() && this.keyInput.getLeftPressed()) {
            this.x -= this.speed * 1.7 * slow;
            if(!isShooting) {
                action = PlayerAction.RUN;
            }
        }
        if (this.keyInput.getShiftPressed() && this.keyInput.getRightPressed()) {
            this.x += this.speed * 1.7 * slow;
            if(!isShooting) {
                action = PlayerAction.RUN;
            }
        }
        if (this.keyInput.getSpacePressed()) {
            action = PlayerAction.SHOT1;
            this.isShooting = true;
            this.slowed = true;
        }
        if (this.keyInput.getSpaceReleased()) {
            this.isShooting = false;
            this.slowed = false;
        }
        if (this.keyInput.getCPressed()) {
            action = PlayerAction.DEAD;
        }
        if (this.keyInput.getVPressed()) {
            action = PlayerAction.HURT;
        }
        if (this.keyInput.getFPressed()) {
            action = PlayerAction.ATTACK;
        }

        //background change
        if (this.x > 1550) {
            this.x = 0;
            Background.change();
            this.y = Background.getY();
        }
        if (this.x < -200) {
            this.x = 1400;
            Background.change();
            this.y = Background.getY();
        }

        //arrow movement
        if(Arrow.isShot()) {
            this.arrow.setX(this.arrow.getX() + 69);
            if (this.arrow.getX() > 1600) {
                Arrow.setShot(false);
            }
        } else {
            this.arrow.setX(x+110);
            this.arrow.setY(y+100);
        }

        this.shownImage = action.animate();
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(shownImage, x, y, shownImage.getWidth()*3, shownImage.getHeight()*3, null);

        if(Arrow.isShot()) {
            g2.drawImage(this.arrow.getImage(), this.arrow.getX(), this.arrow.getY(),
                    this.arrow.getWidth()*3, this.arrow.getHeight()*3, null );
        }

    }
}

