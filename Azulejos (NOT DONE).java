import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.StringBuilder;


//TODO: it may be that smaller tile cost more, thus the rows should be mapped by price and then
// checked by size
class Azulejos implements Comparable {
    Integer id;
    int size;
    int price;

    public Azulejos(int i, int s, int p) {
        this.id = i;
        this.size = s;
        this.price = p;
    }

    @Override
    public int compareTo(Object o) {
        Azulejos a = (Azulejos) o;
        return this.price - a.price == 0 ? this.size - a.size : this.price - a.price;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] price = r.readLine().split(" ");
        String[] size = r.readLine().split(" ");
        Azulejos[] front = new Azulejos[n];
        Azulejos[] back = new Azulejos[n];
        for(int i = 0; i < n; i++) {
            back[i] = new Azulejos(i, Integer.parseInt(size[i]), Integer.parseInt(price[i]));
        }
        price = r.readLine().split(" ");
        size = r.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            front[i] = new Azulejos(i, Integer.parseInt(size[i]), Integer.parseInt(price[i]));
        }
        Arrays.sort(front);
        Arrays.sort(back);
        StringBuilder out1 = new StringBuilder();
        StringBuilder out2 = new StringBuilder();
        boolean fail = false;
        if(front[0].size < back[0].size) {
            out1.append(front[0]);
            out2.append(back[0]);
            for(int i = 1; i < n; i++) {
                if(front[i].size < back[i].size) {
                    out1.append(" " + front[i]);
                    out2.append(" " + back[i]);
                } else {
                    fail = true;
                    break;
                }
            }
        } else {
            fail = true;
        }
        if(fail) {
            System.out.println("impossible");
        } else {
            System.out.println(out1);
            System.out.println(out2);
        }
        r.close();
    }
}