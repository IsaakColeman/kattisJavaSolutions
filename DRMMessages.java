import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class DRMMessages {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] in = r.readLine().toCharArray();
        int rotate = 0;
        for(int i = 0; i < in.length >> 1; i++) {
            rotate += in[i] - 'A';
        }
        for(int i = 0; i < in.length >> 1; i++) {
            in[i] = a.charAt((in[i] - 'A' + rotate)%26);
        }
        rotate = 0;
        for(int i = in.length >> 1; i < in.length; i++) {
            rotate += in[i] - 'A';
        }
        for(int i = in.length >> 1; i < in.length; i++) {
            in[i] = a.charAt((in[i] - 'A' + rotate)%26);
        }
        char[] out = new char[in.length >> 1];
        for(int i = 0; i < out.length; i++) {
            out[i] = a.charAt((in[i] + in[i + out.length] - 'A' - 'A')%26);
        }
        System.out.println(String.valueOf(out));
        r.close();
    }
}