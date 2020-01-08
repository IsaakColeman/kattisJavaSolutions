import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class AppallingArchitecture {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(r.readLine().split(" ")[0]);
        int count = 0;
        int xWeight = 0;
        double min = 0.0;
        double max = 0.0;
        boolean smallest = true;
        for(int i = 0; i < height-1; i++) {
            char[] level = r.readLine().toCharArray();
            for(int j = 0; j < level.length; j++) {
                if(level[j] != '.') {
                    count++;
                    xWeight += j;
                }
            }
        }
        char[] level = r.readLine().toCharArray();
            for(int j = 0; j < level.length; j++) {
                if(level[j] != '.') {
                    count++;
                    xWeight += j;
                    if(smallest) {
                        min = j - 0.5;
                        smallest = false;
                    }
                    max = j + 0.5;
                }
            }
        if(count > 0) {
            double xPos = (double) xWeight/count;
            if(xPos < min) {
                System.out.println("left");
            } else if(xPos <= max) {
                System.out.println("balanced");
            } else {
                System.out.println("right");
            }
        } else {
            System.out.println("balanced");
        }
        r.close();
    }
}