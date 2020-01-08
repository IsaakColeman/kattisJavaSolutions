import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Baloni {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] input = r.readLine().split(" ");
        int[] arrows = new int[1000000];
        int count = 0;
        for(String s : input) {
            int balloon = Integer.parseInt(s);
            if(arrows[balloon] > 0) {
                arrows[balloon]--;
            } else {
                count++;
            }
            arrows[balloon-1]++;
        }
        System.out.println(count);
        r.close();
    }
}