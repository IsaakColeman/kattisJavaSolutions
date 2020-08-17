import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class HotHike {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] in = r.readLine().split(" ");
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(in[i]);
        }
        int min = Integer.MAX_VALUE;
        int day = 0;
        for(int i = 0; i < n-2; i++) {
            int t = Math.max(temp[i], temp[i+2]);
            if(t < min) {
                min = t;
                day = i;
            }
        }
        System.out.printf("%d %d\n", day+1, min);
        r.close();
    }
}