import java.util.Scanner;

class amsterdam {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        Double R = in.nextDouble();
        Double straight = R/N;
        Double angle = Math.PI/M;
        Double[] curve = new Double[N+1];
        curve[0] = 0.0;
        for(int i = 1; i < N+1; i++) {
            curve[i] = i*straight*angle;
        }
        int startA = in.nextInt();
        int startL = in.nextInt();
        int endA = in.nextInt();
        int endL = in.nextInt();
        if(endL > startL) {
            int temp = startL;
            startL = endL;
            endL = temp;
        }
        int diffA = startA - endA > 0 ? startA - endA : endA - startA;
        double dist = diffA != 0 ? (startL + endL)*straight : (startL - endL)*straight;
        for(int i = startL; i > 0; i--) {
            int diffL = i >= endL ? startL - endL : startL - i + endL - i;
            if(diffL * straight+ curve[i] * diffA < dist) {
                dist = diffL * straight + curve[i] * diffA;
            }
        }
        System.out.println(dist);
        in.close();
    }
}