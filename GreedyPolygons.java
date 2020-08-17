import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class GreedyPolygons {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 5);
        for(int i = 0; i < t; i++) {
            String[] in = r.readLine().split(" ", 4);
            int n = Integer.parseInt(in[0]);
            int l = Integer.parseInt(in[1]);
            int d = Integer.parseInt(in[2]) * Integer.parseInt(in[3]);
            out.append((Math.PI * d + l*n)*d + l*l*n/(4*Math.tan(Math.PI/n)));
            out.append("\n");
        }
        System.out.print(out);
        r.close();
    }
}