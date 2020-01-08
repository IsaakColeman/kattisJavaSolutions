import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BCE {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        if(Long.parseLong(in[0]) < 1l << (Integer.parseInt(in[1]) +1)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        r.close();
    }
}