import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        play("/home/vladimir/Музыка/Hiphop.wav");
        Sound sound = null;
        try {
            sound = new Sound("/home/vladimir/Музыка/Hiphop.wav");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        sound.add(sound);
        try {
            sound.save("src/main/resources/result.wav");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        while (true) {
//
//        }
    }

    public static void play(String path) {
        try {
            File soundFile = new File(path); //Звуковой файл

            //Получаем AudioInputStream
            //Вот тут могут полететь IOException и UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            //Получаем реализацию интерфейса Clip
            //Может выкинуть LineUnavailableException
            Clip clip = AudioSystem.getClip();

            //Загружаем наш звуковой поток в Clip
            //Может выкинуть IOException и LineUnavailableException
            clip.open(ais);
            clip.setFramePosition(0); //устанавливаем указатель на старт
            clip.start(); //Поехали!!!
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}
