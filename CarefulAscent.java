import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CarefulAscent {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);
        int left = y;
        double sum = 0.0;
        int n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; i++) {
            in = r.readLine().split(" ");
            int disty = Integer.parseInt(in[1]) - Integer.parseInt(in[0]);
            left -= disty;
            sum += Double.parseDouble(in[2])*disty/y;
        }
        sum += (double) left/y;
        System.out.println(x/(y*sum));
        r.close();
    }
}