import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Astro {
    
    private static int gcd(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] flash1 = r.readLine().split(":");
        String[] flash2 = r.readLine().split(":");
        String[] time1 = r.readLine().split(":");
        String[] time2 = r.readLine().split(":");
        int diff = Integer.parseInt(flash2[0])*60 - Integer.parseInt(flash1[0])*60 + Integer.parseInt(flash2[1]) - Integer.parseInt(flash1[1]);
        int interval1 = Integer.parseInt(time1[0])*60 + Integer.parseInt(time1[1]);
        int interval2 = Integer.parseInt(time2[0])*60 + Integer.parseInt(time2[1]);
        int d = gcd(interval1, interval2);
        if(diff%d == 0) {
            if(interval1 > interval2) {
                int temp = interval1;
                interval1 = interval2;
                interval2 = temp;
                flash2 = flash1;
                diff *= -1;
            }
            int i = 0;
            while(true) {
                if((i*interval2 + diff)%interval1 == 0) {
                    int time = (i*interval2 + Integer.parseInt(flash2[0])*60 + Integer.parseInt(flash2[1]))%10080;
                    System.out.println(days[time / 1440]);
                    time = time % 1440;
                    System.out.printf("%02d:%02d", time/60, time%60);
                    break;
                }
                i++;
            }
        } else {
            System.out.println("Never");
        }
        r.close();
    }
}