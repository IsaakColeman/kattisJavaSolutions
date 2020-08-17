import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.HashSet;

class Chess {
    int x;
    int y;

    public Chess(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Chess c = (Chess) obj;
        return this.x == c.x && this.y == c.y;
    }

    @Override
    public int hashCode() {
        return this.x * this.y;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String[] in = r.readLine().split(" ");
            if(in[0].equals(in[2]) && in[1].equals(in[3])) {
                out.append("0 " + in[0] + " " + in[1] + "\n");
            } else {
                int x1 = in[0].charAt(0) - 'A';
                int y1 = Integer.parseInt(in[1]) -1;
                int x2 = in[2].charAt(0) - 'A';
                int y2 = Integer.parseInt(in[3]) -1;
                if(x1 - x2 == y1 - y2 || x1 - x2 == y2 - y1) {
                    out.append("1 " + in[0] + " " + in[1] + " " + in[2] + " " + in[3] + "\n");
                } else if((x1 + y1)%2 == (x2 + y2)%2) {
                    HashSet<Chess> diag = new HashSet<Chess>();
                    int xt = x1;
                    int yt = y1;
                    for(int j = 0; j < 8; j++) {
                        diag.add(new Chess(x1++, y1++));
                        diag.add(new Chess(xt--, yt++));
                        if(x1 > 7) {
                            if(x1 == y1) {
                                x1 = 0;
                                y1 = 0;
                            } else {
                                x1 = 8 - y1;
                                y1 = 0;
                            }
                        }
                        if(y1 > 7) {
                            y1 = 8 - x1;
                            x1 = 0;
                        }
                        if(xt < 0) {
                            if(yt == 8) {
                                xt = 7;
                                yt = 0;
                            } else {
                                xt = yt -1;
                                yt = 0;
                            }
                        }
                        if(yt > 7) {
                            yt = xt +1;
                            xt = 7;
                        }
                    }
                    xt = x2;
                    yt = y2;
                    for(int j = 0; j < 8; j++) {
                        if(diag.contains(new Chess(x2++, y2++))) {
                            out.append("2 " + in[0] + " " + in[1] + " " + Character.toString(x2 -1 + 'A') + " " + y2 + " " + in[2] + " " + in[3] + "\n");
                            break;
                        } else if(diag.contains(new Chess(xt--, yt++))) {
                            out.append("2 " + in[0] + " " + in[1] + " " + Character.toString(xt +1 + 'A') + " " + yt + " " + in[2] + " " + in[3] + "\n");
                            break;
                        }
                        if(x2 > 7) {
                            if(x2 == y2) {
                                x2 = 0;
                                y2 = 0;
                            } else {
                                x2 = 8 - y2;
                                y2 = 0;
                            }
                        }
                        if(y2 > 7) {
                            y2 = 8 - x2;
                            x2 = 0;
                        }
                        if(xt < 0) {
                            if(yt == 8) {
                                xt = 7;
                                yt = 0;
                            } else {
                                xt = yt -1;
                                yt = 0;
                            }
                        }
                        if(yt > 7) {
                            yt = xt +1;
                            xt = 7;
                        }
                    }
                } else {
                    out.append("Impossible\n");
                }
            }
            // diff diag
        }
        System.out.print(out);
        r.close();
    }
}