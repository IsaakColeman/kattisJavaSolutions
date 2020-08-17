import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Howl {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(r.readLine() + "O");
        r.close();
    }
}