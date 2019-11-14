import java.util.Scanner;

class difference {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            Long diff = in.nextLong();
            diff -= in.nextLong();
            if(diff < 0) {
                diff *= -1;
            }
            System.out.println(diff);
            in.nextLine();
        }
        in.close();
    }
}