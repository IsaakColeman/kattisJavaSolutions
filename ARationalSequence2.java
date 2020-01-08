import java.util.Scanner;
import java.util.ArrayDeque;

class ARS2 {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int j = 1; j <= n; j++) {
            String[] input = in.nextLine().split("[ /]");
            int p = Integer.parseInt(input[1]);
            int q = Integer.parseInt(input[2]);
            ArrayDeque<Boolean> right = new ArrayDeque<>(31);
            while(p > 1 || q > 1) {
                if(p > q) {
                    right.push(true);
                    p -= q;
                } else {
                    right.push(false);
                    q -= p;
                }
            }
            int index = 1;
            while(!right.isEmpty()) {
                index <<= 1;
                if(right.pop()) {
                    index++;
                }
            }
            System.out.println(input[0] + " " + index);
        }
        in.close();
    }
}