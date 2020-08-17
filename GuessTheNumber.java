import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class GuessTheNumber {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int guess = 500;
        int low = 1;
        int high = 1000;
        System.out.println(guess);
        String resp = r.readLine();
        while(!resp.equals("correct")) {
            if(resp.charAt(0) == 'l') {
                high = guess -1;
            } else {
                low = guess +1;
            }
            guess = (high + low) >> 1;
            System.out.println(guess);
            resp = r.readLine();
        }
        r.close();
    }
}