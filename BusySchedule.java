import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Arrays;

class BusySchedule implements Comparable {
    String time;
    int pm;
    int t;

    public BusySchedule(String s) {
        this.time = s + '\n';
        String[] in = s.split("[ :]");
        this.t = Integer.parseInt(in[0])*60 + Integer.parseInt(in[1]);
        if(in[2].equals("p.m.")) {
            this.pm = 1;
        } else {
            this.pm = 0;
        }
        if(this.t >= 720) {
            this.t -= 720;
        }
    }

    @Override
    public int compareTo(Object o) {
        BusySchedule b = (BusySchedule) o;
        return this.t + 720*this.pm - b.t - 720*b.pm;
    }

    @Override
    public String toString() {
        return this.time;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        while(n > 0) {
            BusySchedule[] stuff = new BusySchedule[n];
            StringBuilder out = new StringBuilder();
            for(int i = 0; i < n; i++) {
                stuff[i] = new BusySchedule(r.readLine());
            }
            Arrays.sort(stuff);
            for(int i = 0; i < n; i++) {
                out.append(stuff[i]);
            }
            System.out.println(out);
            n = Integer.parseInt(r.readLine());
        }
        r.close();
    }
}