import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Ants {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; i++) {
            String[] input = r.readLine().split(" ");
            int len = Integer.parseInt(input[0]);
            int ants = Integer.parseInt(input[1]);
            int longest = 0;
            int shortest = 0;
            while(ants > 0) {
                input = r.readLine().split(" ");
                for(String in : input) {
                    int pos1 = Integer.parseInt(in);
                    int pos2 = len - pos1;
                    if(pos1 < pos2) {
                        if(pos1 > shortest) {
                            shortest = pos1;
                        }
                        if(pos2 > longest) {
                            longest = pos2;
                        }
                    } else {
                        if(pos2 > shortest) {
                            shortest = pos2;
                        }
                        if(pos1 > longest) {
                            longest = pos1;
                        }
                    }
                    ants--;
                }
            }
            System.out.println(shortest + " " + longest);
        }
        r.close();
    }
}