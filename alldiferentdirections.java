import java.util.Scanner;
import java.util.regex.*;

class AllDifDirections {

    static Double calcDist(Double x1, Double y1, Double x2, Double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("(start||turn||walk) (-?[0-9]+(.[0-9]+)?)");
        int n = in.nextInt();
        in.nextLine();
        while(n > 0) {
            Double totalX = 0.0;
            Double totalY = 0.0;
            Double[] dest = new Double[2*n];
            for(int i = 0; i < n; i++) {
                Double xPos = in.nextDouble();
                Double yPos= in.nextDouble();
                Matcher m = p.matcher(in.nextLine());
                Double angle = 0.0;
                Double length = 0.0;
                while(m.find()) {
                    if(m.group(1).equals("walk")) {
                        length = Double.parseDouble(m.group(2));
                        xPos += length * Math.cos(Math.toRadians(angle));
                        yPos += length * Math.sin(Math.toRadians(angle));
                    } else {
                        angle += Double.parseDouble(m.group(2));
                    }
                }
                totalX += xPos;
                totalY += yPos;
                dest[2*i] = xPos;
                dest[2*i + 1] = yPos;
            }
            totalX /= n;
            totalY /= n;
            Double worst = 0.0;
            for(int i = 0; i < n; i++) {
                if(calcDist(dest[2*i], dest[2*i + 1], totalX, totalY) > worst) {
                    worst = calcDist(dest[2*i], dest[2*i + 1], totalX, totalY);
                }
            }
            System.out.println(totalX.toString() +' '+ totalY.toString() +' '+ worst.toString());
            n = in.nextInt();
        }
        in.close();
    }
}