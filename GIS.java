import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class GIS {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(r.readLine());
        int count = 0;
        StringBuilder out = new StringBuilder(l << 2);
        String[] in = r.readLine().split(" ");
        int size = 0;
        int curr;
        for(int i = 0; i < l; i++) {
            if((curr = Integer.parseInt(in[i])) > size) {
                count++;
                out.append(curr + " ");
                size = curr;
            }
        }
        System.out.println(count);
        System.out.println(out);
        r.close();
    }
}