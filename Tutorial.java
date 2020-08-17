import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Tutorial {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ");
        switch(in[2]) {
            case "1" : {
                int n = Integer.parseInt(in[1]);
                int m = Integer.parseInt(in[0]);
                double sum = n;
                for(int i = n-1; i > 1 && sum <= m; i--) {
                    sum *= i;
                }
                if(sum <= m) {
                    System.out.println("AC");
                } else {
                    System.out.println("TLE");
                }
                break;
            }
            case "2" : {
                if(Integer.parseInt(in[0]) >= Math.pow(2, Integer.parseInt(in[1]))) {
                    System.out.println("AC");
                } else {
                    System.out.println("TLE");
                }
                break;
            }
            case "3" : {
                if(Integer.parseInt(in[0]) >= Math.pow(Integer.parseInt(in[1]), 4)) {
                    System.out.println("AC");
                } else {
                    System.out.println("TLE");
                }
                break;
            }
            case "4" : {
                if(Integer.parseInt(in[0]) >= Math.pow(Integer.parseInt(in[1]), 3)) {
                    System.out.println("AC");
                } else {
                    System.out.println("TLE");
                }
                break;
            }
            case "5" : {
                if(Integer.parseInt(in[0]) >= Math.pow(Integer.parseInt(in[1]), 2)) {
                    System.out.println("AC");
                } else {
                    System.out.println("TLE");
                }
                break;
            }
            case "6" : {
                if(Math.pow(2, Double.parseDouble(in[0])/Double.parseDouble(in[1])) >= Integer.parseInt(in[1])) {
                    System.out.println("AC");
                } else {
                    System.out.println("TLE");
                }
                break;
            }
            default  : {
                if(Integer.parseInt(in[0]) >= Integer.parseInt(in[1])) {
                    System.out.println("AC");
                } else {
                    System.out.println("TLE");
                }
            }
        }
        r.close();
    }
}