import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.*;

class ACM {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        HashMap<String, Integer> penalty = new HashMap<String, Integer>();
        HashSet<String> solved = new HashSet<String>();
        Pattern p = Pattern.compile("([0-9]+) ([A-Z]+) (right||wrong)");
        while(!line.equals("-1")) {
            Matcher m = p.matcher(line);
            m.find();
            if(m.group(3).equals("right")) {
                solved.add(m.group(2));
                if(penalty.putIfAbsent(m.group(2), Integer.parseInt(m.group(1))) != null) {
                    penalty.replace(m.group(2), penalty.get(m.group(2)) + Integer.parseInt(m.group(1)));
                }
            } else {
                if(!solved.contains(m.group(2))) {
                    if(penalty.putIfAbsent(m.group(2), 20) != null) {
                        penalty.replace(m.group(2), penalty.get(m.group(2)) + 20);
                    }
                }
            }
            line = in.nextLine();
        }
        int num = 0;
        int time = 0;
        for(String s : solved) {
            num++;
            time += penalty.get(s);
        }
        System.out.println(Integer.toString(num) + ' ' + Integer.toString(time));
        in.close();
    }
}
