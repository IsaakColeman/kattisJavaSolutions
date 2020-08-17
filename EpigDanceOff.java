import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class EpigDanceOff {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int count = 1;
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]) -1;
        String[] dance = new String[n];
        for(int i = 0; i < n; i++) {
            dance[i] = r.readLine();
        }
        for(int i = 1; i < m; i++) {
            boolean frame = true;
            for(int j = 0; j < n; j++) {
                if(dance[j].charAt(i) == '$') {
                    frame = false;
                    break;
                }
            }
            if(frame) {
                count++;
            }
        }
        System.out.print(count);
        r.close();
    }
}