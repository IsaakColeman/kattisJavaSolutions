import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.lang.StringBuilder;

class C {
    String s;
    int n;

    public C(String s) {
        this.s = s;
        this.n = 1;
    }
}

class BasicProgramming2 {

    public static int[] intArray(BufferedReader r, int n) throws IOException {
        String[] snum = r.readLine().split(" ", n);
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(snum[i]);
        }
        return nums;
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ", 2);
        int n = Integer.parseInt(in[0]);
        switch(in[1]) {
            case "1" : {
                int[] nums = intArray(r, n);
                Arrays.sort(nums);
                int i = 0;
                int j = n-1;
                while(i < j) {
                    while(nums[i] + nums[j] > 7777 && i < j) {
                        j--;
                    }
                    if(nums[i] + nums[j] == 7777 && i < j++) {
                        System.out.println("Yes");
                        break;
                    }
                    i++;
                }
                if(i >= j) {
                    System.out.println("No");
                }
                break;
            }
            case "2" : {
                String[] snum = r.readLine().split(" ", n);
                boolean unique = true;
                HashSet<String> stuff = new HashSet<String>(n);
                for(int i = 0; i < n; i++) {
                    if(!stuff.add(snum[i])) {
                        unique = false;
                        break;
                    }
                }
                if(unique) {
                    System.out.println("Unique");
                } else {
                    System.out.println("Contains duplicate");
                }
                break;
            }
            case "3" : {
                String[] snum = r.readLine().split(" ", n);
                HashMap<String, C> map = new HashMap<String, C>(n);
                for(String s : snum) {
                    C temp = map.get(s);
                    if(temp == null) {
                        map.put(s, new C(s));
                    } else {
                        temp.n++;
                    }
                }
                n >>= 1;
                int out = -1;
                for(C c : map.values()) {
                    if(c.n > n) {
                        out = Integer.parseInt(c.s);
                        break;
                    }
                }
                System.out.println(out);
                break;
            }
            case "4" : {
                int[] nums = intArray(r, n);
                Arrays.sort(nums);
                if(n%2 == 0) {
                    System.out.printf("%d %d\n", nums[(n-1) >> 1], nums[n >> 1]);
                } else {
                    System.out.println(nums[n >> 1]);
                }
                break;
            }
            default  : {
                int[] nums = intArray(r, n);
                Arrays.sort(nums);
                StringBuilder out = new StringBuilder(1024);
                int i = 0;
                while(i < n && nums[i] < 100) {
                    i++;
                }
                for(i = i; i < n; i++) {
                    if(nums[i] < 1000) {
                        out.append(nums[i]);
                        out.append(" ");
                    } else {
                        break;
                    }
                }
                System.out.println(out);
            }
        }
        r.close();
    }
}