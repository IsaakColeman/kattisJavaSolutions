import java.util.Scanner;

class AlphabetSpam {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        char[] input = in.nextLine().toCharArray();
        int spaces = 0, lower = 0, upper = 0, badchar = 0;
        for(char c : input) {
            if(c == '_') {
                spaces++;
            } else if(c >= 'A' && c <= 'Z') {
                upper++;
            } else if(c >= 'a' && c <= 'z') {
                lower++;
            } else {
                badchar++;
            }
        }
        double len = (double) input.length;
        System.out.println(spaces/len);
        System.out.println(lower/len);
        System.out.println(upper/len);
        System.out.println(badchar/len);

        in.close();
    }
}