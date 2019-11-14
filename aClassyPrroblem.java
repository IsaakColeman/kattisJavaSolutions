import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Collections;

class ClassyPerson implements Comparable<ClassyPerson>{
    private Pattern p = Pattern.compile("([a-zA-Z]+): ([a-z\\-]+) class");
    public String name;
    public int value;

    ClassyPerson(String desc) {
        Matcher m = p.matcher(desc);
        m.find();
        this.name = m.group(1);
        this.value = findValue(m.group(2));
    }

    private static int findValue(String desc) {
        String[] parts = desc.split("-");
        int value = 0;
        for(int i = parts.length -1; i >= 0; i--) {
            value <<= 2;
            value += valueOf(parts[i]);
        }
        for(int i = 0; i < 10 - parts.length; i++) {
            value <<= 2;
            value += valueOf("middle");
        }
        return value;
    }

    private static int valueOf(String desc) {
        switch(desc) {
            case "middle": return 2;
            case "upper": return 3;
            default: return 1;
        }
    }

    public int compareTo(ClassyPerson p) {
        if(this.value < p.value) {return 1;}
        if(this.value > p.value) {return -1;}
        return this.name.compareTo(p.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class ACP {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int j = 0; j < cases; j++) {
            int n = in.nextInt();
            in.nextLine();
            ArrayList<ClassyPerson> people = new ArrayList<ClassyPerson>();
            for(int i = 0; i < n; i++) {
                people.add(new ClassyPerson(in.nextLine()));
            }
            Collections.sort(people);
            for(ClassyPerson p : people) {
                System.out.println(p);
            }
            System.out.println("==============================");
        }
        in.close();
    }
}