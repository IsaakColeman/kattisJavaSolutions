import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Vector;
import java.util.Arrays;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable {
    int v;
    int cost;

    public Edge(int v, Point p1, Point p2) {
        this.v = v;
        this.cost = (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        return this.cost - e.cost;
    }
}

class ArcticNetwork {
    HashSet<Integer> reached;
    PriorityQueue<Edge> reachable;

    public ArcticNetwork() {
        this.reached = new HashSet<Integer>();
        this.reachable = new PriorityQueue<Edge>();
    }

    public void add(int v, Vector<Edge> ed) {
        for(Edge e : ed) {
            this.reachable.add(e);
        }
        this.reached.add(v);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        for(int j = 0; j < t; j++) {
            String[] in = r.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int n = Integer.parseInt(in[1]);
            Vector<Vector<Edge>> edges = new Vector<Vector<Edge>>(n);
            Point[] points = new Point[n];
            for(int i = 0; i < n; i++) {
                in = r.readLine().split(" ");
                points[i] = new Point(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
                Vector<Edge> temp = new Vector<Edge>(n);
                for(int k = 0; k < i; k++) {
                    edges.get(k).add(new Edge(i, points[k], points[i]));
                    temp.add(new Edge(k, points[k], points[i]));
                }
                edges.add(temp);
            }
            ArcticNetwork an = new ArcticNetwork();
            an.add(0, edges.get(0));
            int[] buy = new int[n-1];
            for(int i = 0; i < n-1; i++) {
                Edge temp = an.reachable.poll();
                while(an.reached.contains(temp.v)) {
                    temp = an.reachable.poll();
                }
                an.add(temp.v, edges.get(temp.v));
                buy[i] = temp.cost;
            }
            Arrays.sort(buy);
            System.out.printf("%.2f\n", Math.sqrt(buy[n-s-1]));
        }
        r.close();
    }
}