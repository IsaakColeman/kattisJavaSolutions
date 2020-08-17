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
    int items;

    public Edge(int v, int c, int items) {
        this.v = v;
        this.cost = c;
        this.items = items;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        return this.cost - e.cost == 0 ? e.items - this.items : this.cost - e.cost;
    }
}

class Node {
    Vector<Edge> adj;

    public Node() {
        this.adj = new Vector<Edge>();
    }
}

class BigTruck {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] items = r.readLine().split(" ");
        int e = Integer.parseInt(r.readLine());
        Node[] graph = new Node[n];

        HashSet<Integer> reached = new HashSet<Integer>(n);
        PriorityQueue<Edge> reachable = new PriorityQueue<Edge>();

        for(int i = 0; i < n; i++) {
            graph[i] = new Node();
        }
        for(int i = 0; i < e; i++) {
            String[] in = r.readLine().split(" ");
            int a = Integer.parseInt(in[0]) -1;
            int b = Integer.parseInt(in[1]) -1;
            int c = Integer.parseInt(in[2]);
            graph[a].adj.add(new Edge(b, c, Integer.parseInt(items[b])));
            graph[b].adj.add(new Edge(a, c, Integer.parseInt(items[a])));
        }

        reached.add(0);
        for(Edge v : graph[0].adj) {
            reachable.add(v);
        }
        Edge temp = reachable.poll();
        while(true) {
            while(temp != null && !reached.add(temp.v)) {
                temp = reachable.poll();
            }
            if(temp == null || temp.v == n-1) {
                break;
            } else {
                for(Edge v : graph[temp.v].adj) {
                    if(!reached.contains(v.v)) {
                        reachable.add(new Edge(v.v, v.cost + temp.cost, v.items + temp.items));
                    }
                }
            }
        }
        if(temp == null) {
            System.out.println("impossible");
        } else {
            System.out.printf("%d %d", temp.cost, temp.items + Integer.parseInt(items[0]));
        }
        r.close();
    }
}