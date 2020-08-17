import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BottledUp {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int s = Integer.parseInt(in[0]);
        int v1 = Integer.parseInt(in[1]);
        int v2 = Integer.parseInt(in[2]);
        int remain = s%v1;
        while(remain%v2 != 0 && remain <= s) {
            remain += v1;
        }
        if(remain > s) {
            System.out.println("impossible");
        } else {
            System.out.printf("%d %d", (s-remain)/v1, remain/v2);
        }
        r.close();
    }
}