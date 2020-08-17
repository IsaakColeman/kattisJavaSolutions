import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

class Kafkaesque {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        int last = Integer.parseInt(r.readLine());
        int count = 1;
        for(int i = 1; i < t; i++) {
            int next = Integer.parseInt(r.readLine());
            if(next < last) {
                count++;
            }
            last = next;
        }
        System.out.println(count);
        r.close();
    }
}