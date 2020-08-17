import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Espressobucks {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        char[] last = r.readLine().toCharArray();
        StringBuilder out = new StringBuilder((m+1)*(n+1));
        if(last[0] == '.') {
            last[0] = 'E';
        }
        for(int i = 1; i < m; i++) {
            if(last[i] == '.' && last[i-1] != 'E') {
                last[i] = 'E';
            }
        }
        out.append(String.valueOf(last) + "\n");
        for(int j = 1; j < n; j++) {
            char[] next = r.readLine().toCharArray();
            if(next[0] == '.' && last[0] != 'E') {
                next[0] = 'E';
            }
            for(int i = 1; i < m; i++) {
                if(next[i] == '.' && last[i] != 'E' && next[i-1] != 'E') {
                    next[i] = 'E';
                }
            }
            out.append(String.valueOf(next) + "\n");
            last = next;
        }
        System.out.print(out);
        r.close();
    }
}