import java.util.Scanner;

class Compromise {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int num = in.nextInt();
            int len = in.nextInt();
            in.nextLine();
            int[] out = new int[len];
            for(int j = 0; j < num; j++) {
                char[] input = in.nextLine().toCharArray();
                for(int k = 0; k < len; k++) {
                    out[k] += input[k] - '0';
                }
            }
            num = num%2 == 0 ? num/2 : num/2 + 1;
            for(int j : out) {
                System.out.print(j/num);
            }
            System.out.println();
        }
        in.close();
    }
}