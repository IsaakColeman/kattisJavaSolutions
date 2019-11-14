import java.util.Scanner;

class ABITW {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        int layer = w;
        for(int i = 0; i < n; i++) {
            layer -= in.nextInt();
            if(layer < 0) {
                break;
            } else if(layer == 0) {
                layer = w;
                h--;
                if(h == 0) {
                    System.out.println("YES");
                    in.close();
                    return;
                }
            }
        }
        System.out.println("NO");
        in.close();
    }
}