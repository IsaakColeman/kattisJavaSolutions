import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.TreeSet;

class KattisQuest2 implements Comparable {
    int e;
    int g;

    public KattisQuest2(String[] in) {
        this.e = Integer.parseInt(in[1]);
        this.g = Integer.parseInt(in[2]);
    }

    public KattisQuest2(int e) {
        this.e = e;
        this.g = Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(Object o) {
        KattisQuest2 k = (KattisQuest2) o;
        return this.e == k.e ? this.g - k.g : this.e - k.e;
    }

    @Override
    public String toString() {
        return String.valueOf(this.e + " " + this.g);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(c << 1);
        TreeSet<KattisQuest2> quests = new TreeSet<KattisQuest2>();
        for(int i = 0; i < c; i++) {
            String[] in = r.readLine().split(" ", 3);
            if(in[0].charAt(0) == 'a') {
                KattisQuest2 v = new KattisQuest2(in);
                quests.add(v);
            } else {
                int e = Integer.parseInt(in[1]);
                int g = 0;
                while(e > 0) {
                    KattisQuest2 temp = quests.floor(new KattisQuest2(e));
                    if(temp == null) {
                        break;
                    }
                    e -= temp.e;
                    g += temp.g;
                    quests.remove(temp);
                }
                out.append(g + "\n");
            }
            // System.out.print(quests);
        }
        System.out.print(out);
        r.close();
    }
}