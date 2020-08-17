import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BobbysBet {

    private static long fact(int n) {
        long r = 1l;
        for(int i = 2; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        for(int k = 0; k < n; k++) {
            String[] in = r.readLine().split(" ");
            int min = Integer.parseInt(in[0]);
            double s = Double.parseDouble(in[1]);
            int x = Integer.parseInt(in[2]);
            int y = Integer.parseInt(in[3]);
            int w = Integer.parseInt(in[4]);
            double prob = 0.0;
            for(int i = x; i <= y; i++) {
                prob += fact(y) * Math.pow((s-min+1)/s, i) * Math.pow((min-1)/s, y-i) / (fact(i)*fact(y-i));
            }
            if(prob*w > 1.0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        r.close();
    }
}