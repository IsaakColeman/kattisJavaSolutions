import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class DrinkingSong {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String d = r.readLine();
        StringBuilder out = new StringBuilder(n << 7);
        for(int i = n; i >= 3; i--) {
            out.append(String.format("%d bottles of %s on the wall, %d bottles of %s.\nTake one down, pass it around, %d bottles of %s on the wall.\n\n",
            i, d, i, d, i-1, d));
        }
        if(n > 1) {
            out.append(String.format("2 bottles of %s on the wall, 2 bottles of %s.\nTake one down, pass it around, 1 bottle of %s on the wall.\n\n",
            d, d, d));
        }
        out.append(String.format("1 bottle of %s on the wall, 1 bottle of %s.\nTake it down, pass it around, no more bottles of %s.\n", d, d, d));
        System.out.print(out);
        r.close();
    }
}