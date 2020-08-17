import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.lang.StringBuilder;
import java.util.Arrays;

class Golombrulers {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder(64000);
        do {
            String[] in = r.readLine().split(" ");
            int[] nums = new int[in.length];
            for(int i = 0; i < in.length; i++) {
                nums[i] = Integer.parseInt(in[i]);
            }
            Arrays.sort(nums);
            boolean ruler = true;
            HashSet<Integer> div = new HashSet<Integer>(in.length << 2);
            for(int i = 0; i < nums.length -1 && ruler; i++) {
                for(int j = i+1; j < nums.length; j++) {
                    if(!div.add(nums[j] - nums[i])) {
                        ruler = false;
                        break;
                    }
                }
            }
            if(ruler && div.size() == nums[nums.length -1]) {
                out.append("perfect\n");
            } else if(ruler) {
                out.append("missing");
                for(int i = 1; i <= nums[nums.length -1]; i++) {
                    if(!div.contains(i)) {
                        out.append(" ");
                        out.append(i);
                    }
                }
                out.append("\n");
            } else {
                out.append("not a ruler\n");
            }
        } while(r.ready());
        System.out.print(out);
        r.close();
    }
}