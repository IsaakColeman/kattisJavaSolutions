import java.util.Scanner;
import java.util.Arrays;

class akcija {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] books = new int[n];
        int cost = 0;
        for(int i = 0; i < n; i++) {
            books[i] = in.nextInt();
        }
        Arrays.sort(books);
        int start = n%3;
        if(start != 0) {
            cost = books[0];
            if(start != 1) {cost += books[1];}
        }
        for(int j = start; j+2 < n; j+=3) {
            cost += books[j+2] + books[j+1];
        }
        System.out.println(cost);
        in.close();
    }
}