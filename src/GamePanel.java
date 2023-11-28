import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class GamePanel extends JLayeredPane{
    JLabel bg;

    public GamePanel() throws Exception{
        this.setLayout(null);
        this.setBounds(0,0,1600,900);

        //background
        bg = new JLabel("", new ImageIcon("pics/bg.jpg"), JLabel.CENTER);
        bg.setPreferredSize(new Dimension(100,100));
        bg.setOpaque(true);
        bg.setBounds(0,0,1600,900);
        this.add(bg, JLayeredPane.DEFAULT_LAYER);

        //name
        JLabel name = new JLabel();
        name.setSize(1600, 300);
        name.setText("SPOOOKY");
        name.setFont(new Font("MV Boli", Font.BOLD, 130));
        name.setForeground(Color.black);
        name.setVerticalTextPosition(JLabel.BOTTOM);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.BOTTOM);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setOpaque(false);
        name.setBackground(null);


        //creates three panels to split screen
        JPanel splitLeft = new JPanel();
        splitLeft.setLayout(new BorderLayout());
        splitLeft.setVisible(true);
        splitLeft.add(new SkeletonPanel());
        splitLeft.setBackground(null);
        splitLeft.setBounds(0,200,800,600);
        splitLeft.setOpaque(false);
        this.add(splitLeft, JLayeredPane.PALETTE_LAYER);

        JPanel splitRight = new JPanel();
        splitRight.setLayout(new BorderLayout());
        splitRight.setVisible(true);
        splitRight.add(new MenuPanel());
        splitRight.setBackground(null);
        splitRight.setBounds(800,200,800,600);
        splitRight.setOpaque(false);
        this.add(splitRight, JLayeredPane.PALETTE_LAYER);

        JPanel splitTop = new JPanel();
        splitTop.setLayout(new BorderLayout());
        splitTop.setVisible(true);
        splitTop.add(name);
        splitTop.setBackground(null);
        splitTop.setBounds(0,0,1600,300);
        splitTop.setOpaque(false);
        this.add(splitTop, JLayeredPane.PALETTE_LAYER);

    }
}   
