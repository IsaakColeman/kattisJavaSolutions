import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Measurement {
    public static double conv(String s) {
        switch(s.charAt(0)) {
            case 't' : return 1;
            case 'i' : return 1000;
            case 'f' : return s.charAt(1) == 'u' ? 7920000 : 12000;
            case 'y' : return 36000;
            case 'c' : return 792000;
            case 'm' : return 63360000;
            default  : return 190080000;
        }
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ", 4);
        System.out.println(Integer.parseInt(in[0])*conv(in[1])/conv(in[3]));
        r.close();
    }
}