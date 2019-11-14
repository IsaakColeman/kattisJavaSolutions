import java.util.Scanner;

class YODA {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        in.close();

        int offset = line1.length() - line2.length();
        boolean swap = false;
        if(offset < 0) {
            String temp = line1;
            line1 = line2;
            line2 = temp;
            offset *= -1;
            swap = true;
        }

        String out1 = line1.substring(0, offset);
        String out2 = "";
        for(int i = offset; i < line1.length(); i++) {
            int in1 = line1.charAt(i) - '0';
            int in2 = line2.charAt(i - offset) - '0';
            if(in1 >= in2) {
                out1 += in1;
            }
            if(in2 >= in1) {
                out2 += in2;
            }
        }
        if(swap) {
            String temp = out1;
            out1 = out2;
            out2 = temp;
        }
        if(!out1.equals("")) {System.out.println(Integer.parseInt(out1));}
        else {System.out.println("YODA");}
        if(!out2.equals("")) {System.out.println(Integer.parseInt(out2));}
        else {System.out.println("YODA");}
    }
}