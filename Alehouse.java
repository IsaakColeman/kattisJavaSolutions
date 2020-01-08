import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;

class Alehouse {
    public int low;
    public int high;

    public Alehouse(String[] in) {
        this.low = Integer.parseInt(in[0]);
        this.high = Integer.parseInt(in[1]);
    }
    
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] input = r.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        PriorityQueue<Alehouse> all = new PriorityQueue<Alehouse>(new Comparator<Alehouse>() {
            @Override
            public int compare(Alehouse o1, Alehouse o2) {
                return o1.low - o2.low;
            }
        });
        int most = 0;
        PriorityQueue<Integer> meet = new PriorityQueue<Integer>();
        for(int i = 0; i < n; i++) {
            all.add(new Alehouse(r.readLine().split(" ")));
        }
        Alehouse temp = all.poll();
        int low = temp.low;
        int high = low + k;
        while(temp != null) {
            if(temp.low > high) {
                if(meet.size() > most) {
                    most = meet.size();
                }

                Integer remove = meet.poll();
                low = temp.low - k;
                high = temp.low;
                while(remove != null && remove < low) {
                    remove = meet.poll();
                }
                if(remove != null) {
                    meet.add(remove);
                }
            }
            meet.add(temp.high);
            temp = all.poll();
        }
        if(meet.size() > most) {
            most = meet.size();
        }
        System.out.println(most);
    }
}