import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.lang.StringBuilder;

class Height {
    public static int insert(Vector<Integer> arr, int e, int l, int h) {
        if(l >= h) {
            arr.add(h, e);
            return arr.size() - l - 1;
        } else {
            int mid = (l+h)/2;
            if(arr.get(mid) > e) {
                return insert(arr, e, l, mid);
            } else {
                return insert(arr, e, mid+1, h);
            }
        }
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(n << 3);
        for(int i = 1; i <= n; i++) {
            Vector<Integer> stu = new Vector<Integer>(20);
            int steps = 0;
            String[] in = r.readLine().split(" ");
            for(int j = 1; j <= 20; j++) {
                steps += insert(stu, Integer.parseInt(in[j]), 0, j-1);
            }
            out.append(in[0] + " " + steps + "\n");
        }
        System.out.print(out);
        r.close();
    }
}