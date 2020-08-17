import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class FreeFood {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        boolean[] days = new boolean[366];
        for(int i = 0; i < n; i++) {
            String[] in = r.readLine().split(" ");
            for(int j = Integer.parseInt(in[0]); j <= Integer.parseInt(in[1]); j++) {
                days[j] = true;
            }
        }
        int count = 0;
        for(int i = 1; i < 366; i++) {
            if(days[i]) {
                count++;
            }
        }
        System.out.println(count);
        r.close();
    }
}