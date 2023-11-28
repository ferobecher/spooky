import javax.swing.*;

public class GameFrame extends JFrame {
    JLabel bg;
    public GameFrame(JLayeredPane panel) throws Exception {
        //frame
        this.setVisible(true);
        this.setTitle("Spooky");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1600,900);
        this.setBackground(null);
        this.setLayout(null);

        //icon
        ImageIcon icon = new ImageIcon("pics/icon.jpg");
        this.setIconImage(icon.getImage());

        //add
        this.add(panel);

        

    }
}
