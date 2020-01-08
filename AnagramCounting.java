import java.math.BigInteger;
import java.util.Scanner;

class AnagramCounting {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            char[] input = in.nextLine().toCharArray();
            int[] counts = new int[52];
            for(char c : input) {
                if(c <= 'Z') {
                    counts[c - 'A']++;
                } else {
                    counts[c - 'a' + 26]++;
                }
            }
            int count = 0;
            BigInteger div = new BigInteger("1");
            for(int i : counts) {
                if(i > 0) {
                    count+=i;
                    for(int j = 2; j <= i; j++) {
                        div = div.multiply(new BigInteger(Integer.toString(j)));
                    }
                }
            }
            BigInteger top = new BigInteger("1");
            for(int i = 2; i <= count; i++) {
                top = top.multiply(new BigInteger(Integer.toString(i)));
            }
            System.out.println(top.divide(div));
        }
        in.close();
    }
}