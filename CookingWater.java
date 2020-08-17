import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CookingWater {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        int e = Integer.MAX_VALUE;
        for(int k = Integer.parseInt(r.readLine()); k > 0; k--) {
            String[] in = r.readLine().split(" ");
            s = Math.max(s, Integer.parseInt(in[0]));
            e = Math.min(e, Integer.parseInt(in[1]));
        }
        if(s <= e) {
            System.out.println("gunilla has a point");
        } else {
            System.out.println("edward is right");
        }
        r.close();
    }
}