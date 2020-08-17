import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.PriorityQueue;

class ClosingTheLoop {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 5);
        for(int i = 1; i <= t; i++) {
            PriorityQueue<Integer> red = new PriorityQueue<Integer>(t, (x,y) -> y - x);
            PriorityQueue<Integer> blue = new PriorityQueue<Integer>(t, (x,y) -> y - x);
            int n = Integer.parseInt(r.readLine());
            String[] inl = r.readLine().split(" ", n);
            for(String in : inl) {
                if(in.charAt(in.length() -1) == 'B') {
                    blue.add(Integer.parseInt(in.substring(0, in.length()-1)));
                } else {
                    red.add(Integer.parseInt(in.substring(0, in.length()-1)));
                }
            }
            Integer b = blue.poll();
            Integer re = red.poll();
            int count = 0;
            while(b != null && re != null) {
                count += b + re -2;
                b = blue.poll();
                re = red.poll();
            }
            out.append(String.format("Case #%d: %d\n", i, count));
        }
        System.out.print(out);
        r.close();
    }
}