import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JButton b1;
    JLabel l1;

    public GameFrame() {
        //frame
        this.setVisible(true);
        this.setTitle("Spooky");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(800, 800);
        this.getContentPane().setBackground(new Color(0xDDDDDD));

        //icon
        ImageIcon icon = new ImageIcon("pics/icon.jpg");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xDDDDDD));

        //background
        this.setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("pics/bg.png"));
        this.add(background);
        background.setLayout(new FlowLayout());
        l1 = new JLabel("Here is a button");
        b1 = new JButton("This is a button");


        //objects
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon("pics/skeleton.png");

        label.setIcon(image);
        label.setText("Spooky");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0xFFFFFF));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));

        l1 = new JLabel("Here is a button");
        b1 = new JButton("This is a button");


        //add
        background.add(l1);
        background.add(b1);
        background.add(label);

    }
}
