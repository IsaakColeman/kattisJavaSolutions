import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;

class Car {
    double price;
    int pickup;
    int drive;

    public Car(String[] in) {
        this.price = Double.parseDouble(in[0]);
        this.pickup = Integer.parseInt(in[1]);
        this.drive = Integer.parseInt(in[2]);
    }
}

class Spy {
    private enum State {NONE, DRIVE, ILLEGAL}
    int bill;
    Car car;
    State state;

    public Spy() {
        this.state = State.ILLEGAL;
    }

    public Spy(Car c) {
        this.state = State.DRIVE;
        this.car = c;
        this.bill = this.car.pickup;
    }

    public void acc(int per) {
        if(this.state == State.DRIVE) {
            this.bill += Math.ceil(this.car.price*per/100);
        } else {
            this.state = State.ILLEGAL;
        }
    }

    public void pick(Car c) {
        if(this.state == State.NONE) {
            this.state = State.DRIVE;
            this.car = c;
            this.bill += this.car.pickup;
        } else {
            this.state = State.ILLEGAL;
        }
    }

    public void ret(int d) {
        if(this.state == State.DRIVE) {
            this.bill += this.car.drive*d;
            this.state = State.NONE;
        } else {
            this.state = State.ILLEGAL;
        }
    }

    @Override
    public String toString() {
        return this.state == State.NONE ? Integer.toString(this.bill) : "INCONSISTENT";
    }
}

class AdminProb {

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        for(int j = 0; j < t; j++) {
            String[] lines = r.readLine().split(" ");
            HashMap<String, Car> cars = new HashMap<String, Car>();
            HashMap<String, Spy> spies = new HashMap<String, Spy>();
            for(int i = 0; i < Integer.parseInt(lines[0]); i++) {
                String[] in = r.readLine().split(" ", 2);
                cars.put(in[0], new Car(in[1].split(" ")));
            }
            for(int i = 0; i < Integer.parseInt(lines[1]); i++) {
                String[] in = r.readLine().split(" ");
                Spy temp = spies.get(in[1]);
                if(temp != null) {
                    switch(in[2]) {
                        case "p" : temp.pick(cars.get(in[3])); break;
                        case "a" : temp.acc(Integer.parseInt(in[3])); break;
                        default  : temp.ret(Integer.parseInt(in[3]));
                    }
                } else if(in[2].equals("p")) {
                    spies.put(in[1], new Spy(cars.get(in[3])));
                } else {
                    spies.put(in[1], new Spy());
                }
            }
            Object[] keys = spies.keySet().toArray();
            Arrays.sort(keys);
            for(Object s : keys) {
                System.out.println(s + " " + spies.get(s).toString());
            }
        }
        r.close();
    }
}