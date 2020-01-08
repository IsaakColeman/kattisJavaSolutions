import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Bits {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; i++) {
            int max = 0;
            String input = r.readLine();
            for(int j = 1; j <= input.length(); j++) {
                int ones = Integer.bitCount(Integer.parseInt(input.substring(0, j)));
                if(ones > max) {
                    max = ones;
                }
            }
            System.out.println(max);
        }
    }
}