import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Friday {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        //String[] in;
        String[] days;
        int day;
        int off;
        int count;
        StringBuilder out = new StringBuilder(t << 2);
        for(int i = 0; i < t; i++) {
            off = 0;
            count = 0;
            r.readLine(); //in = r.readLine().split(" ");
            days = r.readLine().split(" ");
            for(String s : days) {
                day = Integer.parseInt(s);
                if(off == 0 && day >= 13) {
                    count++;
                }
                off = (off+day)%7;
            }
            out.append(count + "\n");
        }
        System.out.print(out);
        r.close();
    }
}