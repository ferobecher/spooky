package Menu;

import Main.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartButton extends MenuButtons implements ActionListener{
    private GameFrame gameFrame;
    public StartButton(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.addActionListener(this);
        this.setText("START");
        this.setBounds(200, 150,100, 50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameFrame.showGamePanel();
    }
}
