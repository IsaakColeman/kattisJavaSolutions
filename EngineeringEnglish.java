import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.HashSet;

class EngineeringEnglish {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String[] in = r.readLine().split(" ");
        HashSet<String> used = new HashSet<String>();
        for(String s : in) {
            if(used.add(s.toLowerCase())) {
                out.append(s + " ");
            } else {
                out.append(". ");
            }
        }
        out.append("\n");
        while(r.ready()) {
            in = r.readLine().split(" ");
            for(String s : in) {
                if(used.add(s.toLowerCase())) {
                    out.append(s + " ");
                } else {
                    out.append(". ");
                }
            }
            out.append("\n");
        }
        System.out.print(out);
        r.close();
    }
}