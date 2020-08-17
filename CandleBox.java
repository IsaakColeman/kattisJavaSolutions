import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CandleBox {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(r.readLine());
        int reta = Integer.parseInt(r.readLine());
        int total = reta + Integer.parseInt(r.readLine());
        int rR = 0;
        int tR = 0;
        for(int i = 4; rR + tR < total; i++) {
            rR += i;
            if(i-d >= 3) {
                tR += i-d;
            }
        }
        System.out.println(reta - rR);
        r.close();
    }
}