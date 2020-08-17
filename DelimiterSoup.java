import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

class DelimiterSoup {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        int n = Integer.parseInt(r.readLine());
        char[] in = r.readLine().toCharArray();
        int i;
        for(i = 0; i < n; i++) {
            if(in[i] == ' ') {
                continue;
            } else if(in[i] == '(') {
                stack.push(')');
            } else if(in[i] == '[' || in[i] == '{') {
                stack.push((char) (in[i] +2));
            } else if(stack.peek() == null || in[i] != stack.poll()) {
                System.out.println(String.format("%c %d", in[i], i));
                break;
            }
        }
        if(i == n) {
            System.out.println("ok so far");
        }
        r.close();
    }
}