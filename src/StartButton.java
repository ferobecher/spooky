import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends MenuButtons implements ActionListener{
    public StartButton() {
        this.addActionListener(this);

        this.setText("START");
        this.setBounds(200, 150,100, 50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("start");
    }
}
