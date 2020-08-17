import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class GoatRope {

    public static double dist(int x1, int y1, int x2, int y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }
    
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ", 6);
        int gx = Integer.parseInt(in[0]);
        int gy = Integer.parseInt(in[1]);
        int x1 = Integer.parseInt(in[2]);
        int y1 = Integer.parseInt(in[3]);
        int x2 = Integer.parseInt(in[4]);
        int y2 = Integer.parseInt(in[5]);
        if(gx >= x1 && gx <= x2) {
            System.out.println(Math.min(Math.abs(y1 - gy), Math.abs(y2 - gy)));
        } else if(gy >= y1 && gy <= y2) {
            System.out.println(Math.min(Math.abs(x1 - gx), Math.abs(x2 - gx)));
        } else {
            System.out.println(Math.sqrt(Math.min(Math.min(dist(x1, y1, gx, gy), dist(gx, gy, x2, y2)), Math.min(dist(x1, y2, gx, gy), dist(x2, y1, gx, gy)))));
        }
        r.close();
    }
}