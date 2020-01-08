import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

class Bees {
    static final double error = 0.000001;
    public double x;
    public double y;

    public Bees(double xpos, double ypos) {
        this.x = xpos;
        this.y = ypos;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.x);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) {return false;}
        Bees b = (Bees) obj;
        return this.x - b.x < error && b.x - this.x < error && this.y - b.y < error && b.y - this.y < error;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        Double d = in.nextDouble();
        int n = in.nextInt();
        while(n != 0) {
            ArrayList<Bees> hives = new ArrayList<Bees>();
            HashSet<Bees> sour = new HashSet<Bees>();
            for(int i = 0; i < n; i++) {
                double xpos = in.nextDouble();
                double ypos = in.nextDouble();
                for(Bees hive : hives) {
                    if(Math.pow(xpos - hive.x, 2.0) + Math.pow(ypos - hive.y, 2.0) <= d*d) {
                        sour.add(new Bees(xpos, ypos));
                        sour.add(hive);
                    }
                }
                hives.add(new Bees(xpos, ypos));
            }
            System.out.printf("%d sour, %d sweet\n", sour.size(), n - sour.size());
            d = in.nextDouble();
            n = in.nextInt();
        }
        in.close();
    }
}