import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class AliceDigital {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(r.readLine());
        for(int k = 0; k < cases; k++) {
            String[] input = r.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            input = r.readLine().split(" ");
            boolean valid = false;
            int pre = 0;
            int weight = 0;
            int best = 0;
            for(int i = 0; i < n; i++) {
                int temp = Integer.parseInt(input[i]);
                if(temp >= m) {
                    if(temp == m) {
                        if(valid) {
                            if(weight > best) {
                                best = weight;
                            }
                            weight -= pre;
                        } else {
                            pre = weight;
                            weight += temp;
                            valid = true;
                        }
                    } else {
                        weight += temp;
                    }
                } else if(valid) {
                    if(weight > best) {
                        best = weight;
                    }
                    pre = 0;
                    weight = 0;
                    valid = false;
                } else {
                    pre = 0;
                    weight = 0;
                    valid = false;
                }
            }
            if(valid) {
                if(weight > best) {
                    best = weight;
                }
            }
            System.out.println(best);
        }
        r.close();
    }
}