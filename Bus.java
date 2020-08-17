import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Bus {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 3);
        for(int i = 0; i < t; i++) {
            out.append((1 << Integer.parseInt(r.readLine())) -1);
            out.append("\n");
        }
        System.out.print(out);
        r.close();
    }
}