package Gameplay;
import Sounds.Sounds;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    private boolean upPressed, downPressed, rightPressed, leftPressed, shiftPressed, spacePressed, fPressed, cPressed, vPressed;
    private boolean upReleased, downReleased, rightReleased, leftReleased, shiftReleased, spaceReleased, fReleased, cReleased, vReleased;

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
        if(keyCode == KeyEvent.VK_SHIFT) {
            this.shiftPressed = true;
        }
        if(keyCode == KeyEvent.VK_SPACE) {
            this.spacePressed = true;
        }
        if(keyCode == KeyEvent.VK_F) {
            this.fPressed = true;
        }
        if(keyCode == KeyEvent.VK_C) {
            this.cPressed = true;
        }
        if(keyCode == KeyEvent.VK_V) {
            this.vPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W) {
            this.upPressed = false;
            this.upReleased = true;
        }
        if(keyCode == KeyEvent.VK_D) {
            this.rightPressed = false;
            this.rightReleased = true;
        }
        if(keyCode == KeyEvent.VK_S) {
            this.downPressed = false;
            this.downReleased = true;
        }
        if(keyCode == KeyEvent.VK_A) {
            this.leftPressed = false;
            this.leftReleased = true;
        }
        if(keyCode == KeyEvent.VK_SHIFT) {
            this.shiftPressed = false;
            this.shiftReleased = true;
        }
        if(keyCode == KeyEvent.VK_SPACE) {
            this.spacePressed = false;
            this.spaceReleased = true;
        }
        if(keyCode == KeyEvent.VK_F) {
            this.fPressed = false;
            this.fReleased = true;
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
    public boolean getShiftPressed() { return this.shiftPressed; }
    public boolean getSpacePressed() { return this.spacePressed; }
    public boolean getCPressed() {
        return this.cPressed;
    }
    public boolean getVPressed() { return this.vPressed; }
    public boolean getFPressed() { return this.fPressed; }
    public boolean getUpReleased() {
        boolean a = this.upReleased;
        this.upReleased = false;
        return a;
    }
    public boolean getRightReleased() {
        boolean a = this.rightReleased;
        this.rightReleased = false;
        return a;
    }
    public boolean getDownReleased() {
        boolean a = this.downReleased;
        this.downReleased = false;
        return a;
    }
    public boolean getFReleased() {
        boolean a = this.fReleased;
        this.fReleased = false;
        return a;
    }
    public boolean getLeftReleased() {
        boolean a = this.leftReleased;
        this.leftReleased = false;
        return a;
    }
    public boolean getSpaceReleased() {
        boolean a = this.spaceReleased;
        this.spaceReleased = false;
        return a;
    }
    public boolean getVReleased() {
        boolean a = this.vReleased;
        this.vReleased = false;
        return a;
    }
    public boolean getCReleased() {
        boolean a = this.cReleased;
        this.cReleased = false;
        return a;
    }
    public boolean getShiftReleased() {
        boolean a = this.shiftReleased;
        this.shiftReleased = false;
        return a;
    }
}
