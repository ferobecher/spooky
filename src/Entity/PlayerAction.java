package Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public enum PlayerAction {
    IDLE(new BufferedImage[6], "idle", 6),
    IDLE2(new BufferedImage[4], "idle2", 4),
    WALK(new BufferedImage[8], "walk", 8),
    RUN(new BufferedImage[8], "run", 8),
    DEAD(new BufferedImage[3], "dead", 3),
    HURT(new BufferedImage[3], "hurt", 3),
    ATTACK(new BufferedImage[4], "attack", 4),
    SHOT1(new BufferedImage[14], "shot1", 14),
    SHOT2(new BufferedImage[13], "shot2", 13),
    JUMP(new BufferedImage[9], "jump", 9);

    private BufferedImage[] images;
    private int iterator;
    private int counter;
    PlayerAction(BufferedImage[] images, String actionName, int size) {

        //load images
        this.images = images;
        for (int i = 0; i < size; i++) {
            try {
                this.images[i] = ImageIO.read(new File("res/pics/player/" + actionName + "/" + (i+1) + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public BufferedImage animate() {
        this.counter++;
        if(this.counter == 8) {
            if (this.iterator == this.images.length - 1) {
                this.iterator = 0;
            }
            this.iterator++;
            this.counter = 0;
        }
        if (iterator == 12) {
            Arrow.setShot(true);
        }
        return this.images[this.iterator];
    }
    public void resetIterator() {
        this.iterator = 0;
    }
}
