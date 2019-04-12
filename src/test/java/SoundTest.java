import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundTest {

    @Test
    void CreateSoundTest() {
        Sound sound = new Sound();
    }

    @Test
    void SetDataTest() {
        Sound sound = new Sound();
        byte[] bytes = new byte[]{};
        sound.setData(bytes);
    }

    @Test
    void GetDataTest() {
        Sound sound = new Sound();
        byte[] bytes = new byte[]{1};
        sound.setData(bytes);
        assertArrayEquals(new byte[]{1}, sound.getData());
    }

    @Test
    void GetDataOnlyAudioTest() {
        Sound sound = new Sound();
        byte[] bytes = new byte[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        };
        sound.setData(bytes);
        assertArrayEquals(new byte[]{4, 5, 6, 7, 8, 9}, sound.getAudioData());
    }

    @Test
    void SculptTwoSounds() {
        Sound sound = new Sound();
        byte[] bytes = new byte[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        };
        sound.setData(bytes);
        Sound sound2 = new Sound();
        byte[] bytes2 = new byte[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        };
        sound.setData(bytes2);
        sound.add(sound2);
        assertArrayEquals(new byte[]{5, 6, 7, 8, 9, 5, 6, 7, 8, 9}, sound.getData());
    }
}
