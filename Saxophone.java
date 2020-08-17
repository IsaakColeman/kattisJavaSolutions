import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.lang.StringBuilder;

class Saxophone {
    Boolean[] fingers;
    int[] press;
    Vector<Boolean[]> notes;

    public Saxophone(Vector<Boolean[]> notes) {
        this.fingers = new Boolean[10];
        this.press = new int[10];
        this.notes = notes;
        for(int i = 0; i < 10; i++) {
            this.fingers[i] = false;
        }
    }

    public void play(char c) {
        Boolean[] p;
        if(c > 'G') {
            p = notes.get(c-'a');
        } else {
            p = notes.get(c-'A'+7);
        }
        for(int i = 0; i < 10; i++) {
            if(p[i] && !fingers[i]) {
                press[i]++;
            }
        }
        this.fingers = p;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d %d 0 0 %d %d %d %d\n", press[0], press[1], press[2], press[3], press[6], press[7], press[8], press[9]);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Vector<Boolean[]> notes = new Vector<Boolean[]>();
        int t = Integer.parseInt(r.readLine());

        notes.add(new Boolean[] {false, true, true, false, false, false, false, false, false, false});
        notes.add(new Boolean[] {false, true, false, false, false, false, false, false, false, false});
        notes.add(new Boolean[] {false, true, true, true, false, false, true, true, true, true});
        notes.add(new Boolean[] {false, true, true, true, false, false, true, true, true, false});
        notes.add(new Boolean[] {false, true, true, true, false, false, true, true, false, false});
        notes.add(new Boolean[] {false, true, true, true, false, false, true, false, false, false});
        notes.add(new Boolean[] {false, true, true, true, false, false, false, false, false, false});
        notes.add(new Boolean[] {true, true, true, false, false, false, false, false, false, false});
        notes.add(new Boolean[] {true, true, false, false, false, false, false, false, false, false});
        notes.add(new Boolean[] {false, false, true, false, false, false, false, false, false, false});
        notes.add(new Boolean[] {true, true, true, true, false, false, true, true, true, false});
        notes.add(new Boolean[] {true, true, true, true, false, false, true, true, false, false});
        notes.add(new Boolean[] {true, true, true, true, false, false, true, false, false, false});
        notes.add(new Boolean[] {true, true, true, true, false, false, false, false, false, false});

        StringBuilder out = new StringBuilder(t << 4);

        for(int i = 0; i < t; i++) {
            char[] song = r.readLine().toCharArray();
            Saxophone s = new Saxophone(notes);
            for(char c : song) {
                s.play(c);
            }
            out.append(s);
        }

        System.out.print(out);
        r.close();
    }
}