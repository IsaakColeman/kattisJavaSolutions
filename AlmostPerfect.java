import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class AlmostPerfect {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        do {
            int d = Integer.parseInt(r.readLine());
            int div = 1;
            for(int i = 2; i <= Math.sqrt(d); i++) {
                if(d%i == 0) {
                    div += i;
                    if(d/i != i) {
                        div += d/i;
                    }
                }
                if(div > d+2) {
                    break;
                }
            }
            if(div <= d+2 && div >= d-2) {
                if(div == d) {
                    System.out.printf("%d perfect\n", d);
                } else {
                    System.out.printf("%d almost perfect\n", d);
                }
            } else {
                System.out.printf("%d not perfect\n", d);
            }
        } while(r.ready());
        r.close();
    }
}