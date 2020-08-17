import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class ChartingProgress {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean more = true;
        StringBuilder out = new StringBuilder();
        int pos = 0;
        while(more) {
            char[] line = r.readLine().toCharArray();
            if(line.length == 0) {
                out.append('\n');
                pos = 0;
            } else {
                int count = 0;
                for(char c : line) {
                    if(c == '*') {
                        count++;
                    }
                }
                pos += count;
                for(int i = 0; i < line.length-pos; i++) {
                    out.append('.');
                }
                for(int i = 0; i < count; i++) {
                    out.append('*');
                }
                for(int i = count; i < pos; i++) {
                    out.append('.');
                }
                out.append('\n');
            }
            more = r.ready();
        }
        System.out.print(out);
        r.close();
    }
}