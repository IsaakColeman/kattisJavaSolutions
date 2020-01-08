import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Birds {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int l = Integer.parseInt(in[0]);
        int d = Integer.parseInt(in[1]);
        int n = Integer.parseInt(in[2]);
        int start = 6 - d;
        l = l - 6;
        int count = 0;
        int[] birds = new int[n];
        for(int i = 0; i < n; i++) {
            birds[i] = Integer.parseInt(r.readLine());
        }
        Arrays.sort(birds);
        for(int i : birds) {
            count += (i - start - d)/d;
            start = i;
        }
        count += (l - start)/d;
        System.out.println(count);
        r.close();
    }
}