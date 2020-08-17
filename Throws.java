import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

class Throws {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = r.readLine().split(" ");
        String[] in = r.readLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<String>(Integer.parseInt(nk[1]));
        for(int i = 0; i < in.length; i++) {
            if(in[i].equals("undo")) {
                int m = Integer.parseInt(in[++i]);
                for(int j = 0; j < m; j++) {
                    stack.poll();
                }
            } else {
                stack.push(in[i]);
            }
        }
        int sum = 0;
        for(String s : stack) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum%Integer.parseInt(nk[0]) >= 0 ? sum%Integer.parseInt(nk[0]) : (sum%Integer.parseInt(nk[0])) + Integer.parseInt(nk[0]));
        r.close();
    }
}