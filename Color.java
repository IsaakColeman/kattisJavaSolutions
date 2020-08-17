import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Color {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        if(n > 0) {
            int c = Integer.parseInt(in[1]);
            int d = Integer.parseInt(in[2]);
            in = r.readLine().split(" ");
            int[] socks = new int[n];
            for(int i = 0; i < n; i++) {
                socks[i] = Integer.parseInt(in[i]);
            }
            Arrays.sort(socks);
            int count = 1;
            int load = 0;
            int color = socks[0];
            for(int s : socks) {
                if(s <= color + d && load < c) {
                    load++;
                } else {
                    color = s;
                    load = 1;
                    count++;
                }
            }
            System.out.println(count);
        } else {
            System.out.println("0");
        }
        r.close();
    }
}