import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Abinitio {
    boolean[][] graph;
    int size;
    boolean trans;
    boolean inv;

    public Abinitio(int size, int max) {
        this.graph = new boolean[max][max];
        this.size = size;
        this.trans = false;
        this.inv = false;
    }

    public void addV() {
        if(this.inv) {
            for(int i = 0; i < this.size; i++) {
                this.graph[this.size][i] = true;
            }
            for(int i = 0; i < this.size; i++) {
                this.graph[i][this.size] = true;
            }
        }
        this.size++;
    }

    private void addS(int v, int i) {
        this.graph[v][i] = true;
    }

    public void addE(int v, int i) {
        if(this.trans) {
            this.graph[i][v] = !this.inv;
        } else {
            this.graph[v][i] = !this.inv;
        }
    }

    public void clear(int j) {
        for(int i = 0; i < this.size; i++) {
            this.graph[i][j] = this.inv;
        }
        for(int i = 0; i < this.size; i++) {
            this.graph[j][i] = this.inv;
        }
    }

    public void remove(int v, int i) {
        if(this.trans) {
            this.graph[i][v] = this.inv;
        } else {
            this.graph[v][i] = this.inv;
        }
    }

    public void transpose() {
        this.trans = !this.trans;
    }

    public void compliment() {
        this.inv = !this.inv;
    }

    public void finish() {
        StringBuilder out = new StringBuilder(this.size << 4);
        System.out.println(this.size);
        if(this.trans) {
            for(int i = 0; i < this.size; i++) {
                int count = 0;
                long temp = 0;
                long seven = 1l;
                for(int j = 0; j < this.size; j++) {
                    if(this.graph[j][i] != this.inv && i != j) {
                        count++;
                        temp += j*seven;
                        if(seven > 1000000007) {
                            seven = seven*7 %1000000007;
                        } else {
                            seven *= 7;
                        }
                    }
                }
                out.append(count + " " + temp%1000000007 + "\n");
            }
        } else {
            for(int i = 0; i < this.size; i++) {
                int count = 0;
                long temp = 0;
                long seven = 1l;
                for(int j = 0; j < this.size; j++) {
                    if(this.graph[i][j] != this.inv && i != j) {
                        count++;
                        temp += j*seven;
                        if(seven > 1000000007) {
                            seven = seven*7 %1000000007;
                        } else {
                            seven *= 7;
                        }
                    }
                }
                out.append(count + " " + temp%1000000007 + "\n");
            }
        }
        System.out.print(out);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ", 4);
        Abinitio graph = new Abinitio(Integer.parseInt(in[0]), Integer.parseInt(in[0]) + Integer.parseInt(in[2]));
        int e = Integer.parseInt(in[1]);
        int q = Integer.parseInt(in[2]);
        for(int i = 0; i < e; i++) {
            in = r.readLine().split(" ", 4);
            graph.addS(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
        }
        for(int i = 0; i < q; i++) {
            in = r.readLine().split(" ", 4);
            switch(in[0]) {
                case "1" : graph.addV(); break;
                case "2" : graph.addE(Integer.parseInt(in[1]), Integer.parseInt(in[2])); break;
                case "3" : graph.clear(Integer.parseInt(in[1])); break;
                case "4" : graph.remove(Integer.parseInt(in[1]), Integer.parseInt(in[2])); break;
                case "5" : graph.transpose(); break;
                default  : graph.compliment();
            }
        }
        graph.finish();
        r.close();
    }
}