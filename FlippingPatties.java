import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class FlippingPatties {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] actions = new int[43201];
        int n = Integer.parseInt(r.readLine());
        int min = 0;
        for(int i = 0; i < n; i++) {
            String[] in = r.readLine().split(" ");
            int t = Integer.parseInt(in[1]);
            int d = Integer.parseInt(in[0]);
            if(min < ++actions[t]) {
                min = actions[t];
            }
            if(min < ++actions[t-d]) {
                min = actions[t-d];
            }
            if(min < ++actions[t-d-d]) {
                min = actions[t-d-d];
            }
        }
        System.out.println(min/2 + min%2);
        r.close();
    }
}