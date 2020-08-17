import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class GrowlingGears {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 2);
        for(int k = 0; k < t; k++) {
            int n = Integer.parseInt(r.readLine());
            int gear = 1;
            double max = 0.0;
            for(int i = 1; i <= n; i++) {
                String[] in = r.readLine().split(" ");
                int a = Integer.parseInt(in[0]) << 1;
                double b = (double) (Integer.parseInt(in[1]) * Integer.parseInt(in[1]));
                double gmax = b/a - b/(a << 1) + Integer.parseInt(in[2]);
                if(gmax > max) {
                    max = gmax;
                    gear = i;
                }
            }
            out.append(gear + "\n");
        }
        System.out.print(out);
        r.close();
    }
}