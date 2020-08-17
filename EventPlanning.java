import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class EventPlanner {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int p = Integer.parseInt(in[1]);
        int m = Integer.parseInt(in[0]);
        int h = Integer.parseInt(in[2]);
        p /= m;
        int w = Integer.parseInt(in[3]);
        int least = ++p;
        for(int i = 0; i < h; i++) {
            int temp = Integer.parseInt(r.readLine());
            if(temp < least) {
                in = r.readLine().split(" ");
                for(int j = 0; j < w; j++) {
                    if(Integer.parseInt(in[j]) >= m) {
                        least = temp;
                        break;
                    }
                }
            } else {
                r.readLine();
            }
        }
        if(least != p) {
            System.out.println(m*least);
        } else {
            System.out.println("stay home");
        }
        r.close();
    }
}