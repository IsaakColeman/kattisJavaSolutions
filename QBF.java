import java.util.*;
import java.util.regex.*;
import java.util.Scanner;

class QBF {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        Pattern p = Pattern.compile("([a-z])");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < num; i++) {
            Set letters = new HashSet();
            String line = in.nextLine().toLowerCase();
            Matcher m = p.matcher(line);
            while(m.find()) {
                letters.add(m.group(1).charAt(0));
            }
            if(letters.size() < 26) {
                System.out.println("missing ");
                for(int j = 0; j < alphabet.length(); j++) {
                    if(!letters.contains(alphabet.charAt(j))) {
                        System.out.print(alphabet.charAt(j));
                    }
                }
            }
            else {
                System.out.print("pangram");
            }
            System.out.println();
        }
    }
}