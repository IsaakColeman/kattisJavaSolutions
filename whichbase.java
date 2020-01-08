import java.util.Scanner;

class WhichBase {

    private static String conv8(String num) {
        int value = 0;
        for(char c : num.toCharArray()) {
            if(c == '8' || c == '9') {return "0";}
            value <<= 3;
            value += c - '0';
        }
        return Integer.toString(value);
    }

    private static String conv16(String num) {
        int value = 0;
        for(char c : num.toCharArray()) {
            value <<= 4;
            value += c - '0';
        }
        return Integer.toString(value);
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        for(int j = 0; j < n; j++) {
            String[] line = in.nextLine().split(" ");
            System.out.println(line[0] + ' ' + conv8(line[1]) + ' ' + Integer.toString(Integer.parseInt(line[1])) + ' ' + conv16(line[1]));
        }
        in.close();
    }
}