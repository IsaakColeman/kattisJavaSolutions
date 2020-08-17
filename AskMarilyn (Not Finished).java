import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

class AskMarylin {
    
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String doors = "ABC";
        Random rand = new Random();
        char strat = '0';
        int[] correct = new int[3];
        int wrong = 0;
        for(int i = 0; i < 1000; i++) {
            char choice = 'A';
            System.out.println('A');
            String response = r.readLine();
            if(response.charAt(2) == '1') {
                System.out.println(response.charAt(0));
                r.readLine();
            } else {
                if(strat == '0' || strat == response.charAt(0)) {
                    choice = doors.replace(response.substring(0, 1), "").charAt(rand.nextInt(2));
                } else if(strat != 'A') {
                    choice = strat;
                }
                System.out.println(choice);
                response = r.readLine();
                if(response.charAt(0) == '0') {
                    wrong++;
                    if(wrong == 5) {
                        if(correct[0] > correct[1] + correct[2] + 2) {
                            strat = 'A';
                        } else if(correct[1] > correct[0] + correct[2] + 2) {
                            strat = 'B';
                        } else if(correct[2] > correct[0] + correct[1] + 2) {
                            strat = 'C';
                        } else {
                            strat = '0';
                        }
                        correct[0] = 0;
                        correct[1] = 0;
                        correct[2] = 0;
                        wrong = 0;
                    }
                }
                correct[response.charAt(2) - 'A']++;
            }
        }
        r.close();
    }
}