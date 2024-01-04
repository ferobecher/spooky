package Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Arrow {
    private static int x, y;
    private static boolean isShot;
    private final BufferedImage image;
    public Arrow() throws IOException {
        this.image = ImageIO.read(new File("res/pics/player/arrow/1.png"));
    }

    //settery
    public static void setX(int a) {
        x = a;
    }
    public static void setY(int a) {
        y = a;
    }
    public static void setShot(boolean shot) {
        isShot = shot;
    }

    //gettery
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public int getWidth() {
        return this.image.getWidth();
    }
    public int getHeight() {
        return this.image.getHeight();
    }
    public BufferedImage getImage() {
        return this.image;
    }
    public static boolean isShot() {
        return isShot;
    }

}
