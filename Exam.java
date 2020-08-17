import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Exam {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(r.readLine());
        int diff = 0;
        char[] yours = r.readLine().toCharArray();
        char[] friends = r.readLine().toCharArray();
        for(int i = 0; i < yours.length; i++) {
            if(yours[i] != friends[i]) {
                diff++;
            }
        }
        if(diff+score > yours.length) {
            System.out.println(yours.length - diff + yours.length - score);
        } else {
            System.out.println(score+diff);
        }
        r.close();
    }
}