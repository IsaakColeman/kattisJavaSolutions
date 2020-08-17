import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.lang.StringBuilder;
import java.io.IOException;

abstract class Target {
    abstract int hit(int x, int y);
}

class Circle extends Target {
    int x;
    int y;
    int r;

    public Circle(String[] in) {
        this.x = Integer.parseInt(in[1]);
        this.y = Integer.parseInt(in[2]);
        this.r = Integer.parseInt(in[3]) * Integer.parseInt(in[3]);
    }

    public int hit(int x, int y) {
        return (x - this.x)*(x - this.x) + (y - this.y)*(y - this.y) <= this.r ? 1 : 0;
    }
}

class Rect extends Target {
    int x1;
    int x2;
    int y1;
    int y2;

    public Rect(String[] in) {
        this.x1 = Integer.parseInt(in[1]);
        this.y1 = Integer.parseInt(in[2]);
        this.x2 = Integer.parseInt(in[3]);
        this.y2 = Integer.parseInt(in[4]);
    }

    public int hit(int x, int y) {
        return this.x1 <= x && this.x2 >= x && this.y1 <= y && this.y2 >= y ? 1 : 0;
    }
}

class HittingTargets {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        Vector<Target> targets = new Vector<Target>(n);
        for(int i = 0; i < n; i++) {
            String[] in = r.readLine().split(" ");
            if(in.length > 4) {
                targets.add(new Rect(in));
            } else {
                targets.add(new Circle(in));
            }
        }
        n = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(n << 2);
        for(int i = 0; i < n; i++) {
            int sum = 0;
            String[] in = r.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            for(Target t : targets) {
                sum += t.hit(x, y);
            }
            out.append(sum + "\n");
        }
        System.out.print(out);
        r.close();
    }
}