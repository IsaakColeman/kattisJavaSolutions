import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class DivSub {
    public static void main(String[] arg) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        for(int i = 0; i < num; i++) {
            String[] input = in.readLine().split(" ");
            int div = Integer.parseInt(input[0]);
            int length = Integer.parseInt(input[1]);
            int[] need = new int[div];
            int offset = 0;
            int count = 0;

            String[] numbers = in.readLine().split(" ");
            int next = Integer.parseInt(numbers[0])%div;
            if(next == 0) {count++;}
            need[div-next]++;
          
            for(int j = 1; j < length; j++) {
                next = Integer.parseInt(numbers[j])%div;
                count += need[(next-offset+div)%div];
                if(next == 0) {count++;}
                offset-= next;
                if(offset < 0) {offset+=div;}
                need[(2*div-next-offset)%div]++;
            }
            System.out.println(count);
        }
        in.close();
    }
}