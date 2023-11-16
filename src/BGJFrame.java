import javax.swing.*;
import java.awt.*;

public class BGJFrame extends JFrame{
    
    JButton b1;
    JLabel l1;

    public BGJFrame() {
        this.setLayout(new BorderLayout());
        JLabel bg = new JLabel(new ImageIcon("pics/bg.png"));
        this.add(bg);
        bg.setLayout(new FlowLayout());
        l1 = new JLabel("Here is a button");
        b1 = new JButton("I am a button");
        bg.add(l1);
        bg.add(b1);
    }
}
