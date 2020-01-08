import java.util.Scanner;

class BabblyonianNumbers {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n; i++) {
            char[] input = in.nextLine().toCharArray();
            long output = 0;
            String val = "";
            for(char d : input) {
                if(d == ',') {
                    output *= 60;
                    if(!val.equals("")) {
                        output += Integer.parseInt(val);
                        val = "";
                    }
                } else {
                    val += d;
                }
            }
            output *= 60;
            if(!val.equals("")) {
                output += Integer.parseInt(val);
                val = "";
            }
            System.out.println(output);
        }
        in.close();
    }
}