package Main;
import Gameplay.GamePanel;
import Menu.MenuPanel;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private final JPanel cardPanel;
    private final MenuPanel menuPanel;
    private final GamePanel gamePanel;
    private final CardLayout cardLayout;
    public GameFrame() throws Exception {
        this.setFrame();

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(this.cardLayout);
        this.menuPanel = new MenuPanel(this);
        this.gamePanel = new GamePanel();

        this.cardPanel.add(menuPanel, "menu");
        this.cardPanel.add(gamePanel, "game");

        setContentPane(this.cardPanel);
    }
    private void setFrame() {
        //frame
        this.setTitle("Spooky");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1600,900);
        this.setBackground(null);
        this.setLayout(null);

        //icon
        ImageIcon icon = new ImageIcon("res/pics/icon.jpg");
        this.setIconImage(icon.getImage());
    }

    public void showGamePanel() {
        this.cardLayout.show(this.cardPanel, "game");
        this.gamePanel.setFocusable(true);
        this.gamePanel.requestFocusInWindow();
    }

}
