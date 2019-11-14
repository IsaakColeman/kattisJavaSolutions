import java.util.Scanner;
import java.util.Arrays;

class Digits {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(!line.equals("END")) {
            if(line.equals("1")) {
                System.out.println("1");
            } else {
                int length = line.length();
                int count = 2;
                while(length != 1) {
                    count++;
                    int pow = 10;
                    int i = 1;
                    while(pow <= length) {
                        i++;
                        pow *= 10;
                    }
                    length = i;
                }
                System.out.println(count);
            }
            line = in.nextLine();
        }
        in.close();
    }
}