import java.util.Scanner;

class BTS {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int s = in.nextInt();
            int d = in.nextInt();
            Integer x = (s + d)%2 == 0 ? (s + d)/2 : -1;
            Integer y = x - d;
            if(x >= 0 && y >= 0) {
                System.out.println(x + " " + y);
            } else {
                System.out.println("impossible");
            }
        }
        in.close();
    }
}