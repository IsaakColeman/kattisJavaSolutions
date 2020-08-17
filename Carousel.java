import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Carousel {
    int a;
    int p;
    double r;

    public Carousel() {
        this.r = Double.MAX_VALUE;
    }

    public Carousel(String[] s) {
        this.a = Integer.parseInt(s[0]);
        this.p = Integer.parseInt(s[1]);
        this.r = (double) this.p / this.a;
    }

    @Override
    public String toString() {
        return String.format("Buy %d tickets for $%d", this.a, this.p);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        while(n != 0) {
            Carousel best = new Carousel();
            for(int i = 0; i < n; i++) {
                Carousel temp = new Carousel(r.readLine().split(" "));
                if(temp.a <= m && (temp.r < best.r || temp.r == best.r && temp.a > best.a)) {
                    best = temp;
                }
            }
            if(best.r < Double.MAX_VALUE) {
                System.out.println(best);
            } else {
                System.out.println("No suitable tickets offered");
            }
            in = r.readLine().split(" ");
            n = Integer.parseInt(in[0]);
            m = Integer.parseInt(in[1]);
        }
        r.close();
    }
}