import java.util.Scanner;

class AnotherCandies {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j = 0; j < n; j++) {
            int kids = in.nextInt();
            long total = 0;
            for(int i = 0; i < kids; i++) {
                total += in.nextLong()%kids;
            }
            if(total%kids == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}