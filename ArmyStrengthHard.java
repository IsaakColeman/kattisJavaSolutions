import java.util.Scanner;

class ASH {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int trials = in.nextInt();
        for(int j = 0; j < trials; j++) {
            int armyG = in.nextInt();
            int armyM = in.nextInt();
            int largestG = 0;
            int largestM = 0;

            for(int i = 0; i < armyG; i++) {
                int temp = in.nextInt();
                largestG = largestG < temp ? temp : largestG;
            }
            for(int i = 0; i < armyM; i++) {
                int temp = in.nextInt();
                largestM = largestM < temp ? temp : largestM;
            }
            if(largestM > largestG) {
                System.out.println("MechaGodzilla");
            } else {
                System.out.println("Godzilla");
            }
        }
        in.close();
    }
}