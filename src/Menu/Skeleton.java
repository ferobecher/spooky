package Menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Skeleton extends JLabel{

    public Skeleton() {
        
        ImageIcon image = new ImageIcon("res/pics/skeleton.png");
        this.setIcon(image);
        this.setText("Igor");
        this.setFont(new Font("MV Boli", Font.BOLD, 30));
        this.setForeground(Color.white);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setSize(600,600);
        this.setOpaque(false);
    }
}
