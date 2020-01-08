import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.regex.Pattern;

class Backspace {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();
        Pattern p = Pattern.compile("([^<]+)|(<+)");
        Matcher m = p.matcher(line);
        StringBuilder out = new StringBuilder(line.length());
        try {
            while(m.find()) {
                out.append(m.group(1));
                if(m.find()) {
                    out = out.replace(out.length() - m.group(2).length(), out.length(), "");
                }
            }
        } finally {
            System.out.println(out.toString());
            r.close();
        }
    }
}