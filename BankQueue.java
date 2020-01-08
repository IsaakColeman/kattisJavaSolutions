import java.util.Scanner;

class BankQueue {

    private static void swapLarger(int[] arr, int index, int value) {
        for(int i = index; i >= 0; i--) {
            if(arr[i] < value) {
                swapLarger(arr, i-1, arr[i]);
                arr[i] = value;
                return;
            }
        }
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] largest = new int[t+1];
        for(int j = 0; j < n; j++) {
            int value = in.nextInt();
            int time = in.nextInt();
            swapLarger(largest, time > t ? t : time, value);
        }
        int sum = 0;
        for(int i = 0; i < largest.length; i++) {
            sum += largest[i];
        }
        System.out.println(sum);
        in.close();
    }
}