import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashSet;

class Gold {
    int x;
    int y;

    public Gold(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (x << 7) + y; 
    }

    @Override
    public boolean equals(Object obj) {
        Gold g = (Gold) obj;
        return this.x == g.x && this.y == g.y;
    }

    public static char map(char c) {
        switch(c) {
            case 'G' : return 'F';
            case '.' : return '-';
            case 'P' : return 'O';
            default  : return c;
        }
    }
    
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ", 2);
        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);
        char[][] map = new char[y][x];
        for(int i = 0; i < y; i++) {
            map[i] = r.readLine().toCharArray();
        }
        for(int i = 1; i < y -1; i++) {
            for(int j = 1; j < x -1; j++) {
                if(map[i][j] == 'T') {
                    map[i-1][j] = map(map[i-1][j]);
                    map[i+1][j] = map(map[i+1][j]);
                    map[i][j-1] = map(map[i][j-1]);
                    map[i][j+1] = map(map[i][j+1]);
                }
            }
        }
        int sx = 0;
        int sy = 0;
        int gold = 0;
        for(int i = 1; i < y -1; i++) {
            for(int j = 1; j < x -1; j++) {
                if(map[i][j] == 'P') {
                    sy = i;
                    sx = j;
                }
            }
        }
        if(sx > 0) {
            LinkedList<Gold> next = new LinkedList<Gold>();
            HashSet<Gold> visit = new HashSet<Gold>(x*y);
            next.add(new Gold(sx, sy));
            Gold temp = next.poll();
            while(temp != null) {
                switch(map[temp.y][temp.x]) {
                    case '#' : break;
                    case '-' : break;
                    case 'F' : gold++; break;
                    case 'G' : gold++;
                    default  : {
                        Gold n = new Gold(temp.x -1, temp.y);
                        if(visit.add(n)) {
                            next.add(n);
                        }
                        n = new Gold(temp.x +1, temp.y);
                        if(visit.add(n)) {
                            next.add(n);
                        }
                        n = new Gold(temp.x, temp.y -1);
                        if(visit.add(n)) {
                            next.add(n);
                        }
                        n = new Gold(temp.x, temp.y +1);
                        if(visit.add(n)) {
                            next.add(n);
                        }
                    }
                }
                temp = next.poll();
            }
        }
        System.out.println(gold);
        r.close();
    }
}