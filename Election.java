import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

class Election {
    String party;
    int votes;

    public Election(String s) {
        this.party = s;
        this.votes = 0;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        HashMap<String, Election> can = new HashMap<String, Election>(n);
        for(int i = 0; i < n; i++) {
            can.put(r.readLine(), new Election(r.readLine()));
        }
        int v = Integer.parseInt(r.readLine());
        Election temp = null;
        for(int i = 0; i < v; i++) {
            temp = can.get(r.readLine());
            if(temp != null) {
                temp.votes++;
            }
        }
        boolean tie = true;
        int most = 0;
        String win = null;
        for(Election c : can.values()) {
            if(c.votes > most) {
                most = c.votes;
                win = c.party;
                tie = false;
            } else if(c.votes == most) {
                tie = true;
            }
        }
        if(tie) {
            System.out.println("tie");
        } else {
            System.out.println(win);
        }
        r.close();
    }
}