package Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public enum EnemyAction {
    IDLE(new BufferedImage[6], "idle", 6),
    DEAD(new BufferedImage[3], "dead", 3);
    private BufferedImage[] images;
    private int iterator;
    private int counter;
    private boolean stop;
    EnemyAction(BufferedImage[] images, String actionName, int size) {
        this.stop = false;

        //load images
        this.images = images;
        for (int i = 0; i < size; i++) {
            try {
                this.images[i] = ImageIO.read(new File("res/pics/enemy/" + actionName + "/" + (i+1) + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BufferedImage animate() {
        this.counter++;
        if(!stop && this.counter == 8) {
            this.iterator++;
            if (this.iterator == this.images.length) {

                //reset animation or stop if dead
                if (iterator == 4) {
                    this.stop = true;
                    this.iterator = 3;
                } else {
                    this.iterator = 0;
                }
            }
            this.counter = 0;
        }
        return this.images[this.iterator];
    }
}
