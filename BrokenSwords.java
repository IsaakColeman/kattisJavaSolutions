import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BrokenSwords {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] pieces = new int[2];
        char temp = '1' + '1';
        int n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; i++) {
            char[] in = r.readLine().toCharArray();
            pieces[0] += temp - in[0] - in[1];
            pieces[1] += temp - in[2] - in[3];
        }
        n = Math.min(pieces[0]/2, pieces[1]/2);
        int n2 = n << 1;
        System.out.printf("%d %d %d\n", n, pieces[0] - n2, pieces[1] - n2);
        r.close();
    }
}