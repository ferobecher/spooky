package Gameplay;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Background {
    private static BufferedImage spooky;
    private static BufferedImage forest;
    private static BufferedImage bg;
    private static int y;
    private static int counter;

    public Background() throws Exception {
        spooky = ImageIO.read(new File("res/pics/bg/spooky.png"));
        forest = ImageIO.read(new File("res/pics/bg/forest.png"));
        change();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bg, 0,0,1600, 900, null);
    }
    public static void change() {
        if (counter == 0) {
            bg = spooky;
            counter = 1;
            y = 530;
        } else if (counter == 1) {
            bg = forest;
            counter = 0;
            y = 600;
        }
    }
    public static int getY() {
        return y;
    }
}