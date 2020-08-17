import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class DBL {

    private static int gcd(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int p = Integer.parseInt(in[0]);
        int q = Integer.parseInt(in[1]);
        int t = p*q/gcd(p, q);
        if(t <= Integer.parseInt(in[2])) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        r.close();
    }
}