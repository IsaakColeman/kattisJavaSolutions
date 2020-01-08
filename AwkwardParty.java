import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class AwkwardParty {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();
        ArrayList<Integer> awkward = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if(distance.containsKey(temp)) {
                awkward.add(distance.get(temp)+i);
                distance.replace(temp, 1-i);
            } else {
                distance.put(temp, -i);
            }
        }
        if(awkward.isEmpty()) {
            System.out.println(n);
        } else {
            int temp = Integer.MAX_VALUE;
            for(int i : awkward) {
                if(i < temp) {
                    temp = i;
                }
            }
            System.out.println(temp);
        }
        in.close();
    }
}