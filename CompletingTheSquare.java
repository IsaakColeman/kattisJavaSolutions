import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CTS {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in1 = r.readLine().split(" ");
        String[] in2 = r.readLine().split(" ");
        String[] in3 = r.readLine().split(" ");
        int x1 = Integer.parseInt(in1[0]);
        int y1 = Integer.parseInt(in1[1]);
        int x2 = Integer.parseInt(in2[0]);
        int y2 = Integer.parseInt(in2[1]);
        int x3 = Integer.parseInt(in3[0]);
        int y3 = Integer.parseInt(in3[1]);
        if(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)) > ((x3-x2)*(x3-x2))+((y3-y2)*(y3-y2))) {
            // 3 is corner
            System.out.println((x2+x1-x3) + " " + (y2+y1-y3));
        } else if(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)) < ((x3-x2)*(x3-x2))+((y3-y2)*(y3-y2))) {
            // 1 is corner
            System.out.println((x3+x2-x1) + " " + (y3+y2-y1));
        } else {
            // 2 is corner
            System.out.println((x3+x1-x2) + " " + (y3+y1-y2));
        }
        r.close();
    }
}