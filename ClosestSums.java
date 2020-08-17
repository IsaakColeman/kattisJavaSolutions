import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Collections;
import java.lang.StringBuilder;

class ClosestSums {

    public static int binS(int n, Vector<Integer> v, int s, int e) {
        if(s+1 == e) {
            return Math.abs(v.get(s) -n) < Math.abs(v.get(e) -n) ? v.get(s) : v.get(e);
        }
        int temp = v.get(s + (e-s)/2);
        if(temp == n) {
            return n;
        } else if(temp < n) {
            return binS(n, v, s + (e-s)/2, e);
        } else {
            return binS(n, v, s, s + (e-s)/2);
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean more = true;
        StringBuilder out = new StringBuilder();
        int k = 1;
        while(more) {
            out.append(String.format("Case %d:\n", k));
            int n = Integer.parseInt(r.readLine());
            Vector<Integer> ints = new Vector<Integer>();
            Vector<Integer> sums = new Vector<Integer>();
            ints.add(Integer.parseInt(r.readLine()));
            for(int i = 1; i < n; i++) {
                int temp = Integer.parseInt(r.readLine());
                for(int j : ints) {
                    sums.add(j + temp);
                }
                ints.add(temp);
            }
            Collections.sort(sums);
            int t = Integer.parseInt(r.readLine());
            for(int i = 0; i < t; i++) {
                int q = Integer.parseInt(r.readLine());
                out.append(String.format("Closest sum to %d is %d.\n", q, binS(q, sums, 0, sums.size()-1)));
            }
            more = r.ready();
            k++;
        }
        System.out.print(out);
        r.close();
    }
}