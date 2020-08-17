import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.*;

class HtoO {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] elem = new int[26];
        int[] need = new int[26];
        String[] in = r.readLine().split(" ");
        Pattern p = Pattern.compile("[A-Z]{1}[0-9]*");
        Matcher m = p.matcher(in[0]);
        int n = Integer.parseInt(in[1]);
        while(m.find()) {
            elem[m.group(0).charAt(0) - 'A'] += (m.group(0).length() > 1 ? Integer.parseInt(m.group(0).substring(1)) * n : n);
        }
        m = p.matcher(r.readLine());
        int min = Integer.MAX_VALUE;
        while(m.find()) {
            need[m.group(0).charAt(0) - 'A'] += (m.group(0).length() > 1 ? Integer.parseInt(m.group(0).substring(1)) : 1);
        }
        for(int i = 0; i < 26; i++) {
            if(need[i] != 0) {
                min = Math.min(min, elem[i]/need[i]);
            }
        }
        System.out.println(min);
        r.close();
    }
}