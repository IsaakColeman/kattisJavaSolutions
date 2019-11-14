import java.util.Scanner;

class DivSub {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        for(int i = 0; i < num; i++) {
            int div = in.nextInt();
            int length = in.nextInt();
            in.nextLine();
            int[] need = new int[div];
            int offset = 0;
            int count = 0;

            int next = in.nextInt()%div;
            if(next == 0) {count++;}
            need[(div-next)]++;
          
            for(int j = 1; j < length; j++) {
                next = in.nextInt()%div;
                count += need[(next-offset+div)%div];
                if(next == 0) {count++;}
                offset-= next;
                if(offset < 0) {offset+=div;}
                need[(2*div-next-offset)%div]++;
            }
            System.out.println(count);
            in.nextLine();
        }
        in.close();
    }
}