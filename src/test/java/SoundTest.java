import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundTest {

    private byte[] bytes = new byte[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
    };

    @Test
    void CreateSoundTest() {
        new Sound();
        new Sound(bytes);
    }

    @Test
    void SetDataTest() {
        Sound sound = new Sound();
        sound.setData(bytes);
    }

    @Test
    void GetDataTest() {
        Sound sound = new Sound();
        sound.setData(bytes);
        assertArrayEquals(bytes, sound.getData());
    }

    @Test
    void GetDataOnlyAudioTest() {
        Sound sound = new Sound();
        sound.setData(bytes);
        assertArrayEquals(new byte[]{4, 5, 6, 7, 8, 9}, sound.getAudioData());
    }

    @Test
    void SculptTwoSounds() {
        Sound sound = new Sound();
        sound.setData(bytes);
        Sound sound2 = new Sound();
        sound2.setData(bytes);
        sound.add(sound2);
        assertArrayEquals(new byte[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3,
                4, 5, 6, 7, 8, 9, 4, 5, 6, 7, 8, 9}, sound.getData());
    }
}
