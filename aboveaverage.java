import java.util.Scanner;

class aboveaverage {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int len = in.nextInt();
            Double[] grades = new Double[len];
            Double sum = 0.0;
            for(int j = 0; j < len; j++) {
                grades[j] = in.nextDouble();
                sum += grades[j];
            }

            Double ave = sum/len;
            sum = 0.0;
            for(int j = 0; j < len; j++) {
                if(grades[j] > ave) {
                    sum++;
                }
            }
            System.out.println(String.format("%.3f", 100*sum/len) + "%");
        }
        in.close();
    }
}