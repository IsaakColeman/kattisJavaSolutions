import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class DST {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(r.readLine());
        for(int k = 0; k < t; k++) {
            String[] in = r.readLine().split(" ");
            if(in[0].equals("F")) {
                int m = Integer.parseInt(in[3]) + Integer.parseInt(in[1]);
                int h = Integer.parseInt(in[2]) + m/60;
                m %= 60;
                h %= 24;
                out.append(String.format("%d %d\n", h, m));
            } else {
                int m = Integer.parseInt(in[3]) - Integer.parseInt(in[1]);
                int h = Integer.parseInt(in[2]) + m/60;
                m %= 60;
                if(m < 0) {
                    m += 60;
                    h--;
                }
                h %= 24;
                if(h < 0) {
                    h += 24;
                }
                out.append(String.format("%d %d\n", h, m));
            }
        }
        System.out.print(out);
        r.close();
    }
}