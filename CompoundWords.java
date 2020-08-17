import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.TreeSet;
import java.util.ArrayList;

class CompoundWords {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<String>();
        do {
            String[] in = r.readLine().split(" ");
            for(String w : in) {
                words.add(w);
            }
        } while(r.ready());
        TreeSet<String> comb = new TreeSet<String>();
        for(int i = 0; i < words.size(); i++) {
            String start = words.get(i);
            for(int j = 0; j < i; j++) {
                comb.add(start + words.get(j) + "\n");
            }
            for(int j = i+1; j < words.size(); j++) {
                comb.add(start + words.get(j) + "\n");
            }
        }
        StringBuilder out = new StringBuilder(comb.size() << 4);
        for(String s : comb) {
            out.append(s);
        }
        System.out.print(out);
        r.close();
    }
}