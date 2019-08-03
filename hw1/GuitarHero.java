import edu.princeton.cs.algs4.StdAudio;
import es.datastructur.synthesizer.Drum;
import es.datastructur.synthesizer.GuitarString;
import es.datastructur.synthesizer.Harp;

public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        int n = keyboard.length();
        Drum[] s = new Drum[37];
        for (int i = 0; i < n; i++) {
            double f = 440.0 * Math.pow(2, (i - 24) / 12);
            s[i] = new Drum(f);
        }
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index < 0) {
                    continue;
                } else {
                    s[index].pluck();
                }
            }

            double sample = 0;
            for (int i = 0; i < n; i++) {
                sample += s[i].sample();
                s[i].tic();
            }

            StdAudio.play(sample);
        }
    }
}
