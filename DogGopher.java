import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class DogGopher {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        double gx = Double.parseDouble(in[0]);
        double gy = Double.parseDouble(in[1]);
        double dx = Double.parseDouble(in[2]);
        double dy = Double.parseDouble(in[3]);
        boolean t = true;
        while(r.ready()) {
            in = r.readLine().split(" ");
            double hx = Double.parseDouble(in[0]);
            double hy = Double.parseDouble(in[1]);
            if(((gx - hx)*(gx - hx) + (gy - hy)*(gy - hy))*4 <= (dx - hx)*(dx - hx) + (dy - hy)*(dy - hy)) {
                t = false;
                System.out.printf("The gopher can escape through the hole at (%s,%s).\n", in[0], in[1]);
                break;
            }
        }
        if(t) {
            System.out.println("The gopher cannot escape.");
        }
        r.close();
    }
}