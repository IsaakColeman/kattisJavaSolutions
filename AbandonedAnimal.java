import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Vector;

class AbandonedAnimal {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        boolean more = true;
        Vector<HashSet<String>> stores = new Vector<HashSet<String>>(n);
        for(int i = 0; i < n; i++) {
            stores.add(new HashSet<String>());
        }
        n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; i++) {
            String[] input = r.readLine().split(" ");
            stores.get(Integer.parseInt(input[0])).add(input[1]);
        }
        n = Integer.parseInt(r.readLine());
        String[] items = new String[n];
        int[] first = new int[n+2];
        for(int i = 0; i < n; i++) {
            items[i] = r.readLine();
            int j = first[i];
            while(j < stores.size() && !stores.get(j).contains(items[i])) {
                j++;
            }
            if(j >= stores.size()) {
                System.out.println("impossible");
                more = false;
                break;
            } else {
                first[i+1] = j;
            }
        }
        first[n+1] = stores.size() -1;
        if(more) {
            for(int i = n-1; i >= 0 && more; i--) {
                for(int j = first[i+1]+1; j <= first[i+2]; j++) {
                    if(stores.get(j).contains(items[i])) {
                        System.out.println("ambiguous");
                        more = false;
                        break;
                    }
                }
            }
        }
        if(more) {
            System.out.println("unique");
        }
        r.close();
    }
}