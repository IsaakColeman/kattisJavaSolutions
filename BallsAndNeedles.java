import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class BallsAndNeedles {
    HashMap<Integer,HashSet<Integer>> graph;

    public BallsAndNeedles() {
        this.graph = new HashMap<Integer,HashSet<Integer>>();
    }

    public void add(int start, int end) {
        if(!this.graph.containsKey(start)) {
            this.graph.put(start, new HashSet<Integer>());
        } if(!this.graph.containsKey(end)) {
            this.graph.put(end, new HashSet<Integer>());
        }
        this.graph.get(start).add(end);
        this.graph.get(end).add(start);
    }

    public boolean isCyclic() {
        HashSet<Integer> visited = new HashSet<Integer>();
        for(Integer v : this.graph.keySet()) {
            if(!visited.contains(v)) {
                if(findCycle(v, visited, -1)) {return true;}
            }
        }
        return false;
    }

    private boolean findCycle(int v, HashSet<Integer> visited, int p) {
        visited.add(v);
        int i;
        Iterator<Integer> iter = this.graph.get(v).iterator();
        while(iter.hasNext()) {
            i = iter.next();
            if(!visited.contains(i)) {
                if(findCycle(i, visited, v)) {return true;}
            } else if(i != p) {return true;}
        }
        return false;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BallsAndNeedles threeD = new BallsAndNeedles();
        BallsAndNeedles twoD = new BallsAndNeedles();
        for(int i = 0; i < n; i++) {
            int coord1 = (((in.nextInt() << 10) + in.nextInt()) << 10) + in.nextInt();
            int coord2 = (((in.nextInt() << 10) + in.nextInt()) << 10) + in.nextInt();
            if(coord1 != coord2) {
                threeD.add(coord1, coord2);
            }
            coord1 >>= 10; coord2 >>= 10;
            if(coord1 != coord2) {
                twoD.add(coord1, coord2);
            }
        }
        if(threeD.isCyclic()) {
            System.out.println("True closed chains");
        } else {
            System.out.println("No true closed chains");
        } if(twoD.isCyclic()) {
            System.out.println("Floor closed chains");
        } else {
            System.out.println("No floor closed chains");
        }
        in.close();
    }
}