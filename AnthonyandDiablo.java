import java.util.Scanner;

class AandD {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        double area = in.nextDouble();
        double rad = in.nextDouble()/(2*Math.PI);
        if(rad*rad*Math.PI >= area) {
            System.out.println("Diablo is happy!");
        } else {
            System.out.println("Need more materials!");
        }
        in.close();
    }
}