import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.PriorityQueue;

class DoctorKattis implements Comparable {
    String name;
    int infection;
    int order;

    public DoctorKattis(String[] in, int i) {
        this.name = in[1];
        this.infection = Integer.parseInt(in[2]);
        this.order = i;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        DoctorKattis t = (DoctorKattis) o;
        return t.infection == this.infection ? this.order - t.order : t.infection - this.infection;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        DoctorKattis t = (DoctorKattis) obj;
        return this.name.equals(t.name) && this.infection == t.infection;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        HashMap<String, DoctorKattis> cats = new HashMap<String, DoctorKattis>();
        PriorityQueue<DoctorKattis> line = new PriorityQueue<DoctorKattis>();
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String[] in = r.readLine().split(" ");
            switch(in[0]) {
                case "0" : {
                    cats.put(in[1], new DoctorKattis(in, i));
                    line.add(new DoctorKattis(in, i));
                    break;
                }
                case "1" : {
                    DoctorKattis t = cats.get(in[1]);
                    t.infection += Integer.parseInt(in[2]);
                    line.add(t);
                    break;
                }
                case "2" : {
                    cats.remove(in[1]);
                    break;
                }
                default  : {
                    DoctorKattis t = line.poll();
                    while(t != null && !t.equals(cats.get(t.name))) {
                        t = line.poll();
                    }
                    if(t == null) {
                        out.append("The clinic is empty\n");
                    } else {
                        out.append(t.name + "\n");
                        line.add(t);
                    }
                }
            }
        }
        System.out.print(out);
        r.close();
    }
}