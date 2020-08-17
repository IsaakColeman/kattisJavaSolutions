import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

class CircuitMath {
    public static void and(ArrayDeque<Boolean> s) {
        boolean t1 = s.poll();
        s.push(s.poll() && t1);
    }

    public static void or(ArrayDeque<Boolean> s) {
        boolean t1 = s.poll();
        s.push(s.poll() || t1);
    }

    public static void neg(ArrayDeque<Boolean> s) {
        s.push(!s.poll());
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Boolean> s = new ArrayDeque<Boolean>();
        r.readLine();
        String[] in = r.readLine().split(" ");
        char[] prob = r.readLine().toCharArray();
        for(int i = 0; i < prob.length; i+=2) {
            switch(prob[i]) {
                case '*' : and(s); break;
                case '+' : or(s); break;
                case '-' : neg(s); break;
                default  : s.push(in[prob[i] - 'A'].equals("T"));
            }
        }
        if(s.poll()) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
        r.close();
    }
}