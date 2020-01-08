import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class AverageSpeed {

    private static int time(String[] s) {
        return (Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]))*60 + Integer.parseInt(s[2]);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int speed = 0;
        int distance = 0;
        int time = 0;
        boolean more = true;
        while(more) {
            String[] input = r.readLine().split("[: ]");
            int newTime = time(input);
            distance += (newTime - time)*speed;
            time = newTime;
            if(input.length == 4) {
                speed = Integer.parseInt(input[3]);
            } else {
                System.out.printf("%s:%s:%s %.2f km\n", input[0], input[1], input[2], distance/3600.0);
            }
            more = r.ready();
        }
        r.close();
    }
}