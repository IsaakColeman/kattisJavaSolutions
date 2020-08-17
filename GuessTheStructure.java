import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

class GTS {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        do {
            int n = Integer.parseInt(r.readLine());
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>(n);
            ArrayDeque<Integer> queue = new ArrayDeque<Integer>(n);
            PriorityQueue<Integer> pri = new PriorityQueue<Integer>(n, (x, y) -> y - x);
            boolean s = true;
            boolean q = true;
            boolean p = true;
            for(int i = 0; i < n; i++) {
                String[] in = r.readLine().split(" ", 2);
                int temp = Integer.parseInt(in[1]);
                if(in[0].charAt(0) == '1') {
                    if(s) {
                        stack.push(temp);
                    }
                    if(q) {
                        queue.add(temp);
                    }
                    if(p) {
                        pri.add(temp);
                    }
                } else {
                    if(s && (stack.peek() == null || !stack.poll().equals(temp))) {
                        s = false;
                    }
                    if(q && (queue.peek() == null || !queue.poll().equals(temp))) {
                        q = false;
                    }
                    if(p && (pri.peek() == null || !pri.poll().equals(temp))) {
                        p = false;
                    }
                }
            }
            if(!s && !p && !q) {
                out.append("impossible\n");
            } else if(s && !p && !q) {
                out.append("stack\n");
            } else if(!s && p && !q) {
                out.append("priority queue\n");
            } else if(!s && !p && q) {
                out.append("queue\n");
            } else {
                out.append("not sure\n");
            }
        } while(r.ready());
        System.out.print(out);
        r.close();
    }
}