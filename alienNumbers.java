import java.util.Scanner;

class alienNumbers {

    private static int value(char c, String str) {
        return str.indexOf(c);
    }

    private static int calcValue(String stringNum, String str) {
        int value = 0;
        int base = str.length();
        for(int j = 0; j < stringNum.length(); j++) {
            value *= base;
            value += value(stringNum.charAt(j), str);
        }
        return value;
    }

    private static String convBase(int number, String str) {
        String out = "";
        int base = str.length();
        long sub = 1;
        while(sub*base <= number && sub*base <= Integer.MAX_VALUE) {
            sub *= base;
        }
        while(sub > 0) {
            int temp = Math.toIntExact(number/sub);
            number -= sub*temp;
            sub = sub == 1 ? 0 : sub/base;
            out += str.charAt(temp);
        }
        return out;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n; i++) {
            String out = "Case #" + (i+1) + ": ";
            String temp = in.nextLine();
            String[] def = temp.split(" ");
            int number = calcValue(def[0], def[1]);
            out += convBase(number, def[2]);
            System.out.println(out);
        }
        
        in.close();
    }
}