import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class iBoard {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        do {
            int zero = 0;
            int one = 0;
            char[] c = r.readLine().toCharArray();
            for(char ch : c) {
                Integer i = (int) ch;
                one += Integer.bitCount(i);
                zero += 7 - Integer.bitCount(i);
            }
            if(one%2 == 0 && zero%2 == 0) {
                out.append("free\n");
            } else {
                out.append("trapped\n");
            }
        } while(r.ready());
        System.out.print(out);
        r.close();
    }
}