import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.regex.Pattern;

class Beekeeper {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile("ee|uu|ii|oo|aa|yy");
        int n = Integer.parseInt(r.readLine());
        while(n != 0) {
            String fav = "";
            int best = 0;
            for(int i = 0; i < n; i++) {
                String word = r.readLine();
                Matcher m = p.matcher(word);
                int count = 0;
                while(m.find()) {
                    count++;
                }
                if(count >= best) {
                    best = count;
                    fav = word;
                }
            }
            System.out.println(fav);
            n = Integer.parseInt(r.readLine());
        }
        r.close();
    }
}