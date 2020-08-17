import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collections;
import java.lang.StringBuilder;

class CostumeContest implements Comparable {
    String name;
    int j;

    public CostumeContest(String n) {
        this.name = n;
        this.j = 1;
    }

    @Override
    public int compareTo(Object o) {
        CostumeContest c = (CostumeContest) o;
        return this.name.compareTo(c.name);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, CostumeContest> cats = new HashMap<String, CostumeContest>();
        int n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; i++) {
            String costume = r.readLine();
            CostumeContest temp = cats.get(costume);
            if(temp == null) {
                cats.put(costume, new CostumeContest(costume));
            } else {
                temp.j++;
            }
        }
        Vector<CostumeContest> out = new Vector<CostumeContest>();
        int min = n;
        for(CostumeContest c : cats.values()) {
            if(c.j < min) {
                min = c.j;
            }
        }
        for(CostumeContest c : cats.values()) {
            if(c.j == min) {
                out.add(c);
            }
        }
        Collections.sort(out);
        StringBuilder o = new StringBuilder();
        for(CostumeContest s : out) {
            o.append(s.name + "\n");
        }
        System.out.print(o);
        r.close();
    }
}