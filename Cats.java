import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Vector;

class Edge implements Comparable {
    int v;
    int cost;

    public Edge(int v, int c) {
        this.v = v;
        this.cost = c;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        return this.cost - e.cost;
    }
}

class Cats {
    HashSet<Integer> reached;
    PriorityQueue<Edge> reachable;

    public Cats() {
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
            Vector<Vector<Edge>> Edges = new Vector<Vector<Edge>>();
            for(int i = 0; i < n; i++) {
                Edges.add(new Vector<Edge>());
            }
            for(int i = 0; i < n*(n-1)/2; i++) {
                in = r.readLine().split(" ");
                Edges.get(Integer.parseInt(in[0])).add(new Edge(Integer.parseInt(in[1]), Integer.parseInt(in[2])));
                Edges.get(Integer.parseInt(in[1])).add(new Edge(Integer.parseInt(in[0]), Integer.parseInt(in[2])));
            }
            Cats an = new Cats();
            int cost = 0;
            an.add(0, Edges.get(0));
            for(int i = 0; i < n-1; i++) {
                Edge temp = an.reachable.poll();
                while(an.reached.contains(temp.v)) {
                    temp = an.reachable.poll();
                }
                an.add(temp.v, Edges.get(temp.v));
                cost += temp.cost;
            }
            if(cost+n <= s) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        r.close();
    }
}