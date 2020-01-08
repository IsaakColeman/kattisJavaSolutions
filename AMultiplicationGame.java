import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class AMG {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean more = true;
        while(more) {
            long n = Long.parseLong(r.readLine());
            long p = 1;
            boolean stan = true;
            while(p < n) {
                if(stan) {
                    p*=9;
                } else {
                    p*=2;
                }
                stan = !stan;
            }
            if(stan) {
                System.out.println("Ollie wins.");
            } else {
                System.out.println("Stan wins.");
            }
            more = r.ready();
        }
        r.close();
    }
}