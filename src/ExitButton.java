import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends MenuButtons implements ActionListener{
    public ExitButton() {
        this.addActionListener(this);

        this.setText("EXIT");
        this.setBounds(200, 290,100, 50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("exit");
    }
}