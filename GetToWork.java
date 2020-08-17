import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

class GetToWork {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 10);
        for(int j = 1; j <= t; j++) {
            out.append(String.format("Case #%d: ", j));
            String[] in = r.readLine().split(" ");
            int h = Integer.parseInt(in[0]);
            int w = Integer.parseInt(in[1]);
            int e = Integer.parseInt(r.readLine());
            Vector<PriorityQueue<Integer>> employees = new Vector<PriorityQueue<Integer>>(h+1);
            int[] sum = new int[h+1];
            for(int i = 0; i <= h; i++) {
                employees.add(new PriorityQueue<Integer>((x, y) -> y - x));
            }
            for(int i = 0; i < e; i++) {
                in = r.readLine().split(" ");
                int p = Integer.parseInt(in[0]);
                employees.get(p).add(Integer.parseInt(in[1]));
                sum[p]++;
            }
            boolean possible = true;
            sum[w] = 0;
            for(int i = 1; i <= h; i++) {
                int target = sum[i];
                int cars = 0;
                PriorityQueue<Integer> drivers = employees.get(i);
                while(drivers.size() > 0 && target > 0) {
                    target -= drivers.poll();
                    cars++;
                }
                if(target <= 0) {
                    sum[i] = cars;
                } else {
                    possible = false;
                    break;
                }
            }
            if(possible) {
                for(int i = 1; i <= h; i++) {
                    out.append(sum[i] + " ");
                }
                out.append("\n");
            } else {
                out.append("IMPOSSIBLE\n");
            }
        }
        System.out.print(out);
        r.close();
    }
}