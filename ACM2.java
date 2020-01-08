import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

class ACM2 {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int time = in.nextInt();
        ArrayList<Integer> problems = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            problems.add(in.nextInt());
        }
        time = 300 - problems.remove(time);
        if(time < 0) {
            System.out.println("0 0");
        } else {
            int penalty = 300 - time;
            Collections.sort(problems);
            for(int i = 0; i < n-1; i++) {
                time -= problems.get(i);
                if(time >= 0) {
                    penalty += 300 - time;
                } else {
                    n = i +1;
                    break;
                }
            }
            System.out.println(n + " " + penalty);
        }
        in.close();
    }
}