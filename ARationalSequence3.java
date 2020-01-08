import java.util.Scanner;
import java.util.ArrayDeque;

class ARS3 {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j = 1; j <= n; j++) {
            in.nextInt();
            int index = in.nextInt();
            ArrayDeque<Boolean> right = new ArrayDeque<>(31);
            while(index > 1) {
                right.push(index%2 == 0);
                index = index/2;
            }
            int p = 1, q = 1;
            while(!right.isEmpty()) {
                if(!right.pop()) {
                    p += q;
                } else {
                    q += p;
                }
            }
            System.out.println(j + " " + p + "/" + q);
        }
        in.close();
    }
}