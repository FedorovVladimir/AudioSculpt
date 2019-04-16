import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            String pathTo = args[0];
            List<String> paths = new LinkedList<String>();
            for (int i = 1; i < args.length; i++) {
                paths.add(args[i]);
            }
            covert(pathTo, paths);
        } else {
            System.out.println("Некорректно!");
        }
    }

    private static void covert(String pathTo, List<String> paths) {
        try {
            Sound sound = new Sound(paths.get(0));
            for (int i = 1; i < paths.size(); i++) {
                sound.add(new Sound(paths.get(i)));
            }
            sound.save(pathTo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
