import java.util.Scanner;
import java.util.Arrays;

class APNOCW {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cost = in.nextInt();
        int num = 1;
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        Arrays.sort(prices);
        for(int i = 1; i < n; i++) {
            if(prices[i-1] + prices[i] <= cost) {
                num++;
            } else {
                break;
            }
        }
        System.out.println(num);
        in.close();
    }
}