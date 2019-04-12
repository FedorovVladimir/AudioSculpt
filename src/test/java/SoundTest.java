import org.junit.jupiter.api.Test;

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
}
