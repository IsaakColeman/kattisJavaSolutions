import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class HydraHeads {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder(128);
        String[] in = r.readLine().split(" ", 2);
        int h = Integer.parseInt(in[0]);
        int t = Integer.parseInt(in[1]);
        do {
            if(t == 0 && h%2 == 1) {
                out.append(-1 + "\n");
            } else {
                int moves = t/2;
                h = h + t/2 + t%2;
                if(h%2 == 1) {
                    moves += 3 + 2*(t%2);
                    h++;
                } else if(t%2 == 1) {
                    moves += 2;
                }
                out.append(moves + h/2 + "\n");
            }
            in = r.readLine().split(" ", 2);
            h = Integer.parseInt(in[0]);
            t = Integer.parseInt(in[1]);
        } while(h != 0 || t != 0);
        System.out.print(out);
        r.close();
    }
}