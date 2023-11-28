import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Menu extends JLayeredPane{

    public Menu(){
        
        JLabel name = new JLabel();
        name.setLayout(new BorderLayout());
        name.setText("SPOOOOKY");
        name.setFont(new Font("MV Boli", Font.BOLD, 80));
        name.setForeground(Color.white);
        name.setVerticalTextPosition(JLabel.TOP);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setOpaque(false);
        name.setBackground(null);

        JLabel buttons = new JLabel(); 
        buttons.setBounds(300,180,200,300);
        buttons.setLayout(new GridLayout(3,1,0,30));
        buttons.add(new StartButton());
        buttons.add(new OptionsButton());
        buttons.add(new ExitButton());
        buttons.setOpaque(false);
        buttons.setBackground(null);

        this.add(name);
        this.add(buttons);
    }
}
