import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsButton extends MenuButtons implements ActionListener{
    public OptionsButton() {
        this.addActionListener(this);

        this.setText("OPTIONS");
        this.setBounds(200, 220,100, 50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("options");
    }
}