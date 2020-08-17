import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CodeCleanups {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] in = r.readLine().split(" ");
        int dirt = 0;
        int clean = 1;
        int code = 1;
        int day = Integer.parseInt(in[0]);
        for(int i = 1; i < n; i++) {
            int temp = Integer.parseInt(in[i]);
            dirt += code*(temp-day);
            if(dirt >= 20) {
                dirt = 0;
                clean++;
                code = 1;
            } else {
                code++;
            }
            day = temp;
        }
        System.out.println(clean);
        r.close();
    }
}