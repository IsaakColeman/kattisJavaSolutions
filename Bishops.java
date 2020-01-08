import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Bishops {
    
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean lines = true;
        while(lines) {
            int in = Integer.parseInt(r.readLine());
            if(in != 1) {
                System.out.println(in*2 -2);
            } else {
                System.out.println(1);
            }
            lines = r.ready();
        }
        r.close();
    }
}