import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Cokolada {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int i = 0;
        int small = 0;
        int large = 0;
        while(n > 0) {
            if((n & 1) == 1) {
                small = i;
                large = i;
                i++;
                n >>= 1;
                break;
            }
            i++;
            n >>= 1;
        }
        while(n > 0) {
            if((n & 1) == 1) {
                large = i;
            }
            i++;
            n >>= 1;
        }
        System.out.printf("%d %d\n", 1 << (large == small ? large : ++large), large - small);
        r.close();
    }
}