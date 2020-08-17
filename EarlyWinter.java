import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class EarlyWinter {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int d = Integer.parseInt(in[1]);
        int i;
        in = r.readLine().split(" ");
        for(i = 0; i < n; i++) {
            if(Integer.parseInt(in[i]) <= d) {
                break;
            }
        }
        if(i == n) {
            System.out.println("It had never snowed this early!");
        } else if(i > 0) {
            System.out.printf("It hadn't snowed this early in %d years!\n", i);
        } else {
            System.out.println("It hadn't snowed this early in 0 years!");
        }
        r.close();
    }
}