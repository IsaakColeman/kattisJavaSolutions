import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.io.IOException;

class Hidden {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] need = new int[26];
        ArrayDeque<Integer> pass = new ArrayDeque<Integer>();
        String[] in = r.readLine().split(" ", 2);
        for(char c : in[0].toCharArray()) {
            need[c-'A']++;
            pass.add(c-'A');
        }
        for(char c : in[1].toCharArray()) {
            if(need[c-'A']-- > 0) {
                if(c-'A' != pass.poll()) {
                    pass.add(-1);
                    break;
                }
            }
        }
        if(pass.isEmpty()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        r.close();
    }
}