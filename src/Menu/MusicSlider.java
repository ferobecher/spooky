package Menu;
import Sounds.Sounds;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MusicSlider implements ChangeListener{
    JSlider slider;

    public MusicSlider(){

        slider = new JSlider(0,100,0);
        slider.setPreferredSize(new Dimension(400,200));
        slider.setOrientation(SwingConstants.HORIZONTAL);
        slider.addChangeListener(this);
        slider.setBackground(null);
        slider.setOpaque(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Sounds.changeMusicVolume(slider.getValue());
    }

    public JSlider getSlider() {
        return this.slider;
    }
}
