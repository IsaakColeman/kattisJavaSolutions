import java.util.Scanner;

class volim {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int pos = in.nextInt() - 1;
        in.nextLine(); in.nextLine();
        
        int timer = 30 + 3*60;
        timer -= in.nextInt();
        while(timer > 0) {
            if(in.hasNext("T")) {
                pos = (pos+1)%8;
            }
            in.nextLine();
            timer -= in.nextInt();
        }
        System.out.println(pos+1);
        in.close();
    }
}