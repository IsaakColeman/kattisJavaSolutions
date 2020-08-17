import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;

class Edge implements Comparable {
    int id;
    double cost;

    public Edge(int i, double c) {
        this.id = i;
        this.cost = c;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        if(this.cost > e.cost) {
            return 1;
        }
        if(this.cost < e.cost) {
            return -1;
        }
        return 0;
    }
}

class HCB {
    double x;
    double y;

    public HCB(String[] in) {
        this.x = Double.parseDouble(in[0]);
        this.y = Double.parseDouble(in[1]);
    }

    public static double dist(HCB a, HCB b) {
        return dist(a.x, a.y, b.x, b.y);
    }

    public static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        HCB start = new HCB(r.readLine().split(" ", 2));
        HCB end = new HCB(r.readLine().split(" ", 2));
        int n = Integer.parseInt(r.readLine());
        HCB[] cannons = new HCB[n];
        for(int i = 0; i < n; i++) {
            cannons[i] = new HCB(r.readLine().split(" ", 2));
        }
        HashSet<Integer> reached = new HashSet<Integer>(n +1);
        PriorityQueue<Edge> next = new PriorityQueue<Edge>(n*n +1);
        for(int i = 0; i < n; i++) {
            next.add(new Edge(i, dist(start, cannons[i])));
        }
        next.add(new Edge(n, dist(start, end)));
        while(true) {
            Edge path = next.poll();
            if(path.id == n) {
                System.out.println(path.cost/5);
                break;
            }
            reached.add(path.id);
            for(int i = 0; i < n; i++) {
                if(!reached.contains(i)) {
                    next.add(new Edge(i, path.cost + Math.abs(dist(cannons[path.id], cannons[i])-50)+10));
                }
            }
            next.add(new Edge(n, path.cost + Math.abs(dist(cannons[path.id], end)-50)+10));
        }
        r.close();
    }
}