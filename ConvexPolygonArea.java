import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ConvexPolygonArea {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for(int k = Integer.parseInt(r.readLine()); k > 0; k--) {
            String[] in = r.readLine().split(" ");
            double area = 0.0;
            for(int i = 3; i < 2*(Integer.parseInt(in[0])-1); i+=2) {
                area += Math.abs((double)(Integer.parseInt(in[1])*(Integer.parseInt(in[i+1]) - Integer.parseInt(in[i+3])) +
                Integer.parseInt(in[i])*(Integer.parseInt(in[i+3]) - Integer.parseInt(in[2])) + 
                Integer.parseInt(in[i+2])*(Integer.parseInt(in[2]) - Integer.parseInt(in[i+1])))/2);
            }
            System.out.println(area);
        }
        r.close();
    }
}