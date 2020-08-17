import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Communication {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 3);
        String[] in = r.readLine().split(" ", t);
        for(int i = 0; i < t; i++) {
            int[] b = new int[8];
            int n = Integer.parseInt(in[i]);
            for(int j = 7; j >= 0; j--) {
                b[j] = n & 1;
                n >>>= 1;
            }
            for(int j = 6; j >= 0; j--) {
                b[j] = b[j+1] ^ b[j];
            }
            int sum = 0;
            for(int j = 0; j < 8; j++) {
                sum += b[7-j] << j;
            }
            out.append(sum + " ");
        }
        System.out.println(out);
        r.close();
    }
}