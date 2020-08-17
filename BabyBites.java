import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BabyBites {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean sane = true;
        int n = Integer.parseInt(r.readLine());
        String[] in = r.readLine().split(" ", n);
        int i = 0;
        while(i < n) {
            if(!in[i].equals("mumble") && Integer.parseInt(in[i]) != i+1) {
                sane = false;
                break;
            }
            i++;
        }
        if(sane) {
            System.out.println("makes sense");
        } else {
            System.out.println("something is fishy");
        }
        r.close();
    }
}