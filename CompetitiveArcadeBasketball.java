import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.HashMap;

class CAB {
    Integer points;
    boolean win;

    public CAB() {
        this.points = 0;
        this.win = false;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(in[0]);
        int s = Integer.parseInt(in[1]);
        HashMap<String, CAB> sb = new HashMap<String, CAB>(n);
        for(int i = 0; i < n; i++) {
            String temp = r.readLine();
            sb.put(temp, new CAB());
        }
        n = Integer.parseInt(in[2]);
        for(int i = 0; i < n; i++) {
            in = r.readLine().split(" ");
            if(!sb.get(in[0]).win) {
                sb.get(in[0]).points += Integer.parseInt(in[1]);
                if(sb.get(in[0]).points >= s) {
                    sb.get(in[0]).win = true;
                    out.append(in[0] + " wins!\n");
                }
            }
        }
        if(out.length() > 0) {
            System.out.print(out);
        } else {
            System.out.println("No winner!");
        }
        r.close();
    }
}