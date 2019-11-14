import java.util.Scanner;

class A1 {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() -1;
        int required = 2;
        Double tapeL = Math.pow(2, -3/4.0);
        Double tapeS = Math.pow(2, -5/4.0);
        Double total = 0.0;
        for(int i = 0; i < n; i++) {
            int num = in.nextInt();
            if(required <= num) {
                total += tapeL*required/2;
                System.out.println(total);
                in.close();
                return;
            }
            total += tapeL*required/2;
            required -= num;
            required *= 2;
            Double temp = tapeL;
            tapeL = tapeS;
            tapeS = temp/2;
        }
        System.out.println("impossible");
        in.close();
    }
}