import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.ArrayList;

class EenyMeeny {

    public static void print(StringBuilder out, ArrayList<String> p) {
        out.append(p.size());
        out.append("\n");
        for(String s : p) {
            out.append(s);
            out.append("\n");
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] rhyme = r.readLine().split(" ");
        int j = rhyme.length;
        int n = Integer.parseInt(r.readLine());
        ArrayList<String> players = new ArrayList<String>(n);
        for(int i = 0; i < n; i++) {
            players.add(r.readLine());
        }
        ArrayList<String> a = new ArrayList<String>(n);
        ArrayList<String> b = new ArrayList<String>(n);
        int i = 0;
        while(players.size() > 1) {
            i = (i+j-1)%players.size();
            a.add(players.remove(i));
            i = (i+j-1)%players.size();
            b.add(players.remove(i));
        }
        if(players.size() == 1) {
            a.add(players.remove(0));
        }
        StringBuilder out = new StringBuilder(n << 4);
        print(out, a);
        print(out, b);
        System.out.print(out);
        r.close();
    }
}