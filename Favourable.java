import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

class Favourable {

    private static Long finish(String input, HashMap<String, String> choices, HashMap<String, Long> shortcut) {
        Long cut = shortcut.get(input);
        if(cut != null) {
            return cut;
        } else {
            String[] s = choices.get(input).split(" ");
            if(s.length > 1) {
                Long count = finish(s[0], choices, shortcut)
                 + finish(s[1], choices, shortcut)
                 + finish(s[2], choices, shortcut);
                shortcut.put(input, count);
                return count;
            } else if(s[0].equals("favourably")) {
                shortcut.put(input, 1l);
                return 1l;
            }
            shortcut.put(input, 0l);
            return 0l;
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        for(int j = 0; j < t; j++) {
            int n = Integer.parseInt(r.readLine());
            HashMap<String, String> choices = new HashMap<String, String>();
            for(int i = 0; i < n; i++) {
                String[] input = r.readLine().split(" ", 2);
                choices.put(input[0], input[1]);
            }
            System.out.println(finish("1", choices, new HashMap<String, Long>()));
        }
        r.close();
    }
}