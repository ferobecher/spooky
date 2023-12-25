package Menu;

import Menu.MenuButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sounds.Sounds;

public class OptionsButton extends MenuButtons implements ActionListener{
    public OptionsButton() {
        this.addActionListener(this);

        this.setText("OPTIONS");
        this.setBounds(200, 220,100, 50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            Sounds.playSwordSound();
    }
}