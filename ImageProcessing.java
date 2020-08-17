import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class ImageProcessing {
    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] in = r.readLine().split(" ", 4);
        int ix = Integer.parseInt(in[1]);
        int iy = Integer.parseInt(in[0]);
        int kx = Integer.parseInt(in[3]);
        int ky = Integer.parseInt(in[2]);
        int[][] i = new int[ix][iy];
        int[][] k = new int[kx][ky];
        for(int j = 0; j < iy; j++) {
            in = r.readLine().split(" ", ix);
            for(int n = 0; n < ix; n++) {
                i[n][j] = Integer.parseInt(in[n]);
            }
        }
        for(int j = ky-1; j >= 0; j--) {
            in = r.readLine().split(" ", kx);
            for(int n = 0; n < kx; n++) {
                k[kx-n-1][j] = Integer.parseInt(in[n]);
            }
        }

        StringBuilder out = new StringBuilder();
        for(int j = 0; j <= iy - ky; j++) {
            for(int n = 0; n <= ix - kx; n++) {
                int sum = 0;
                for(int y = 0; y < ky; y++) {
                    for(int x = 0; x < kx; x++) {
                        sum += k[x][y]*i[n++][j];
                    }
                    n -= kx;
                    j++;
                }
                j -= ky;
                out.append(sum + " ");
            }
            out.append("\n");
        }
        System.out.print(out);
        r.close();
    }
}