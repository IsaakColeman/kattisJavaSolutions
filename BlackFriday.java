import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BlackFriday {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Boolean[] repeat = new Boolean[6];
        int[] index = new int[6];
        int n = Integer.parseInt(r.readLine());
        char[] rolls = r.readLine().replaceAll(" ", "").toCharArray();
        for(int i = 0; i < n; i++) {
            if(repeat[rolls[i] - '1'] == null) {
                repeat[rolls[i] - '1'] = false;
                index[rolls[i] - '1'] = i;

            } else {
                repeat[rolls[i] - '1'] = true;
            }
        }
        int i;
        for(i = 5; i >= 0; i--) {
            if(repeat[i] != null && repeat[i] == false) {
                break;
            }
        }
        if(i >= 0) {
            System.out.println(index[i] + 1);
        } else {
            System.out.println("none");
        }
        r.close();
    }
}