import org.junit.jupiter.api.Test;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SoundTest {

    private byte[] bytes = new byte[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
    };

    private String source = "src/test/resources/Hiphop.wav";

    @Test
    void CreateSoundTest() {
        new Sound();
        new Sound(bytes);
        try {
            new Sound(source);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    @Test
    void SetDataTest() {
        Sound sound = new Sound();
        sound.setData(bytes);
    }

    @Test
    void GetDataTest() {
        Sound sound = new Sound(bytes);
        assertArrayEquals(bytes, sound.getData());
    }

    @Test
    void GetDataOnlyAudioTest() {
        Sound sound = new Sound(bytes);
        assertArrayEquals(new byte[]{4, 5, 6, 7, 8, 9}, sound.getAudioData());
    }

    @Test
    void SculptTwoSoundsTest() {
        Sound sound = new Sound(bytes);
        Sound sound2 = new Sound(bytes);
        sound.add(sound2);
        assertArrayEquals(new byte[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                4, 5, 6, 7, 8, 9
        }, sound.getData());
    }

    @Test
    void SaveTest() {
        Sound sound = null;
        try {
            sound = new Sound(source);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        String result = "src/test/resources/result.wav";
        try {
            sound.save(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(result);
        assertTrue(file.isFile());
        file.delete();
    }
}
