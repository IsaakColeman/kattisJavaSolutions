import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class DifferentDistances {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String[] in = r.readLine().split(" ", 5);
        do {
            double d1 = Math.abs(Double.parseDouble(in[0]) - Double.parseDouble(in[2]));
            double d2 = Math.abs(Double.parseDouble(in[1]) - Double.parseDouble(in[3]));
            double p = Double.parseDouble(in[4]);
            out.append(Math.pow(Math.pow(d1, p) + Math.pow(d2, p), 1.0/p));
            out.append("\n");
            in = r.readLine().split(" ", 5);
        } while(in.length > 1);
        System.out.print(out);
        r.close();
    }
}