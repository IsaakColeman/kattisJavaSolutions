import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class CurseTheDarkness {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        String[] in;
        boolean light;
        StringBuilder out = new StringBuilder();
        for(int k = 0; k < t; k++) {
            light = false;
            in = r.readLine().split(" ");
            double bx = Double.parseDouble(in[0]);
            double by = Double.parseDouble(in[1]);
            int n = Integer.parseInt(r.readLine());
            int i = 0;
            while(i < n) {
                in = r.readLine().split(" ");
                double tx = Double.parseDouble(in[0]);
                double ty = Double.parseDouble(in[1]);
                if((tx - bx)*(tx - bx) + (ty - by)*(ty - by) <= 64.0) {
                    light = true;
                    i++;
                    break;
                }
                i++;
            } while(i < n) {
                r.readLine();
                i++;
            }
            if(light) {
                out.append("light a candle\n");
            } else {
                out.append("curse the darkness\n");
            }
        }
        System.out.print(out);
        r.close();
    }
}