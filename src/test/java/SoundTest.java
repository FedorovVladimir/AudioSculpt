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
        assertArrayEquals(new byte[]{1}, sound.getData(bytes));
    }
}
