import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.StringBuilder;

class HardwoodSpecies implements Comparable {
    String name;
    int count;

    public HardwoodSpecies(String s) {
        this.name = s;
        this.count = 1;
    }

    @Override
    public int compareTo(Object o) {
        HardwoodSpecies h = (HardwoodSpecies) o;
        return this.name.compareTo(h.name);
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, HardwoodSpecies> trees = new HashMap<String, HardwoodSpecies>();
        int count = 0;
        int diff = 0;
        do {
            String tree = r.readLine();
            HardwoodSpecies temp = trees.get(tree);
            if(temp != null) {
                temp.count++;
            } else {
                trees.put(tree, new HardwoodSpecies(tree));
                diff++;
            }
            count++;
        } while(r.ready());
        HardwoodSpecies[] arr = new HardwoodSpecies[diff];
        StringBuilder out = new StringBuilder(diff << 7);
        Arrays.sort(trees.values().toArray(arr));
        for(HardwoodSpecies h : arr) {
            out.append(String.format("%s %f\n", h.name, 100.0*h.count/count));
        }
        System.out.print(out);
        r.close();
    }
}