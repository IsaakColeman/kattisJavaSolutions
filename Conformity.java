import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

class Conformity {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        HashMap<String, Integer> shed = new HashMap<String, Integer>();
        int count = 0;
        int max = 1;
        for(int i = 0; i < n; i++) {
            String[] in = r.readLine().split(" ");
            Arrays.sort(in);
            String tempS = String.join("", in);
            Integer tempL = shed.get(tempS);
            if(tempL != null) {
                shed.put(tempS, ++tempL);
                if(max < tempL) {
                    max = tempL;
                }
            } else {
                shed.put(tempS, 1);
            }
        }
        for(Integer i : shed.values()) {
            if(i == max) {
                count += i;
            }
        }
        System.out.println(count);
        r.close();
    }
}