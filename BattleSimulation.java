import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class BattleSimulation {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        char[] moves = r.readLine().toCharArray();
        int i;
        for(i = 0; i < moves.length -2; i++) {
            if(moves[i+1] != moves[i+2]) {
                if(moves[i+1] != moves[i] && moves[i+2] != moves[i]) {
                    out.append('C');
                    i+=2;
                } else {
                    if(moves[i] == 'R') {
                        out.append('S');
                    } else if(moves[i] == 'B') {
                        out.append('K');
                    } else {
                        out.append('H');
                    }
                }
            } else {
                if(moves[i] == 'R') {
                    out.append('S');
                } else if(moves[i] == 'B') {
                    out.append('K');
                } else {
                    out.append('H');
                }
                if(moves[i+1] == 'R') {
                    out.append('S');
                } else if(moves[i+1] == 'B') {
                    out.append('K');
                } else {
                    out.append('H');
                }
                i++;
            }
        }
        while(i < moves.length) {
            if(moves[i] == 'R') {
                out.append('S');
            } else if(moves[i] == 'B') {
                out.append('K');
            } else {
                out.append('H');
            }
            i++;
        }
            
        System.out.println(out);
        r.close();
    }
}