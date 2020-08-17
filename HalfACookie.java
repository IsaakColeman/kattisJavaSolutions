import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class HalfACookie {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        do {
            String[] in = r.readLine().split(" ");
            double radius = Double.parseDouble(in[0]);
            double hyp = radius - Math.sqrt(Math.pow(Double.parseDouble(in[1]), 2) + Math.pow(Double.parseDouble(in[2]), 2));
            if(hyp > 0) {
                double area = radius*radius*Math.acos((radius-hyp)/radius) - (radius-hyp)*Math.sqrt(2*radius*hyp - hyp*hyp);
                out.append(String.format("%f %f\n", Math.PI*radius*radius - area, area));
            } else {
                out.append("miss\n");
            }
        } while(r.ready());
        System.out.print(out);
        r.close();
    }
}