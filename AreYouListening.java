import java.util.Scanner;
import java.util.Arrays;

class AYL {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int cx = in.nextInt(), cy = in.nextInt(), n = in.nextInt();
        Integer[] range = new Integer[n];
        for(int i = 0; i < n; i++) {
            int x = Math.abs(in.nextInt() - cx);
            int y = Math.abs(in.nextInt() - cy);
            range[i] = (int) (Math.sqrt(x*x+y*y) - in.nextInt());
        }
        Arrays.sort(range);
        if(range[2] < 0) {
            System.out.println(0);
        } else {
            System.out.println(range[2]);
        }
        in.close();
    }
}