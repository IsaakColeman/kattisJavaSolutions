import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

class Orchard {

    public static double work(int r, int g, int b, int y, int s, HashMap<Long, Double> sol) {
        long n = (((((((r << 4) +g) << 4) +b) << 4) +y) << 4) + s;
        Double temp = sol.get(n);
        if(temp != null) {
            return temp;
        } else {
            int c = 2;
            double sum = 0.0;
            if(r > 0) {
                sum += 2*prob(r -1, g, b, y, s, sol);
                c++;
                if(g > 0) {
                    sum += prob(r, g -1, b, y, s, sol);
                    c++;
                    if(b > 0) {
                        sum += prob(r, g, b -1, y, s, sol);
                        c++;
                        if(y > 0) {
                            sum += work(r, g, b, y -1, s, sol);
                            c++;
                        }
                    }
                }
            }
            sum = (prob(r, g, b, y, s -1, sol) + sum)/c;
            sol.put(n, sum);
            return sum;
        }
    }

    public static double prob(int r, int g, int b, int y, int s, HashMap<Long, Double> sol) {
        if(s <= 0) {
            return 0.0;
        } else {
            return sort(r, g, b, y, s, sol);
        }
    }

    public static double sort(int r, int g, int b, int y, int s, HashMap<Long, Double> sol) {
        if(g > r) {
            int temp = g;
            g = r;
            r = temp;
        }
        if(y > b) {
            int temp = y;
            y = b;
            b = temp;
        }
        if(b > r && b > g) {
            int temp = r;
            r = b;
            b = g;
            g = temp;
            if(y > g) {
                temp = g;
                g = y;
                y = b;
                b = temp;
            } else if(y > b) {
                temp = b;
                b = y;
                y = temp;
            }
        } else if(b > g) {
            int temp = g;
            g = b;
            b = temp;
            if(y > b) {
                temp = b;
                b = y;
                y = temp;
            }
        }
        return work(r, g, b, y, s, sol);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String[] in = re.readLine().split(" ");
        int r = Integer.parseInt(in[0]);
        int g = Integer.parseInt(in[1]);
        int b = Integer.parseInt(in[2]);
        int y = Integer.parseInt(in[3]);
        int s = Integer.parseInt(in[4]);
        HashMap<Long, Double> sol = new HashMap<Long, Double>();
        for(long i = 1l; i <= s; i++) {
            sol.put(i, 1.0);
        }
        System.out.println(prob(r, g, b, y, s, sol));
        re.close();
    }
}