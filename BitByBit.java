import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class BitByBit {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        while(n > 0) {
            int[] bits = new int[32];
            StringBuilder out = new StringBuilder(32);
            for(int k = 0; k < n; k++) {
                String[] in = r.readLine().split(" ");
                switch(in[0]) {
                    case "SET" : bits[Integer.parseInt(in[1])] = 1; break;
                    case "CLEAR" : bits[Integer.parseInt(in[1])] = -1; break;
                    case "AND" : {
                        int i = Integer.parseInt(in[1]);
                        int j = Integer.parseInt(in[2]);
                        if(bits[j] == -1 || bits[i] == -1) {
                            bits[i] = -1;
                        } else if(bits[i] == 1 && bits[j] == 0) {
                            bits[i] = 0;
                        }
                        break;
                    }
                    default : {
                        int i = Integer.parseInt(in[1]);
                        int j = Integer.parseInt(in[2]);
                        if(bits[j] == 1 || bits[i] == 1) {
                            bits[i] = 1;
                        } else if((bits[i] == 0 && bits[j] == -1) || (bits[i] == -1 && bits[j] == 0)) {
                            bits[i] = 0;
                        }
                    }
                }
            }
            for(int i = 31; i >= 0; i--) {
                switch(bits[i]) {
                    case 0 : out.append('?'); break;
                    case 1 : out.append('1'); break;
                    default : out.append('0');
                }
            }
            System.out.println(out);
            n = Integer.parseInt(r.readLine());
        }
        r.close();
    }
}