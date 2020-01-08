import java.util.Scanner;
import java.util.Arrays;

class Towering {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        Integer[] boxes = new Integer[6];
        for(int i = 0; i < 6; i++) {
            boxes[i] = in.nextInt();
        }
        int height1 = in.nextInt();
        int height2 = in.nextInt();
        Arrays.sort(boxes);
        for(int i = 0; i < 4; i++) {
            for(int j = i+1; j < 5; j++) {
                if(boxes[i] + boxes[j] + boxes[5] == height1) {
                    System.out.print(boxes[5].toString() + ' ' + boxes[j].toString() + ' ' + boxes[i].toString() + ' ');
                    for(int k = 4; k >= 0; k--) {
                        if(k != i && k != j) {
                            System.out.print(boxes[k].toString() + ' ');
                        }
                    }
                    System.out.println();
                    break;
                } else if(boxes[i] + boxes[j] + boxes[5] == height2) {
                    for(int k = 4; k >= 0; k--) {
                        if(k != i && k != j) {
                            System.out.print(boxes[k].toString() + ' ');
                        }
                    }
                    System.out.println(boxes[5].toString() + ' ' + boxes[j].toString() + ' ' + boxes[i].toString() + ' ');
                    break;
                }
            }
        }
        in.close();
    }
}