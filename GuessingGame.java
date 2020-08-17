import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class GuessingGame {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int guess = Integer.parseInt(r.readLine());
        while(guess != 0) {
            boolean possible = true;
            int low = 0;
            int high = 11;
            while(possible) {
                String response = r.readLine();
                switch(response) {
                    case "too low" : {
                        low = Math.max(low, guess);
                        break;
                    }
                    case "too high": {
                        high = Math.min(high, guess);
                        break;
                    }
                    default : {
                        if(guess <= low || guess >= high) {
                            out.append("Stan is dishonest\n");
                        } else {
                            out.append("Stan may be honest\n");
                        }
                        possible = false;
                    }
                }
                if(low + 1 >= high) {
                    out.append("Stan is dishonest\n");
                    possible = false;
                    while(!response.equals("right on")) {
                        response = r.readLine();
                    }
                }
                guess = Integer.parseInt(r.readLine());
            }
        }
        System.out.print(out);
        r.close();
    }
}