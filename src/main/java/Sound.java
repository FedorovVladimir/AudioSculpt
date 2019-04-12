import org.apache.commons.lang3.ArrayUtils;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Sound {

    private byte[] bytes;
    private AudioFormat af = null;

    public Sound() {

    }

    public Sound(byte[] bytes) {
        this.bytes = bytes;
    }

    public Sound(String path) throws IOException, UnsupportedAudioFileException {
        File file = new File(path);

        if(!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }

        // получаем поток с аудио-данными
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);

        // получаем информацию о формате
        af = ais.getFormat();

        // количество кадров в файле
        long framesCount = ais.getFrameLength();

        // размер данных в байтах
        long dataLength = framesCount*af.getSampleSizeInBits()*af.getChannels()/8;

        // читаем в память все данные из файла разом
        bytes = new byte[(int) dataLength];
        ais.read(bytes);
    }

    public void setData(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getData() {
        return bytes;
    }

    public byte[] getAudioData() {
        return Arrays.copyOfRange(bytes, 44, bytes.length);
    }

    public void add(Sound sound2) {
        bytes = ArrayUtils.addAll(bytes, sound2.getAudioData());
    }

    public void save(String path) throws IOException {
        AudioSystem.write( new AudioInputStream(new ByteArrayInputStream(bytes), af, getFramesCount()), AudioFileFormat.Type.WAVE, new File(path));
    }

    private long getFramesCount() {
        return bytes.length / af.getSampleSizeInBits() / af.getChannels() * 8;
    }
}
