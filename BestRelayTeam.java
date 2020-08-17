import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

class Team {
    BestRelayTeam[] t;

    public Team() {
        this.t = new BestRelayTeam[4];
    }

    public double time() {
        return t[0].t1 + t[1].t2 + t[2].t2 + t[3].t2;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(512);
        out.append(this.time());
        out.append("\n");
        out.append(t[0]);
        out.append("\n");
        out.append(t[1]);
        out.append("\n");
        out.append(t[2]);
        out.append("\n");
        out.append(t[3]);
        out.append("\n");
        return out.toString();
    }
}

class BestRelayTeam {
    String name;
    double t1;
    double t2;

    public BestRelayTeam(String[] in) {
        this.name = in[0];
        this.t1 = Double.parseDouble(in[1]);
        this.t2 = Double.parseDouble(in[2]);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((BestRelayTeam) obj).name.equals(this.name);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        PriorityQueue<BestRelayTeam> t1 = new PriorityQueue<BestRelayTeam>(n, (x,y) -> Double.compare(x.t1, y.t1));
        PriorityQueue<BestRelayTeam> t2 = new PriorityQueue<BestRelayTeam>(n, (x,y) -> Double.compare(x.t2, y.t2));
        Team[] teams = new Team[4];
        BestRelayTeam[] runners = new BestRelayTeam[4];
        for(int i = 0; i < 4; i++) {
            teams[i] = new Team();
        }
        for(int i = 0; i < n; i++) {
            BestRelayTeam temp = new BestRelayTeam(r.readLine().split(" "));
            t1.add(temp);
            t2.add(temp);
        }
        for(int i = 0; i < 4; i++) {
            teams[i].t[0] = t1.poll();
            runners[i] = t2.poll();
        }
        for(int i = 0; i < 4; i++) {
            int j = 0;
            int k = 1;
            while(k < 4) {
                if(!teams[i].t[0].equals(runners[j])) {
                    teams[i].t[k++] = runners[j];
                }
                j++;
            }
        }
        PriorityQueue<Team> best = new PriorityQueue<Team>(4, (x,y) -> Double.compare(x.time(), y.time()));
        for(Team t : teams) {
            best.add(t);
        }
        System.out.print(best.poll());
        r.close();
    }
}