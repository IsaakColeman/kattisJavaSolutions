import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CountingClauses {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        if(Integer.parseInt(in[0]) >= 8) {
            System.out.println("satisfactory");
        } else {
            System.out.println("unsatisfactory");
        }
        r.close();
    }
}