import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class FOC {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        while(!in[0].equals("0")) {
            int S = Integer.parseInt(in[0]);
            int x = Integer.parseInt(in[1]);
            int y = Integer.parseInt(in[2]);
            int dx = Integer.parseInt(in[3]);
            int dy = Integer.parseInt(in[4]);
            boolean repeat = true;
            int i;
            for(i = 0; i < 2003; i++) {
                if(!((y + i*dy)%S == 0 || (x + i*dx)%S == 0 || 0 == (((x + i*dx)/S)%2) - ((y + i*dy)/S)%2)) {
                    repeat = false;
                    break;
                }
            }
            if(!repeat) {
                System.out.printf("After %d jumps the flea lands at (%d, %d).\n", i, x + i*dx, y + i*dy);
            } else {
                System.out.println("The flea cannot escape from black squares.");
            }
            in = r.readLine().split(" ");
        }
        r.close();
    }
}