import java.util.Scanner;
import java.util.ArrayList;

class Bard {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int villagers = in.nextInt();
        int nights = in.nextInt();
        boolean[] allSongs = new boolean[villagers];
        allSongs[0] = true;
        for(int i = 0; i < nights; i++) {
            int n = in.nextInt();
            ArrayList<Integer> attendees = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                attendees.add(in.nextInt()-1);
            }
            if(attendees.contains(0)) {
                for(int k = 0; k < villagers; k++) {
                    allSongs[k] = attendees.contains(k) ? allSongs[k] : false;
                }
            } else {
                for(int k : attendees) {
                    allSongs[k] = true;
                }
            }
        }
        for(int i = 0; i < villagers; i++) {
            if(allSongs[i]) {System.out.println(i+1);}
        }
        in.close();
    }
}