import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.StringBuilder;

class ExamRedistribution implements Comparable {
    int tests;
    int room;

    public ExamRedistribution(int t, int r) {
        this.tests = t;
        this.room = r;
    }

    @Override
    public int compareTo(Object o) {
        ExamRedistribution e = (ExamRedistribution) o;
        return e.tests - this.tests;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] in = r.readLine().split(" ");
        ExamRedistribution[] exams = new ExamRedistribution[n];
        for(int i = 0; i < n; i++) {
            exams[i] = new ExamRedistribution(Integer.parseInt(in[i]), i);
        }
        Arrays.sort(exams);
        int pile = exams[0].tests;
        int i = 1;
        while(i < n && pile > 0) {
            pile -= exams[i++].tests;
        }
        if(pile > 0) {
            System.out.println("impossible");
        } else {
            StringBuilder out = new StringBuilder(n << 4);
            for(ExamRedistribution e : exams) {
                out.append(e.room+1);
                out.append(' ');
            }
            System.out.println(out);
        }
        r.close();
    }
}