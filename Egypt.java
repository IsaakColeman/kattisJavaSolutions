import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Arrays;

class Egypt {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String[] in = r.readLine().split(" ");
        int[] num = new int[3];
        while(!in[0].equals("0")){
            num[0] = Integer.parseInt(in[0]);
            num[1] = Integer.parseInt(in[1]);
            num[2] = Integer.parseInt(in[2]);
            Arrays.sort(num);
            if(num[0]*num[0] + num[1]*num[1] == num[2]*num[2]) {
                out.append("right\n");
            } else {
                out.append("wrong\n");
            }
            in = r.readLine().split(" ");
        }
        System.out.print(out);
        r.close();
    }
}