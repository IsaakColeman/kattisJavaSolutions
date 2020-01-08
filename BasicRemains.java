import java.math.BigInteger;
import java.util.Scanner;

class BasicRemains {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int base = Integer.parseInt(input[0]);
        while(base != 0) {
            System.out.println((new BigInteger(input[1], base)).mod(new BigInteger(input[2], base)).toString(base));
            input = in.nextLine().split(" ");
            base = Integer.parseInt(input[0]);
        }
        in.close();
    }
}