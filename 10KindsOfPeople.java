import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class KindsOfPeople {
    int x;
    int y;
    int[][] graph;

    public KindsOfPeople(int x, int y, BufferedReader r) throws IOException {
        this.x = x;
        this.y = y;
        this.graph = new int[y][x];
        for(int i = 0; i < y; i++) {
            char[] line = r.readLine().toCharArray();
            for(int j = 0; j < x; j++) {
                this.graph[i][j] = line[j] == '0' ? 0 : 1;
            }
        }
        createCon();
    }

    private void createCon() {
        for(int i = 0; i < this.x*this.y; i++) {
            if(this.atPoint(i) == 0 || this.atPoint(i) == 1) {
                checkCon(i, i+2, this.atPoint(i));
            }
        }
    }

    public void checkCon(int point, int group, int look) {
        this.graph[point/x][point%x] = look == 0 ? group : -1*group;
        if((point+1)%x != 0 && look == atPoint(point+1)) {
            checkCon(point+1, group, look);
        }
        if(point+x < x*y && look == atPoint(point+x)) {
            checkCon(point+x, group, look);
        }
        if(point%x != 0 && look == atPoint(point-1)) {
            checkCon(point-1, group, look);
        }
        if(point-x >= 0 && look == atPoint(point-x)) {
            checkCon(point-x, group, look);
        }
    }

    public int atPoint(int point) {
        return this.graph[point/x][point%x];
    }

    public void printG() {
        System.out.println();
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int x = Integer.parseInt(in[1]);
        int y = Integer.parseInt(in[0]);
        KindsOfPeople con = new KindsOfPeople(x, y, r);
        int n = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(n << 4);
        for(int i = 0; i < n; i++) {
            in = r.readLine().split(" ");
            int p1 = con.graph[Integer.parseInt(in[0])-1][Integer.parseInt(in[1])-1];
            if(p1 == con.graph[Integer.parseInt(in[2])-1][Integer.parseInt(in[3])-1]) {
                if(p1 > 0) {
                    out.append("binary\n");
                } else {
                    out.append("decimal\n");
                }
            } else {
                out.append("neither\n");
            }
        }
        System.out.print(out);
        r.close();
    }
}