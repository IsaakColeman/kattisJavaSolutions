import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class AsciiFigureRotation {
    
    private static char swap(char c) {
        switch(c) {
            case '-': return '|';
            case '|': return '-';
            default: return c;
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        while(n != 0) {
            String[] input = new String[n];
            int max = 0;
            for(int i = 0; i < n; i++) {
                input[i] = r.readLine();
                max = input[i].length() > max ? input[i].length() : max;
            }
            StringBuilder out = new StringBuilder(n);
            for(int i = 0; i < max; i++) {
                int spaces = 0;
                for(int j = n-1; j >= 0; j--) {
                    if(input[j].length() > i) {
                        char temp = swap(input[j].charAt(i));
                        if(temp == ' ') {
                            spaces++;
                        } else {
                            for(int k = 0; k < spaces; k++) {
                                out.append(' ');
                            }
                            out.append(temp);
                            spaces = 0;
                        }
                    } else {
                        spaces++;
                    }
                }
                out.append('\n');
            }
            n = Integer.parseInt(r.readLine());
            if(n != 0) {
                out.append('\n');
            }
            System.out.print(out);
        }
        r.close();
    }
}