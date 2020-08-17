import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Vector;

class Display {

    public static void add(char n, int pos, String[] out) {
        if(pos < 4) {
            switch(n) {
                case '0': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "|   |  ";
                    out[pos+10] = "|   |  ";
                    out[pos+15] = "+   +  ";
                    out[pos+20] = "|   |  ";
                    out[pos+25] = "|   |  ";
                    out[pos+30] = "+---+  ";
                    break;
                }
                case '1': {
                    out[pos] = "    +  ";
                    out[pos+5] = "    |  ";
                    out[pos+10] = "    |  ";
                    out[pos+15] = "    +  ";
                    out[pos+20] = "    |  ";
                    out[pos+25] = "    |  ";
                    out[pos+30] = "    +  ";
                    break;
                }
                case '2': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "    |  ";
                    out[pos+10] = "    |  ";
                    out[pos+15] = "+---+  ";
                    out[pos+20] = "|      ";
                    out[pos+25] = "|      ";
                    out[pos+30] = "+---+  ";
                    break;
                }
                case '3': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "    |  ";
                    out[pos+10] = "    |  ";
                    out[pos+15] = "+---+  ";
                    out[pos+20] = "    |  ";
                    out[pos+25] = "    |  ";
                    out[pos+30] = "+---+  ";
                    break;
                }
                case '4': {
                    out[pos] = "+   +  ";
                    out[pos+5] = "|   |  ";
                    out[pos+10] = "|   |  ";
                    out[pos+15] = "+---+  ";
                    out[pos+20] = "    |  ";
                    out[pos+25] = "    |  ";
                    out[pos+30] = "    +  ";
                    break;
                }
                case '5': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "|      ";
                    out[pos+10] = "|      ";
                    out[pos+15] = "+---+  ";
                    out[pos+20] = "    |  ";
                    out[pos+25] = "    |  ";
                    out[pos+30] = "+---+  ";
                    break;
                }
                case '6': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "|      ";
                    out[pos+10] = "|      ";
                    out[pos+15] = "+---+  ";
                    out[pos+20] = "|   |  ";
                    out[pos+25] = "|   |  ";
                    out[pos+30] = "+---+  ";
                    break;
                }
                case '7': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "    |  ";
                    out[pos+10] = "    |  ";
                    out[pos+15] = "    +  ";
                    out[pos+20] = "    |  ";
                    out[pos+25] = "    |  ";
                    out[pos+30] = "    +  ";
                    break;
                }
                case '8': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "|   |  ";
                    out[pos+10] = "|   |  ";
                    out[pos+15] = "+---+  ";
                    out[pos+20] = "|   |  ";
                    out[pos+25] = "|   |  ";
                    out[pos+30] = "+---+  ";
                    break;
                }
                case '9': {
                    out[pos] = "+---+  ";
                    out[pos+5] = "|   |  ";
                    out[pos+10] = "|   |  ";
                    out[pos+15] = "+---+  ";
                    out[pos+20] = "    |  ";
                    out[pos+25] = "    |  ";
                    out[pos+30] = "+---+  ";
                    break;
                }
                default: {
                    out[pos] = "   ";
                    out[pos+5] = "   ";
                    out[pos+10] = "o  ";
                    out[pos+15] = "   ";
                    out[pos+20] = "o  ";
                    out[pos+25] = "   ";
                    out[pos+30] = "   ";
                    break;
                }
            }
        } else {
            switch(n) {
                case '0': {
                    out[pos] = "+---+\n";
                    out[pos+5] = "|   |\n";
                    out[pos+10] = "|   |\n";
                    out[pos+15] = "+   +\n";
                    out[pos+20] = "|   |\n";
                    out[pos+25] = "|   |\n";
                    out[pos+30] = "+---+\n";
                    break;
                }
                case '1': {
                    out[pos] = "    +\n";
                    out[pos+5] = "    |\n";
                    out[pos+10] = "    |\n";
                    out[pos+15] = "    +\n";
                    out[pos+20] = "    |\n";
                    out[pos+25] = "    |\n";
                    out[pos+30] = "    +\n";
                    break;
                }
                case '2': {
                    out[pos] = "+---+\n";
                    out[pos+5] = "    |\n";
                    out[pos+10] = "    |\n";
                    out[pos+15] = "+---+\n";
                    out[pos+20] = "|    \n";
                    out[pos+25] = "|    \n";
                    out[pos+30] = "+---+\n";
                    break;
                }
                case '3': {
                    out[pos] = "+---+\n";
                    out[pos+5] = "    |\n";
                    out[pos+10] = "    |\n";
                    out[pos+15] = "+---+\n";
                    out[pos+20] = "    |\n";
                    out[pos+25] = "    |\n";
                    out[pos+30] = "+---+\n";
                    break;
                }
                case '4': {
                    out[pos] = "+   +\n";
                    out[pos+5] = "|   |\n";
                    out[pos+10] = "|   |\n";
                    out[pos+15] = "+---+\n";
                    out[pos+20] = "    |\n";
                    out[pos+25] = "    |\n";
                    out[pos+30] = "    +\n";
                    break;
                }
                case '5': {
                    out[pos] = "+---+\n";
                    out[pos+5] = "|    \n";
                    out[pos+10] = "|    \n";
                    out[pos+15] = "+---+\n";
                    out[pos+20] = "    |\n";
                    out[pos+25] = "    |\n";
                    out[pos+30] = "+---+\n";
                    break;
                }
                case '6': {
                    out[pos] = "+---+\n";
                    out[pos+5] = "|    \n";
                    out[pos+10] = "|    \n";
                    out[pos+15] = "+---+\n";
                    out[pos+20] = "|   |\n";
                    out[pos+25] = "|   |\n";
                    out[pos+30] = "+---+\n";
                    break;
                }
                case '7': {
                    out[pos] = "+---+\n";
                    out[pos+5] = "    |\n";
                    out[pos+10] = "    |\n";
                    out[pos+15] = "    +\n";
                    out[pos+20] = "    |\n";
                    out[pos+25] = "    |\n";
                    out[pos+30] = "    +\n";
                    break;
                }
                case '8': {
                    out[pos] = "+---+\n";
                    out[pos+5] = "|   |\n";
                    out[pos+10] = "|   |\n";
                    out[pos+15] = "+---+\n";
                    out[pos+20] = "|   |\n";
                    out[pos+25] = "|   |\n";
                    out[pos+30] = "+---+\n";
                    break;
                }
                default: {
                    out[pos] = "+---+\n";
                    out[pos+5] = "|   |\n";
                    out[pos+10] = "|   |\n";
                    out[pos+15] = "+---+\n";
                    out[pos+20] = "    |\n";
                    out[pos+25] = "    |\n";
                    out[pos+30] = "+---+\n";
                }
            }
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder(1000000);
        char[] time = r.readLine().toCharArray();
        while(time[0] != 'e') {
            String[] num = new String[35];
            for(int i = 0; i < 5; i++) {
                add(time[i], i, num);
            }
            for(String s : num) {
                out.append(s);
            }
            out.append("\n\n");
            time = r.readLine().toCharArray();
        }
        out.append("end\n");
        System.out.print(out);
        r.close();
    }
}