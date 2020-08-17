import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Hardware {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(r.readLine());
        for(int k = 0; k < t; k++) {
            int[] digits = new int[10];
            int sum = 0;
            String street = r.readLine();
            String address = r.readLine();
            int add = Integer.parseInt(address.split(" ")[0]);
            for(int i = 0; i < add; i++) {
                String[] in = r.readLine().split(" ");
                if(in.length > 1) {
                    int curr = Integer.parseInt(in[1]);
                    int diff = Integer.parseInt(in[3]);
                    while(curr <= Integer.parseInt(in[2])) {
                        int num = curr;
                        while(num > 0) {
                            digits[num%10]++;
                            num /= 10;
                            sum++;
                        }
                        curr += diff;
                        i++;
                    }
                    i--;
                } else {
                    int num = Integer.parseInt(in[0]);
                    while(num > 0) {
                        digits[num%10]++;
                        num /= 10;
                        sum++;
                    }
                }
            }
            out.append(street + "\n");
            out.append(address + "\n");
            for(int i = 0; i < 10; i++) {
                out.append(String.format("Make %d digit %d\n", digits[i], i));
            }
            if(sum != 1) {
                out.append(String.format("In total %d digits\n", sum));
            } else {
                out.append("In total 1 digit\n");
            }
        }
        System.out.print(out);
        r.close();
    }
}