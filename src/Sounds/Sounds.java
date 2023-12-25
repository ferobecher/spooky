package Sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
public class Sounds {
    private static Clip clipBgMusic;
    private static Clip clipSwordSound;
    public Sounds() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File SwordSound = new File("res/sounds/Sword.wav");
        File BgMusic = new File("res/sounds/Music.wav");

        AudioInputStream audioStreamSwordSound = AudioSystem.getAudioInputStream(SwordSound);
        AudioInputStream audioStreamBgMusic = AudioSystem.getAudioInputStream(BgMusic);

        clipSwordSound = AudioSystem.getClip();
        clipBgMusic = AudioSystem.getClip();

        clipSwordSound.open(audioStreamSwordSound);
        clipBgMusic.open(audioStreamBgMusic);

        setVolume(clipBgMusic, 0.0f);
        setVolume(clipSwordSound, 1.0f);
    }
    public static void playMusic() {
        clipBgMusic.start();
    }
    public static void playSwordSound() {
        clipSwordSound.setMicrosecondPosition(0);
        clipSwordSound.start();
    }
    public static void quitSounds() {
        clipBgMusic.close();
        clipSwordSound.close();
    }

    //chatgpt kod na zmenu hlasitosti, chcel som to spravit sam ale bol potrebny prepocet s logaritmami
    public static void setVolume(Clip clip, float volume) {
        if (clip != null) {
            if (volume < 0.0f) {
                volume = 0.0f;
            } else if (volume > 1.0f) {
                volume = 1.0f;
            }

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }

    public static void changeMusicVolume(int value) {

        setVolume(clipBgMusic, ((float) value)/100);
    }
}
