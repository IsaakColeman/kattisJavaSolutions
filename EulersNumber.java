import java.io.Reader;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class EulersNumber {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        double e = 1.0;
        double fact = 1.0;
        for(int i = 1; i <= n; i++) {
            fact *= i;
            e += 1.0/fact;
        }
        System.out.println(e);
        r.close();
    }
}