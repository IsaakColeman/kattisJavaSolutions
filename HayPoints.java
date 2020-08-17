import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.lang.StringBuilder;

class HayPoints {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int w = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        HashMap<String, Integer> words = new HashMap<String, Integer>(w);
        StringBuilder out = new StringBuilder(n << 4);
        for(int i = 0; i < w; i++) {
            in = r.readLine().split(" ");
            words.put(in[0], Integer.parseInt(in[1]));
        }
        for(int i = 0; i < n; i++) {
            int sum = 0;
            String next = r.readLine();
            while(!next.equals(".")) {
                for(String s : next.split(" ")) {
                    Integer temp = words.get(s);
                    if(temp != null) {
                        sum += temp;
                    }
                }
                next = r.readLine();
            }
            out.append(sum + "\n");
        }
        System.out.print(out);
        r.close();
    }
}