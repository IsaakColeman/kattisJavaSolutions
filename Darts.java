import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Darts {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(r.readLine());
        for(int k = 0; k < t; k++) {
            int n = Integer.parseInt(r.readLine());
            int count = 0;
            for(int i = 0; i < n; i++) {
                String[] in = r.readLine().split(" ");
                int x = Integer.parseInt(in[0]);
                int y = Integer.parseInt(in[1]);
                int h = x*x+y*y;
                int ring;
                for(ring = 1; ring < 11; ring++) {
                    if(h <= 400*ring*ring) {
                        break;
                    }
                }
                count += 11 - ring;
            }
            out.append(count + "\n");
        }
        System.out.print(out);
        r.close();
    }
}