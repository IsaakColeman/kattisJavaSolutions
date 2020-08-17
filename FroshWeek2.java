import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class FroshWeek2 {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[] tasks = new int[n];
        in = r.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            tasks[i] = Integer.parseInt(in[i]);
        }
        int[] breaks = new int[m];
        in = r.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            breaks[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(tasks);
        Arrays.sort(breaks);
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < n && j < m) {
            if(tasks[i] <= breaks[j]) {
                count++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        System.out.println(count);
        r.close();
    }
}