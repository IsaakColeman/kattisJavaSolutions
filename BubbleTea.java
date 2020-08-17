import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class BubbleTea {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        int[] teas = new int[t];
        String[] in = r.readLine().split(" ");
        for(int i = 0; i < t; i++) {
            teas[i] = Integer.parseInt(in[i]);
        }
        int top = Integer.parseInt(r.readLine());
        in = r.readLine().split(" ");
        int[] tops = new int[top];
        for(int i = 0; i < top; i++) {
            tops[i] = Integer.parseInt(in[i]);
        }
        int least = Integer.MAX_VALUE;
        for(int i = 0; i < t; i++) {
            in = r.readLine().split(" ");
            int k = Integer.parseInt(in[0]);
            for(int j = 1; j <= k; j++) {
                if(teas[i] + tops[Integer.parseInt(in[j])-1] < least) {
                    least = teas[i] + tops[Integer.parseInt(in[j])-1];
                }
            }
        }
        t = Integer.parseInt(r.readLine()) / least -1;
        if(t >= 0) {
            System.out.println(t);
        } else {
            System.out.println("0");
        }
        r.close();
    }
}