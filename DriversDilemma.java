import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class DriversDilemma {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        double c = Double.parseDouble(in[0])/2;
        double x = Double.parseDouble(in[1]);
        double d = Double.parseDouble(in[2]);
        Integer speed = null;
        for(int i = 0; i < 6; i++) {
            in = r.readLine().split(" ");
            int s = 55+5*i;
            double e = Double.parseDouble(in[1]);
            if(d*x/s + d/e <= c) {
                speed = s;
            }
        }
        if(speed == null) {
            System.out.println("NO");
        } else {
            System.out.printf("YES %d\n", speed);
        }
        r.close();
    }
}