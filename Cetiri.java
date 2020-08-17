import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Cetiri {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int[] n = new int[3];
        for(int i = 0; i < 3; i++) {
            n[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(n);
        int s = (n[2] - n[1] - n[1] + n[0]);
        if(s > 0) {
            System.out.println(n[1] + n[1] - n[0]);
        } else if(s < 0) {
            System.out.println(n[0] + n[2] - n[1]);
        } else {
            System.out.println(n[2] + n[2] - n[1]);
        }
        r.close();
    }
}