import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.Scanner;

class Bazen {
    private static Double findHeight(double x1, double y1, double x2, double y2) {
        return 31250/(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        Double x = in.nextDouble();
        Double y = in.nextDouble();

        if(x > 0.0 && y >= 125.0) {
            Double height = findHeight(x, y, 250, 0);
            x = 250 - Math.sqrt(height*height + height*height);
            y = 0.0;
        } else if(x >= 125.0 && y > 0.0) {
            double height = findHeight(x, y, 0, 250);
            x = 0.0;
            y = 250 - Math.sqrt(height*height + height*height);
        } else if(x >= 125.0) {
            double height = findHeight(x, y, 0, 0);
            x = 0.0;
            y = height;
        } else if(y >= 125.0) {
            double height = findHeight(x, y, 0, 0);
            x = height;
            y = 0.0;
        } else if(x == 0.0) {
            double height = findHeight(x, y, 0, 250);
            x = height;
            y = 250 - height;
        } else {
            double height = findHeight(x, y, 250, 0);
            y = height;
            x = 250 - height;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(Math.abs(x)) + ' ' + df.format(Math.abs(y)));
        in.close();
    }
}