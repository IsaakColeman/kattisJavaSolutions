import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.StringBuilder;

class BusNumbers {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] bus = r.readLine().split(" ");
        int[] busn = new int[n];
        for(int i = 0; i < n; i++) {
            busn[i] = Integer.parseInt(bus[i]);
        }
        Arrays.sort(busn);
        int start = busn[0];
        int spot = busn[0];
        StringBuilder out = new StringBuilder();
        for(int i = 1; i < n; i++) {
            if(busn[i] == spot +1) {
                spot++;
            } else {
                if(start < spot-1) {
                    out.append(start + "-" + spot + " ");
                } else {
                    if(start != spot) {
                        out.append(start + " ");
                        out.append(spot + " ");
                    } else {
                        out.append(start + " ");
                    }
                }
                start = busn[i];
                spot = busn[i];
            }
        }
        if(start != spot) {
            if(start < spot-1) {
                out.append(start + "-" + spot + " ");
            } else {
                out.append(start + " ");
                out.append(spot + " ");
            }
        } else {
            out.append(spot + " ");
        }
        System.out.println(out);
        r.close();
    }
}