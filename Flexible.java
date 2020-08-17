import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.TreeSet;

class Flexible {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ", 2);
        int w = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        int[] div = new int[n+2];
        in = r.readLine().split(" ", n++);
        int i = 1;
        for(String s : in) {
            div[i++] = Integer.parseInt(s);
        }
        div[i] = w;
        TreeSet<Integer> part = new TreeSet<Integer>();
        for(i = 0; i <= n; i++) {
            int num = div[i];
            for(int j = i+1; j <= n; j++) {
                part.add(div[j] - num);
            }
        }
        StringBuilder out = new StringBuilder(part.size() << 4);
        for(Integer j : part) {
            out.append(j);
            out.append(" ");
        }
        System.out.println(out);
        r.close();
    }
}