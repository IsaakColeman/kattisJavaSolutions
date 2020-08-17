import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Eligibility {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 5);
        for(int i = 0; i < t; i++) {
            String[] in = r.readLine().split("[ /]");
            out.append(in[0]);
            out.append(" ");
            if(Integer.parseInt(in[1]) >= 2010 || Integer.parseInt(in[4]) > 1990) {
                out.append("eligible\n");
            } else if(Integer.parseInt(in[7]) > 40) {
                out.append("ineligible\n");
            } else {
                out.append("coach petitions\n");
            }
        }
        System.out.print(out);
        r.close();
    }
}