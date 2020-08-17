import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.PriorityQueue;
import java.util.HashSet;


class Inter implements Comparable {
    int v;
    int c;

    public Inter(int v, int c) {
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Object o) {
        return this.c - ((Inter) o).c;
    }
}

class CrossCountry {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int s = Integer.parseInt(in[1]);
        Integer e = Integer.parseInt(in[2]);
        if(s == e) {
            System.out.println("0");
        } else {
            PriorityQueue<Inter> adj = new PriorityQueue<Inter>();
            HashSet<Integer> reached = new HashSet<Integer>(n);
            int[][] map = new int[n][n];
            reached.add(s);
            for(int i = 0; i < n; i++) {
                in = r.readLine().split(" ");
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(in[j]);
                }
            }
            for(int i = 0; i < n; i++) {
                adj.add(new Inter(i, map[s][i]));
            }
            Inter temp = adj.poll();
            while(true) {
                while(!reached.add(temp.v)) {
                    temp = adj.poll();
                }
                if(temp.v == e) {
                    System.out.println(temp.c);
                    break;
                }
                for(int i = 0; i < n; i++) {
                    adj.add(new Inter(i, map[temp.v][i] +temp.c));
                }
            }
        }
        r.close();
    }
}