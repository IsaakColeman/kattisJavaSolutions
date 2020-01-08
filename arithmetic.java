import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Arithmetic{

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        char[] input = r.readLine().toCharArray();
        boolean[] out = new boolean[3*input.length + input.length%4];
        int i = input.length%4;
        for(char c : input) {
            int temp = c - '0';
            out[i++] = (temp&4) == 4;
            out[i++] = (temp&2) == 2;
            out[i++] = (temp&1) == 1;
        }
        StringBuilder ans = new StringBuilder(out.length/4);
        if(out[0]) {
            if(out[1]) {
                if(out[2]) {
                    if(out[3]) {
                        ans.append("F");
                    } else {
                        ans.append("E");
                    }
                } else if(out[3]) {
                    ans.append("D");
                } else {
                    ans.append("C");
                }
            } else if(out[2]) {
                if(out[3]) {
                    ans.append("B");
                } else {
                    ans.append("A");
                }
            } else if(out[3]) {
                ans.append("9");
            } else {
                ans.append("8");
            }
        } else if(out[1]) {
            if(out[2]) {
                if(out[3]) {
                    ans.append("7");
                } else {
                    ans.append("6");
                }
            } else if(out[3]) {
                ans.append("5");
            } else {
                ans.append("4");
            }
        } else if(out[2]) {
            if(out[3]) {
                ans.append("3");
            } else {
                ans.append("2");
            }
        } else if(out[3]) {
            ans.append("1");
        } else if(out.length < 8) {
            ans.append("0");
        }
        for(i = 4; i < out.length-3; i += 4) {
            if(out[i]) {
                if(out[i+1]) {
                    if(out[i+2]) {
                        if(out[i+3]) {
                            ans.append("F");
                        } else {
                            ans.append("E");
                        }
                    } else if(out[i+3]) {
                        ans.append("D");
                    } else {
                        ans.append("C");
                    }
                } else if(out[i+2]) {
                    if(out[i+3]) {
                        ans.append("B");
                    } else {
                        ans.append("A");
                    }
                } else if(out[i+3]) {
                    ans.append("9");
                } else {
                    ans.append("8");
                }
            } else if(out[i+1]) {
                if(out[i+2]) {
                    if(out[i+3]) {
                        ans.append("7");
                    } else {
                        ans.append("6");
                    }
                } else if(out[i+3]) {
                    ans.append("5");
                } else {
                    ans.append("4");
                }
            } else if(out[i+2]) {
                if(out[i+3]) {
                    ans.append("3");
                } else {
                    ans.append("2");
                }
            } else if(out[i+3]) {
                ans.append("1");
            } else {
                ans.append("0");
            }
        }
        System.out.println(ans);
        r.close();
    }
}