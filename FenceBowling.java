import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class FenceBowling {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int k = Integer.parseInt(in[0]);
        double w = Double.parseDouble(in[1]) /2;
        int l = Integer.parseInt(in[2]);
        int sum = 1;
        for(int i = 2; i <= k+1; i++) {
            sum += 1 << i;
        }
        sum -= 1 << k;
        System.out.println(Math.atan(l/(w*sum))*180/Math.PI);
        r.close();
    }
}