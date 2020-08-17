import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Doorman {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        char[] in = r.readLine().toCharArray();
        int m = 0;
        int w = 0;
        for(int i = 0; i < in.length; i++) {
            if(m >= w) {
                if(in[i] == 'W') {
                    w++;
                } else if(m - w < n) {
                    m++;
                } else if(i+1 < in.length && in[i+1] == 'W') {
                    w++;
                    in[i+1] = 'M';
                } else {
                    break;
                }
            } else {
                if(in[i] == 'M') {
                    m++;
                } else if(w - m < n) {
                    w++;
                } else if(i+1 < in.length && in[i+1] == 'M') {
                    m++;
                    in[i+1] = 'W';
                } else {
                    break;
                }
            }
        }
        System.out.println(m + w);
        r.close();
    }
}