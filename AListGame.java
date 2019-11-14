import java.util.Scanner;

class ALG {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();
        int count = 1;
        if(n%2 == 0) {
            do {
                n /= 2;
                count++;
            } while(n%2 == 0 && 2 <= n/2);
        }
        if(n%2 == 0) {
            do {
                n /= 3;
                count++;
            } while(n%3 == 0 && 3 <= n/2);
        }
        for(int i = 1; i <= n/6; i++) {
            int temp1 = 6*i-1;
            if(n%temp1 == 0) {
                do {
                    n /= temp1;
                    count++;
                } while(n%temp1 == 0 && temp1 <= n/2);
            }
            temp1 += 2;
            if(n%temp1 == 0) {
                do {
                    n /= temp1;
                    count++;
                } while(n%temp1 == 0 && temp1 <= n/2);
            }
            if(temp1-2 > n/2) {break;}
        }
        System.out.println(count);
        in.close();
    }
}