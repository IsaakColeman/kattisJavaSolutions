import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class FlowLayout {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder(20000);
        int m = Integer.parseInt(r.readLine());
        while(m != 0) {
            int total = 0;
            int xPos = 0;
            int maxy = 0;
            int maxx = 0;
            String[] in = r.readLine().split(" ");
            while(!in[0].equals("-1")) {
                int x = Integer.parseInt(in[0]);
                int y = Integer.parseInt(in[1]);
                xPos += x;
                if(xPos > m) {
                    total += maxy;
                    maxy = y;
                    xPos = x;
                } else {
                    if(y > maxy) {
                        maxy = y;
                    }
                    if(xPos > maxx) {
                        maxx = xPos;
                    }
                }
                in = r.readLine().split(" ");
            }
            total += maxy;
            out.append(String.format("%d x %d\n", maxx, total));
            m = Integer.parseInt(r.readLine());
        }
        System.out.print(out);
        r.close();
    }
}