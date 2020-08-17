import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Collections;
import java.lang.StringBuilder;

class CandyDivision {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Long d = Long.parseLong(r.readLine());
        Vector<Long> div = new Vector<Long>();
        for(Long i = 1l; i <= Math.sqrt(d); i++) {
            if(d%i == 0) {
                Long n = d/i;
                div.add(i-1);
                if(!n.equals(i)) {
                    div.add(n-1);
                }
            }
        }
        StringBuilder out = new StringBuilder();
        Collections.sort(div);
        for(Long i : div) {
            out.append(i + " ");
        }
        System.out.println(out);
        r.close();
    }
}