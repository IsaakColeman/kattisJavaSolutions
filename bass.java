import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;

class bass {
    private static String value = "0123456789abcdefghijklmnopqrstuvwxyz0";

    private static int value(char c) {
        return value.indexOf(c);
    }

    private static int calcValue(String stringNum, int base) {
        int value = 0;
        for(int j = 0; j < stringNum.length(); j++) {
            value *= base;
            value += value(stringNum.charAt(j));
        }
        return value;
    }

    private static int lowestBase(String exp) {
        char[] temp = exp.replaceAll("[-=+*\\/ ]+", "").toCharArray();
        Arrays.sort(temp);
        int lowest = value(temp[temp.length - 1]) + 1;
        if(lowest <= 2 && temp[0] != '0') {lowest = 1;}
        return lowest;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("([^ ]+) ([-*+\\/]+) ([^ ]+) = ([^ ]+)$");
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);
            if(m.matches()) {
                String out = "";
                String snum1 = m.group(1);
                String op = m.group(2);
                String snum2 = m.group(3);
                String snum3 = m.group(4);

                int start = lowestBase(line);
                for(int base = start; base <= 36; base++) {
                    int num1 = calcValue(snum1, base);
                    int num2 = calcValue(snum2, base);
                    int num3 = calcValue(snum3, base);

                    switch (op) {
                        case "+": {
                            if(num1 + num2 == num3) {out += value.charAt(base);} break;
                        }
                        case "-": {
                            if(num1 - num2 == num3) {out += value.charAt(base);} break;
                        }
                        case "*": {
                            if(num1 * num2 == num3) {out += value.charAt(base);} break;
                        }
                        case "/": {
                            if(num1 == num2 * num3) {out += value.charAt(base);} break;
                        }
                    }
                }
                if(out.equals("")) {System.out.println("invalid");}
                else {System.out.println(out);}
            }
        }
        in.close();
    }
}