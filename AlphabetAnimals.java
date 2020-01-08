import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

class AlphabetAnimals {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char need = input.charAt(input.length() -1);
        int num = in.nextInt();
        in.nextLine();
        int[] nextTurn = new int[26];
        List<String> playable = new LinkedList<String>();
        for(int i = 0; i < num; i++) {
            String animal = in.nextLine();
            nextTurn[animal.charAt(0) - 'a'] += 1;
            if(animal.charAt(0) == need) {
                playable.add(animal);
            }
        }
        if(playable.size() == 0) {
            System.out.println('?');
        } else {
            for(String name : playable) {
                if(nextTurn[name.charAt(name.length() -1) - 'a'] == 0 || (nextTurn[name.charAt(name.length() -1) - 'a'] == 1 && name.charAt(0) == name.charAt(name.length() -1))) {
                    System.out.println(name + '!');
                    in.close();
                    return;
                }
            }
            System.out.println(playable.get(0));
        }
        in.close();
    }
}