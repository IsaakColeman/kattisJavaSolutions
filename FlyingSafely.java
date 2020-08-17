import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class FlyingSafely {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(n << 3);
        for(int i = 0; i < n; i++) {
            String[] in = r.readLine().split(" ", 2);
            out.append(Integer.parseInt(in[0]) -1);
            out.append("\n");
            int m = Integer.parseInt(in[1]);
            for(int j = 0; j < m; j++) {
                r.readLine();
            }
        }
        System.out.print(out);
        r.close();
    }
}