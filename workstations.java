import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Iterator;

class Workstations implements Comparable{
    int start;
    int end;

    public Workstations(String[] in) {
        this.start = Integer.parseInt(in[0]);
        this.end = Integer.parseInt(in[0]) + Integer.parseInt(in[1]);
    }

    @Override
    public int hashCode() {
        return start;
    }

    @Override
    public int compareTo(Object o) {
        Workstations temp = (Workstations) o;
        return this.start == temp.start ? temp.end - this.end: this.start - temp.start;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        Workstations[] input = new Workstations[n];
        for(int i = 0; i < n; i++) {
            input[i] = new Workstations(r.readLine().split(" "));
        }
        Arrays.sort(input);
        PriorityQueue<Integer> times = new PriorityQueue<Integer>();
        int count = 0;
        for(Workstations w : input) {
            Integer temp = times.poll();
            while(temp != null ) {
                if(temp > w.start) {
                    times.add(temp);
                    break;
                } else if(temp >= w.start - m) {
                    count++;
                    break;
                }
                temp = times.poll();
            }
            times.add(w.end);
        }
        System.out.println(count);
        r.close();
    }
}