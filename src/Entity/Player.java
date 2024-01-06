package Entity;

import Gameplay.Background;
import Gameplay.KeyInput;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {
    private static int x, y;
    private int speed;
    private final KeyInput keyInput;
    private final Arrow arrow;
    private static Action action;
    private BufferedImage shownImage;
    private boolean isShooting;
    private static boolean isJumping;

    public Player(KeyInput keyInput) throws IOException {
        this.keyInput = keyInput;
        this.arrow = new Arrow();
        x = 200;
        y = 530;
        this.speed = 4;
        action = Action.IDLE;
    }
    public void update() {
        double slow;
        if (isShooting) {
            slow = 0.3;}
        else {
            slow = 1.0;}
        if (action != Action.DEAD) {
            if (!isJumping) {
                //release to idle
                if (this.keyInput.getSpaceReleased() ||
                        this.keyInput.getFReleased() ||
                        this.keyInput.getCReleased() ||
                        this.keyInput.getVReleased()) {
                    action.resetIterator();
                    this.isShooting = false;
                    action = Action.IDLE;
                    y = Background.getY();
                }
                if (!isShooting && (
                        this.keyInput.getLeftReleased() ||
                                this.keyInput.getRightReleased() ||
                                this.keyInput.getUpReleased() ||
                                this.keyInput.getDownReleased() ||
                                this.keyInput.getShiftReleased())) {
                    action.resetIterator();
                    action = Action.IDLE;
                    y = Background.getY();
                }
            }

            //key handling
            if (this.keyInput.getRightPressed()) {
                x += this.speed * slow;
                if (!isShooting && !isJumping) {
                    action = Action.WALK;
                }
            }
            if (this.keyInput.getLeftPressed()) {
                x -= this.speed * slow;
                if (!isShooting && !isJumping) {
                    action = Action.WALK;
                }
            }
            if (this.keyInput.getUpPressed()) {
                if (!isShooting  && !isJumping) {
                    action = Action.JUMP;
                    isJumping = true;
                }
            }
            if (this.keyInput.getShiftPressed() && this.keyInput.getLeftPressed()) {
                x -= this.speed * 1.7 * slow;
                if (!isShooting  && !isJumping) {
                    action = Action.RUN;
                }
            }
            if (this.keyInput.getShiftPressed() && this.keyInput.getRightPressed()) {
                x += this.speed * 1.7 * slow;
                if (!isShooting  && !isJumping) {
                    action = Action.RUN;
                }
            }
            if (!isJumping) {
                if (this.keyInput.getSpacePressed()) {
                    action = Action.SHOT1;
                    this.isShooting = true;
                }
                if (this.keyInput.getCPressed()) {
                    action = Action.DEAD;
                }
                if (this.keyInput.getVPressed()) {
                    action = Action.HURT;
                }
                if (this.keyInput.getFPressed()) {
                    action = Action.ATTACK;
                }

                //arrow movement
                if (Arrow.isShot()) {
                    Arrow.setX(Arrow.getX() + 69);
                    if (Arrow.getX() > 1600) {
                        Arrow.setShot(false);
                    }
                } else {
                    Arrow.setX(x + 110);
                    Arrow.setY(y + 100);
                }
            }
        }
        this.shownImage = action.animate();
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(shownImage, x, y, shownImage.getWidth()*3, shownImage.getHeight()*3, null);

        if(Arrow.isShot()) {
            g2.drawImage(this.arrow.getImage(), Arrow.getX(), Arrow.getY(),
                    this.arrow.getWidth()*3, this.arrow.getHeight()*3, null );
        }

    }
    public static void changeY(int addition) {
        y += addition;
    }
    public static void setX(int newX) {
        x = newX;
    }
    public static void setY(int newY) {
        y = newY;
    }
    public static int getX() {
        return x;
    }
    public static void setJumping(boolean a) {
        isJumping = a;
    }
}

