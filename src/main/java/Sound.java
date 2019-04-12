import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Sound {

    private byte[] bytes;

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
}
