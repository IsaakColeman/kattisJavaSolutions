import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ExectlyElectrical {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] start = r.readLine().split(" ");
        String[] end = r.readLine().split(" ");
        int diff = Integer.parseInt(r.readLine()) - Math.abs(Integer.parseInt(start[0]) - Integer.parseInt(end[0])) - Math.abs(Integer.parseInt(start[1]) - Integer.parseInt(end[1]));
        if(diff >= 0 && diff%2 == 0) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        r.close();
    }
}