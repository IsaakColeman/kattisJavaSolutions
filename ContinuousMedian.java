import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

class ContinuousMedian {
    Integer median;
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;


    public ContinuousMedian(int v) {
        this.median = v;
        this.left = new PriorityQueue<Integer>(5000, (x,y) -> y - x);
        this.right = new PriorityQueue<Integer>(5000);
    }
    public void insert(int v) {
        if(this.median <= v) {
            this.right.add(v);
            if(this.right.size() != this.left.size() && this.right.size() != this.left.size()+1) {
                this.left.add(this.median);
                this.median = this.right.poll();
            }
        } else {
            this.left.add(v);
            if(this.right.size() != this.left.size() && this.right.size() != this.left.size()+1) {
                this.right.add(this.median);
                this.median = this.left.poll();
            }
        }
    }

    public int median() {
        if(this.left.size() == this.right.size()) {
            return this.median;
        } else {
            return (this.median + this.right.peek()) >> 1;
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        for(int k = Integer.parseInt(r.readLine()); k > 0; k--) {
            int n = Integer.parseInt(r.readLine());
            String[] in = r.readLine().split(" ", n);
            int v = Integer.parseInt(in[0]);
            long count = v;
            ContinuousMedian arr = new ContinuousMedian(v);
            for(int i = 1; i < n; i++) {
                arr.insert(Integer.parseInt(in[i]));
                count += arr.median();
            }
            out.append(count + "\n");
        }
        System.out.print(out);
        r.close();
    }
}