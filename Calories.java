import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Calories {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" |(?=g)|(?=C)|(?=%)");
        while(!in[0].equals("-")) {
            double calories = 0.0;
            double fat = 0.0;
            while(!in[0].equals("-")) {
                int percent = 0;
                double c = 0.0;
                switch(in[1]) {
                    case "C" : {
                        fat += Integer.parseInt(in[0]);
                        c += Integer.parseInt(in[0]);
                        for(int i = 3; i < 10; i+=2) {
                            switch(in[i]) {
                                case "C" : {
                                    c += Integer.parseInt(in[i-1]);
                                    break;
                                }
                                case "g" : {
                                    if(i > 8) {
                                        c += 7*Integer.parseInt(in[i-1]);
                                    } else {
                                        c += 4*Integer.parseInt(in[i-1]);
                                    }
                                    break;
                                }
                                default  : {
                                    percent += Integer.parseInt(in[i-1]);
                                }
                            }
                        }
                        calories += c/(100-percent)*100;
                        break;
                    }
                    case "g" : {
                        fat += 9*Integer.parseInt(in[0]);
                        c += 9*Integer.parseInt(in[0]);
                        for(int i = 3; i < 10; i+=2) {
                            switch(in[i]) {
                                case "C" : {
                                    c += Integer.parseInt(in[i-1]);
                                    break;
                                }
                                case "g" : {
                                    if(i > 8) {
                                        c += 7*Integer.parseInt(in[i-1]);
                                    } else {
                                        c += 4*Integer.parseInt(in[i-1]);
                                    }
                                    break;
                                }
                                default  : {
                                    percent += Integer.parseInt(in[i-1]);
                                }
                            }
                        }
                        calories += c/(100-percent)*100;
                        break;
                    }
                    default  : {
                        int per = Integer.parseInt(in[0]);
                        percent = per;
                        for(int i = 3; i < 10; i+=2) {
                            switch(in[i]) {
                                case "C" : {
                                    c += Integer.parseInt(in[i-1]);
                                    break;
                                }
                                case "g" : {
                                    if(i > 8) {
                                        c += 7*Integer.parseInt(in[i-1]);
                                    } else {
                                        c += 4*Integer.parseInt(in[i-1]);
                                    }
                                    break;
                                }
                                default  : {
                                    percent += Integer.parseInt(in[i-1]);
                                }
                            }
                        }
                        c = c/(100-percent);
                        calories += c*100;
                        fat += per*c;
                    }
                }
                in = r.readLine().split(" |(?=g)|(?=C)|(?=%)");
            }
            System.out.println(Math.round(100*fat/calories) + "%");
            in = r.readLine().split(" |(?=g)|(?=C)|(?=%)");
        }
        r.close();
    }
}