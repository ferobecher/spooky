import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;
public class Sounds {
    public Sounds() {
    }
    public void playSounds() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);
        
        File SwordSound = new File("sounds/Sword.wav");
        File BgMusic = new File("sounds/Music.wav");

        AudioInputStream audioStreamSwordSound = AudioSystem.getAudioInputStream(SwordSound);
        AudioInputStream audioStreamBgMusic = AudioSystem.getAudioInputStream(BgMusic);

        Clip clipSwordSound = AudioSystem.getClip();
        Clip clipBgMusic = AudioSystem.getClip();

        clipSwordSound.open(audioStreamSwordSound);
        clipBgMusic.open(audioStreamBgMusic);

        String response = "";

        while (!response.equals("Q")){
            System.out.println("To control background music:");
            System.out.println("P = Play, S = Stop, R = Reset");
            System.out.println("To make a sword sound press L");
            System.out.println("To exit press Q");
            System.out.print("Enter your choice: ");

            // user input into console
            response = scanner.next().toUpperCase();
            
            switch(response) {
                case ("P"): clipBgMusic.start();
                break;
                case ("L"): clipSwordSound.setMicrosecondPosition(0);
                            clipSwordSound.start();
                break;
                case ("S"): clipBgMusic.stop();
                break;
                case ("R"): clipBgMusic.setMicrosecondPosition(0);
                break;
                case ("Q"): clipBgMusic.close();
                            clipSwordSound.close();
                break;
                default: System.out.println("Not a valid response");

            clipBgMusic.close();
            }
        }
        scanner.close();
        System.out.println("Program ended");
    }
}
