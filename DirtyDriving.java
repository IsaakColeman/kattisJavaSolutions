import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class DirtyDriving {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int p = Integer.parseInt(in[1]);
        int[] dist = new int[n];
        in = r.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            dist[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(dist);
        int front = dist[0];
        int most = p;
        for(int i = 1; i < n; i++) {
            if(p*(i+1) - dist[i] + front > most) {
                most = p*(i+1) - dist[i] + front;
            }
        }
        System.out.println(most);
        r.close();
    }
}