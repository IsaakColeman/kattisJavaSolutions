import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class EAoC {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder(40000);
        String[] in = r.readLine().split(" ", 3);
        while(!in[0].equals("0")) {
            double rad = Double.parseDouble(in[0]);
            int all = Integer.parseInt(in[1]);
            int hit = Integer.parseInt(in[2]);
            in = r.readLine().split(" ", 3);
            rad *= rad;
            out.append(String.format("%f %f\n", rad*Math.PI, rad*hit*4/all));
        }
        System.out.print(out);
        r.close();
    }
}