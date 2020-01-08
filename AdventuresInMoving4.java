import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

class AIM4 {
    public int dist;
    public int price;

    public AIM4(String[] in) {
        this.dist = Integer.parseInt(in[0]);
        this.price = Integer.parseInt(in[1]);
    }

    public AIM4(int a, int b) {
        this.dist = a;
        this.price = b;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<AIM4> stations = new PriorityQueue<AIM4>(new Comparator<AIM4>() {
            @Override
            public int compare(AIM4 o1, AIM4 o2) {
                return o1.price - o2.price;
            }
        });
        int waterloo = Integer.parseInt(r.readLine());
        int cost = 0;
        int overfill = 0;
        boolean possible = true;
        AIM4 last = new AIM4(-100, 0);
        AIM4 next;
        while(r.ready() && possible) {
            next = new AIM4(r.readLine().split(" "));
            while(next.dist > last.dist + 200) {
                AIM4 temp = stations.poll();
                while(temp != null && temp.dist <= last.dist) {
                    temp = stations.poll();
                }
                if(temp == null) {
                    possible = false;
                    break;
                }
                cost += (200 - overfill)*last.price;
                overfill = 200 - temp.dist + last.dist;
                last = temp;
            }
            if(next.price <= last.price && last.dist < waterloo + 100) {
                cost += (next.dist - last.dist - overfill)*last.price;
                last = next;
                overfill = 0;
            } else {
                stations.add(next);
            }
        }
        while(possible && last.dist < waterloo - 100) {
            AIM4 temp = stations.poll();
            while(temp != null && temp.dist <= last.dist) {
                temp = stations.poll();
            }
            if(temp == null) {
                possible = false;
                break;
            }
            cost += (200 - overfill)*last.price;
            overfill = 200 - temp.dist + last.dist;
            last = temp;
        }
        cost += (waterloo + 100 - last.dist - overfill)*last.price;
        if(possible) {
            System.out.println(cost);
        } else {
            System.out.println("impossible");
        }
        r.close();
    }
}