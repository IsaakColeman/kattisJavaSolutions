import java.util.Scanner;
import java.util.regex.*;
import java.util.TreeSet;

class AMD {
    private static char flip(char c) {
        switch(c) {
            case '6': return '9';
            case '9': return '6';
            default: return c;
        }
    }
    private static Integer flipCard(String card) {
        String flip = "";
        char[] digits = card.toCharArray();
        for(int i = digits.length - 1; i >= 0; i--) {
            flip += flip(digits[i]);
        }
        return Integer.parseInt(flip);
    }
    public static void main(String[] arg) {
        Pattern p = Pattern.compile("[0125689]+");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        in.nextLine();
        String[] cards = in.nextLine().split(" ");
        TreeSet<Integer> needed = new TreeSet<Integer>();
        for(String card : cards) {
            Integer value = Integer.parseInt(card);
            if(needed.contains(value)) {
                System.out.println("YES");
                in.close();
                return;
            }
            Matcher m = p.matcher(card);
            if(m.matches()) {
                Integer temp = flipCard(card);
                if(needed.contains(temp)) {
                    System.out.println("YES");
                    in.close();
                    return;
                }
                needed.add(sum - temp);
            }
            needed.add(sum - value);
        }
        System.out.println("NO");
        in.close();
    }
}