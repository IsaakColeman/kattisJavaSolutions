import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BrowniePoints {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        while(n > 0) {
            String[][] points = new String[n/2][2];
            for(int i = 0; i < n/2; i++) {
                points[i] = r.readLine().split(" ");
            }
            String[] cross = r.readLine().split(" ");
            int x = Integer.parseInt(cross[0]);
            int y = Integer.parseInt(cross[1]);
            int counts = 0;
            int counto = 0;
            for(int i = 0; i < n/2; i++) {
                cross = r.readLine().split(" ");
                if(Integer.parseInt(points[i][0]) < x) {
                    if(Integer.parseInt(points[i][1]) < y) {
                        counts++;
                    } else if(Integer.parseInt(points[i][1]) > y) {
                        counto++;
                    }
                } else if(Integer.parseInt(points[i][0]) > x) {
                    if(Integer.parseInt(points[i][1]) > y) {
                        counts++;
                    } else if(Integer.parseInt(points[i][1]) < y) {
                        counto++;
                    }
                }
                if(Integer.parseInt(cross[0]) < x) {
                    if(Integer.parseInt(cross[1]) < y) {
                        counts++;
                    } else if(Integer.parseInt(cross[1]) > y) {
                        counto++;
                    }
                } else if(Integer.parseInt(cross[0]) > x) {
                    if(Integer.parseInt(cross[1]) > y) {
                        counts++;
                    } else if(Integer.parseInt(cross[1]) < y) {
                        counto++;
                    }
                }
            }
            System.out.printf("%d %d\n", counts, counto);
            n = Integer.parseInt(r.readLine());
        }
        r.close();
    }
}