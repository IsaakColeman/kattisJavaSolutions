import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class FlowShop {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder(5000);
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[] delay = new int[m];
        for(int i = 0; i < n; i++) {
            in = r.readLine().split(" ");
            delay[0] += Integer.parseInt(in[0]);
            for(int j = 1; j < m; j++) {
                delay[j] = Math.max(delay[j-1], delay[j]) + Integer.parseInt(in[j]);
            }
            out.append(delay[m-1] + " ");
        }
        System.out.println(out);
        r.close();
    }
}