import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class MapTiles2 {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        char[] in = r.readLine().toCharArray();
        int x = 0;
        int y = 0;
        int pow = 1;
        for(int i = in.length -1; i >= 0; i--) {
            switch(in[i]) {
                case '1' : x += pow; break;
                case '2' : y += pow; break;
                case '3' : x += pow; y += pow; break;
                default  :
            }
            pow <<= 1;
        }
        System.out.printf("%d %d %d", in.length, x, y);
        r.close();
    }
}