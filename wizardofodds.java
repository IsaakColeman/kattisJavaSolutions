import java.util.Scanner;
import java.math.BigInteger;

class WOO {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        BigInteger mod = new BigInteger("31000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        in.close();

        BigInteger num = new BigInteger(line[0]);
        BigInteger div = (new BigInteger("2")).modPow(new BigInteger(line[1]), mod);
        if(num.compareTo(div) != 1) {
            System.out.println("Your wish is granted!");
        } else {
            System.out.println("You will become a flying monkey!");
        }
    }
}