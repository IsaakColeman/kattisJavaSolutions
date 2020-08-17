import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class EightQueens {
    boolean[] x;
    boolean[] y;
    boolean[] n;
    boolean[] p;

    public EightQueens() {
        this.x = new boolean[8];
        this.y = new boolean[8];
        this.n = new boolean[15];
        this.p = new boolean[15];
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        EightQueens board = new EightQueens();
        boolean valid = true;
        int queens = 0;
        for(int i = 0; i < 8 && valid; i++) {
            char[] in = r.readLine().toCharArray();
            for(int j = 0; j < 8; j++) {
                if(in[j] == '*') {
                    if(board.x[j] || board.y[i] || board.n[7-i+j] || board.p[j+i]) {
                        valid = false;
                        break;
                    } else {
                        board.x[j] = true;
                        board.y[i] = true;
                        board.n[7-i+j] = true;
                        board.p[j+i] = true;
                        queens++;
                    }
                }
            }
        }
        if(valid && queens == 8) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
        r.close();
    }
}