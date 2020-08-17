import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Heliocentric {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = 1;
        do {
            String[] in = r.readLine().split(" ");
            int e = Integer.parseInt(in[0]);
            int d = e - Integer.parseInt(in[1]);
            int x = 0;
            int y = 0;
            while(x != y + d) {
                if(x < y + d) {
                    x += 365;
                } else {
                    y += 687;
                }
            }
            out.append(String.format("Case %d: %d\n", t++, x-e));
        } while(r.ready());
        System.out.print(out);
        r.close();
    }
}