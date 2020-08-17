import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class CombinationLock {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        StringBuilder out = new StringBuilder();
        int s = Integer.parseInt(in[0]);
        int c1 = Integer.parseInt(in[1]);
        int c2 = Integer.parseInt(in[2]);
        int c3 = Integer.parseInt(in[3]);
        while(s != 0 || c1 != 0 || c2 != 0 || c3 != 0) {
            in = r.readLine().split(" ");
            out.append((120 + (s >= c1 ? s - c1 : s - c1 + 40) + (c2 >= c1 ? c2 - c1 : c2 - c1 + 40) + (c2 >= c3 ? c2 - c3 : c2 - c3 + 40))*9 + "\n");
            s = Integer.parseInt(in[0]);
            c1 = Integer.parseInt(in[1]);
            c2 = Integer.parseInt(in[2]);
            c3 = Integer.parseInt(in[3]);
        }
        System.out.print(out);
        r.close();
    }
}