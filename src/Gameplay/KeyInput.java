package Gameplay;
import Sounds.Sounds;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    private boolean upPressed, downPressed, rightPressed, leftPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W) {
            this.upPressed = true;
        }
        if(keyCode == KeyEvent.VK_D) {
            this.rightPressed = true;
        }
        if(keyCode == KeyEvent.VK_S) {
            this.downPressed = true;
        }
        if(keyCode == KeyEvent.VK_A) {
            this.leftPressed = true;
        }
        if(keyCode == KeyEvent.VK_ENTER) {
            Sounds.playSwordSound();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W) {
            this.upPressed = false;
        }
        if(keyCode == KeyEvent.VK_D) {
            this.rightPressed = false;
        }
        if(keyCode == KeyEvent.VK_S) {
            this.downPressed = false;
        }
        if(keyCode == KeyEvent.VK_A) {
            this.leftPressed = false;
        }
    }
    public boolean getUpPressed() {
        return this.upPressed;
    }
    public boolean getRightPressed() {
        return this.rightPressed;
    }
    public boolean getDownPressed() {
        return this.downPressed;
    }
    public boolean getLeftPressed() {
        return this.leftPressed;
    }
}
