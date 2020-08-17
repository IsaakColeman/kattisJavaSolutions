import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Compass {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(r.readLine());
        int n = Integer.parseInt(r.readLine());
        int diff = n - c;
        if(diff <= 180 && diff > -180) {
            System.out.println(diff);
        } else if(diff > 180) {
            System.out.println(diff - 360);
        } else {
            System.out.println(diff + 360);
        }
        r.close();
    }
}