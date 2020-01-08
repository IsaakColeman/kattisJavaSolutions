import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class AirConditioned implements Comparable {
    public int low;
    public int high;

    public AirConditioned(String[] in) {
        this.low = Integer.parseInt(in[0]);
        this.high = Integer.parseInt(in[1]);
    }

    @Override
    public int compareTo(Object o) {
        AirConditioned ACM = (AirConditioned) o;
        return this.low == ACM.low ? this.high - ACM.high : this.low - ACM.low;
    }
    
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        AirConditioned[] ACM = new AirConditioned[n];
        for(int i = 0; i < n; i++) {
            ACM[i] = new AirConditioned(r.readLine().split(" "));
        }
        Arrays.sort(ACM);
        int temp = 0;
        int rooms = 0;
        for(int i = 0; i < n; i++) {
            if(temp < ACM[i].low) {
                rooms++;
                temp = ACM[i].high;
            } else if(temp > ACM[i].high) {
                temp = ACM[i].high;
            }
        }
        System.out.println(rooms);
    }
}