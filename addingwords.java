import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;

class AddingWords {
    public HashMap<String, Integer> def;

    public AddingWords() {
        this.def = new HashMap<String, Integer>();
    }

    public void calc(String[] exp) {
        int value = 0;
        for(int i = 0; i < exp.length -1; i += 2) {
            int sign = exp[i].equals("-") ? -1 : 1;
            if(this.def.containsKey(exp[i+1])) {
                value += sign * this.def.get(exp[i+1]);
            } else {
                System.out.println("unknown");
                return;
            }
        }
        if(this.def.containsValue(value)) {
            for(String str : this.def.keySet()) {
                if(this.def.get(str) == value) {
                    System.out.println(str);
                    return;
                }
            }
        } else {
            System.out.println("unknown");
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        AddingWords adder = new AddingWords();
        boolean next = true;
        while(next) {
            arg = r.readLine().split(" ");
            switch(arg[0]) {
                case "def": adder.def.put(arg[1], Integer.parseInt(arg[2])); break;
                case "calc": {
                    for(int i = 1; i < arg.length; i++) {
                        System.out.print(arg[i] + " ");
                    }
                    adder.calc(arg);
                    break;
                }
                default: adder.def.clear();
            }
            next = r.ready();
        }
        r.close();
    }
}