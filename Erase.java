import java.io.Reader;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Erase {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        if((Integer.parseInt(r.readLine()) & 1) == 1) {
            char[] in = r.readLine().toCharArray();
            char[] out = r.readLine().toCharArray();
            int i;
            for(i = 0; i < in.length; i++) {
                if(in[i] == out[i]) {
                    System.out.print("Deletion failed\n");
                    break;
                }
            }
            if(i == in.length) {
                System.out.print("Deletion succeeded\n");
            }
        } else {
            if(r.readLine().equals(r.readLine())) {
                System.out.print("Deletion succeeded\n");
            } else {
                System.out.print("Deletion failed\n");
            }
        }
        r.close();
    }
}