import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.StringBuilder;

class FastFood {
    int[] stickers;
    int prize;

    public FastFood(String[] in) {
        this.stickers = new int[Integer.parseInt(in[0])];
        int i = 0;
        while(i < this.stickers.length) {
            this.stickers[i++] = Integer.parseInt(in[i]) -1;
        }
        this.prize = Integer.parseInt(in[++i]);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 4);
        for(int k = 0; k < t; k++) {
            String[] in = r.readLine().split(" ");
            int total = 0;
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            FastFood[] prizes = new FastFood[n];
            for(int i = 0; i < n; i++) {
                prizes[i] = new FastFood(r.readLine().split(" "));
            }
            in = r.readLine().split(" ");
            int[] stickers = new int[m];
            for(int i = 0; i < m; i++) {
                stickers[i] = Integer.parseInt(in[i]);
            }
            for(int i = 0; i < n; i++) {
                int min = Integer.MAX_VALUE;
                for(int j : prizes[i].stickers) {
                    if(stickers[j] < min) {
                        min = stickers[j];
                    }
                }
                total += min*prizes[i].prize;
            }
            out.append(total + "\n");
        }
        System.out.print(out);
        r.close();
    }
}