import java.util.Scanner;
import java.util.HashMap;

class Babelfish {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        HashMap<String, String> dict = new HashMap<String, String>();
        String[] line = in.nextLine().split(" ");
        while(!line[0].equals("")) {
            dict.put(line[1], line[0]);
            line = in.nextLine().split(" ");
        }
        while(in.hasNextLine()) {
            String temp = dict.get(in.nextLine());
            if(temp == null) {
                System.out.println("eh");
            } else {
                System.out.println(temp);
            }
        }

        in.close();
    }
}