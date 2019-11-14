import java.util.Scanner;
import java.lang.Math;

class artichoke {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int num = in.nextInt();

        Double high = -2.0;
        Double drop = 0.0;
        int A = a;
        int C = c;
        for(int i = 0; i < num; i++) {
            Double temp = Math.sin(A + b) + Math.cos(C + d);
            if(temp > high) {
                high = temp;
            } else if(high - temp > drop) {
                drop = high - temp;
            }
            A += a;
            C += c;
        }
        System.out.println(p*drop);
        in.close();
    }
}