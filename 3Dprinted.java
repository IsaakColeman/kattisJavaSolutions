import java.util.Scanner;

class print {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int statues = in.nextInt();
        in.close();
        int printers = 1;
        int days = 1;
        while(statues > 2*printers) {
            printers*=2;
            days++;
        }
        if(statues <= printers) {
            System.out.println(days);
        } else {
            System.out.println(days+1);
        }
    }
}