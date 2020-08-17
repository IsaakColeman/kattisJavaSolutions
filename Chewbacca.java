import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Chewbacca {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int k = Integer.parseInt(in[1]);
        int n = Integer.parseInt(in[2]);
        StringBuilder out = new StringBuilder(2*n);
        for(int i = 0; i < n; i++) {
            in = r.readLine().split(" ");
            long n1 = Long.parseLong(in[0]) -1;
            long n2 = Long.parseLong(in[1]) -1;
            if(n2 < n1) {
                long temp = n1;
                n1 = n2;
                n2 = temp;
            }
            Long count = 0l;
            while(n2 != n1) {
                n2 = (n2 -1)/k;
                if(n2 < n1) {
                    n1 = (n1 -1)/k;
                    count++;
                }
                count++;
            }
            out.append(count + "\n");
        }
        System.out.print(out);
        r.close();
    }
}