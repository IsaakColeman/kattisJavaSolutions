import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BookingRoom {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] hotel = r.readLine().split(" ");
        int rooms = Integer.parseInt(hotel[0]);
        int booked = Integer.parseInt(hotel[1]);
        if(rooms <= booked) {
            System.out.println("too late");
        } else {
            boolean[] taken = new boolean[rooms+1];
            for(int i = 0; i < booked; i++) {
                taken[Integer.parseInt(r.readLine())] = true;
            }
            int i = 0;
            while(taken[++i]);
            System.out.println(i);
        }
        r.close();
    }
}