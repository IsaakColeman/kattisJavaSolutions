import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.lang.StringBuilder;

class Incognito {
    int value;

    public Incognito() {
        this.value = 2;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(t << 3);
        for(int j = 0; j < t; j++) {
            int n = Integer.parseInt(r.readLine());
            HashMap<String, Incognito> types = new HashMap<String, Incognito>(n);
            for(int i = 0; i < n; i++) {
                String[] in = r.readLine().split(" ", 2);
                Incognito temp = types.get(in[1]);
                if(temp != null) {
                    temp.value++;
                } else {
                    types.put(in[1], new Incognito());
                }
            }
            int sum = 1;
            for(Incognito k : types.values()) {
                sum *= k.value;
            }
            out.append(sum-1 + "\n");
        }
        System.out.print(out);
        r.close();
    }
}