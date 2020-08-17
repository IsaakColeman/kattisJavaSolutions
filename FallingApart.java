import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

class FallingApart {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        PriorityQueue<Integer> num = new PriorityQueue<Integer>(n, (x,y) -> y - x);
        String[] in = r.readLine().split(" ", n);
        for(String s : in) {
            num.add(Integer.parseInt(s));
        }
        int a = 0;
        int b = 0;
        while(num.size() > 1) {
            a += num.poll();
            b += num.poll();
        }
        if(num.size() > 0) {
            a += num.poll();
        }
        System.out.printf("%d %d\n", a, b);
        r.close();
    }
}