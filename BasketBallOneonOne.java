import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BasketBallOneonOne {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[2];
        char[] in = r.readLine().toCharArray();
        for(int i = 0; i < in.length - 1; i++) {
            score[in[i++] - 'A'] += in[i] - '0';
            // if((score[0] >= 10 || score[1] >= 10) && (score[0] +1 > score[1] || score[0] +1 < score[1])) {
            //     break;
            // }
        }
        if(score[0] > score[1]) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
        r.close();
    }
}