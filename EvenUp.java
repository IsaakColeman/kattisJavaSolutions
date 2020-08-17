import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

class EvenUp {
    LinkedList<Boolean> s;

    public EvenUp() {
        this.s = new LinkedList<Boolean>();
    }

    public void add(boolean b) {
        if(this.s.size() > 0 && b == this.s.peek()) {
            this.s.poll();
            Boolean t = this.s.poll();
            if(t != null) {
                this.add(t);
            }
        } else {
            this.s.push(b);
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        EvenUp game = new EvenUp();
        String[] in = r.readLine().split(" ", n);
        for(int i = 0; i < n; i++) {
            game.add(Integer.parseInt(in[i])%2 == 0);
        }
        System.out.println(game.s.size());
        r.close();
    }
}