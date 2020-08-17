import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class BondingRobots {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder(8192);
        String[] in = r.readLine().split(" ", 2);
        int x = Integer.parseInt(in[0]) -1;
        int y = Integer.parseInt(in[1]) -1;
        do {
            int n = Integer.parseInt(r.readLine());
            int rx = 0;
            int ry = 0;
            int tx = 0;
            int ty = 0;
            for(int i = 0; i < n; i++) {
                in = r.readLine().split(" ", 2);
                int diff = Integer.parseInt(in[1]);
                switch(in[0].charAt(0)) {
                    case 'u' : {
                        ry = Math.min(ry + diff, y);
                        ty += diff;
                        break;
                    }
                    case 'd' : {
                        ry = Math.max(ry - diff, 0);
                        ty -= diff;
                        break;
                    }
                    case 'l' : {
                        rx = Math.max(rx - diff, 0);
                        tx -= diff;
                        break;
                    }
                    default  : {
                        rx = Math.min(rx + diff, x);
                        tx += diff;
                    }
                }
            }
            out.append(String.format("Robot thinks %d %d\nActually at %d %d\n\n", tx, ty, rx, ry));
            in = r.readLine().split(" ", 2);
            x = Integer.parseInt(in[0]) -1;
            y = Integer.parseInt(in[1]) -1;
        } while(x != -1);
        System.out.print(out);
        r.close();
    }
}