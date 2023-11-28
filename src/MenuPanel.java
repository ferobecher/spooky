import java.awt.BorderLayout;

import javax.swing.*;

public class MenuPanel extends JPanel{
    public MenuPanel() {
        this.setBackground(null);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setSize(800,900);
        this.add(new Menu());
        this.setVisible(true);
    }
}