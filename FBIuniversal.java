import java.util.Scanner;

class FBIU {
    private static String base = "0123456789ACDEFHJKLMNPRTVWX";

    private static int conv(char c) {
        if(base.indexOf(c) < 0) {
            return convBad(c);
        }
        return base.indexOf(c);
    }

    private static int convBad(char c) {
        switch(c) {
            case 'U': return conv('V');
            case 'G': return conv('C');
            case 'B': return 8;
            case 'S': return 5;
            case 'Z': return 2;
            case 'I': return 1;
            default: return 0;
        }
    }

    private static boolean check(String s) {
        return (2*conv(s.charAt(0)) + 4*conv(s.charAt(1)) + 5*conv(s.charAt(2))
              + 7*conv(s.charAt(3)) + 8*conv(s.charAt(4)) + 10*conv(s.charAt(5))
              + 11*conv(s.charAt(6)) + 13*conv(s.charAt(7)))%27 == conv(s.charAt(8));
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int j = 0; j < n; j++) {
            String[] input = in.nextLine().split(" ");
            System.out.print(input[0] + ' ');
            if(check(input[1])) {
                double value = 0.0;
                for(char c : input[1].substring(0, 8).toCharArray()) {
                    value *= 27;
                    value += conv(c);
                }
                System.out.println(String.format("%.0f", value));
            } else {
                System.out.println("invalid");
            }
        }
        
        in.close();
    }
}