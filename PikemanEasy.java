import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class PikemanEasy {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int t = Integer.parseInt(in[1]);
        in = r.readLine().split(" ");
        long a = Long.parseLong(in[0]);
        long b = Long.parseLong(in[1]);
        long c = Long.parseLong(in[2]);
        long t0 = Long.parseLong(in[3]);
        int[] problems = new int[n];
        for(int i = 0; i < n; i++) {
            problems[i] = (int)t0;
            t0 = (a*t0 + b)%c +1;
        }
        Arrays.sort(problems);
        long penalty = 0l;
        int time = 0;
        int i = 0;
        while(i < problems.length && time + problems[i] <= t) {
            time += problems[i];
            i++;
            penalty += time;
            if(penalty >= 1000000007) {
                penalty = penalty%1000000007;
            }
        }
        System.out.printf("%d %d\n", i, penalty);
        r.close();
    }
}