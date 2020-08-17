import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ClimbingWorm {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int h = Integer.parseInt(in[2]);
        if(h > 0) {
            h -= Integer.parseInt(in[0]);
            if(h > 0) {
                System.out.println((int) Math.ceil(h/(Double.parseDouble(in[0]) - Integer.parseInt(in[1]))) +1);
            } else {
                System.out.println("1");
            }
        } else {
            System.out.println("0");
        }
        r.close();
    }
}