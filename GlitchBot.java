import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class GlitchBot {
    public static boolean CalcDest(String[] commands, int s, int px, int py, int d, int tx, int ty) {
        for(int i = s; i < commands.length; i++) {
            switch(commands[i]) {
                case "Forward" : {
                    switch(d) {
                        case 0 : py++; break;
                        case 1 : px++; break;
                        case 2 : py--; break;
                        default: px--; break;
                    }
                    break;
                }
                case "Right" : d = (d+1)%4; break;
                default : d = (d+3)%4;
            }
        }
        if(px == tx && py == ty) {
            System.out.printf("%d %s\n", s+1, commands[s]);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        int tx = Integer.parseInt(in[0]);
        int ty = Integer.parseInt(in[1]);
        int t = Integer.parseInt(r.readLine());
        int[] px = new int[t+1];
        int[] py = new int[t+1];
        int[] d = new int[t+1];
        int cx = 0;
        int cy = 0;
        int cd = 0;
        String[] commands = new String[t];
        for(int i = 0; i < t; i++) {
            commands[i] = r.readLine();
            switch(commands[i]) {
                case "Forward" : {
                    switch(cd) {
                        case 0 : cy++; break;
                        case 1 : cx++; break;
                        case 2 : cy--; break;
                        default: cx--; break;
                    }
                    break;
                }
                case "Right" : cd = (cd+1)%4; break;
                default : cd = (cd+3)%4;
            }
            px[i+1] = cx;
            py[i+1] = cy;
            d[i+1] = cd;
        }
        for(int i = 0; i < t; i++) {
            switch(commands[i]) {
                case "Forward" : commands[i] = "Right"; break;
                case "Right" : commands[i] = "Left"; break;
                default : commands[i] = "Forward";
            }
            if(CalcDest(commands, i, px[i], py[i], d[i], tx, ty)) {
                break;
            }
            switch(commands[i]) {
                case "Forward" : commands[i] = "Right"; break;
                case "Right" : commands[i] = "Left"; break;
                default : commands[i] = "Forward";
            }
            if(CalcDest(commands, i, px[i], py[i], d[i], tx, ty)) {
                break;
            }
        }
        r.close();
    }
}