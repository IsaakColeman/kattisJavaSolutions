import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class CuchiTunnels {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] in = r.readLine().split(" ");
        int open = Integer.parseInt(in[0]);
        int count = open +1;
        for(int i = 1; i < n && open > 0; i++) {
            int t = Integer.parseInt(in[i]) -1;
            count += t;
            open += t -1;
        }
        if(n == count && open == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        r.close();
    }
}