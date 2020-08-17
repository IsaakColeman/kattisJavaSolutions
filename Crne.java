import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Crne {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(r.readLine()) +2;
        System.out.println((n/2)*(n-n/2));
    }
}