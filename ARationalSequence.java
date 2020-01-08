import java.util.Scanner;

class ARS {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        for(int j = 0; j < n; j++) {
            String[] input = in.nextLine().split("[ /]");
            Integer p = Integer.parseInt(input[1]);
            Integer q = Integer.parseInt(input[2]);
            if(q == 1) {
                q = p + 1;
                p = 1;
            } else {
                int count = p/q;
                p -= count*q;
                if(p > q) {
                    p -= q;
                    count++;
                }
                int temp = q;
                q = q - p;
                p = temp;
                q = q + count*p;
            }
            System.out.println(input[0] + ' ' + p.toString() + '/' + q.toString());
        }
        in.close();
    }
}