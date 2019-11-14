import java.util.ArrayDeque;
import java.util.Scanner;

class four {
    static String operators = "+-*/";

    static int order(char c) {
        switch(c) {
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            default: return 2;
        }
    }

    static private void processOp(char op, ArrayDeque<Integer> numStack) {
        int B = numStack.pop();
        int A = numStack.pop();
        switch(op) {
            case '+': numStack.push(A + B); break;
            case '-': numStack.push(B - A); break;
            case '*': numStack.push(A * B); break;
            default: numStack.push(B / A); break;
        }
     }

    static int calcExp(char[] ops) {
        ArrayDeque<Integer> numStack = new ArrayDeque<Integer>();
        numStack.push(4);
        ArrayDeque<Character> opStack = new ArrayDeque<Character>();
        for(int i = 2; i >= 0; i--) {
            if(opStack.isEmpty() || order(ops[i]) > order(opStack.peekFirst())) {
                opStack.push(ops[i]);
            } else {
                while(!opStack.isEmpty() && order(ops[i]) < order(opStack.peekFirst())) {
                    processOp(opStack.pop(), numStack);
                }
                opStack.push(ops[i]);
            }
            numStack.push(4);
        }
        while(!opStack.isEmpty()) {
            processOp(opStack.pop(), numStack);
        }
        return numStack.pop();
    }

    static void bruteForce(int target) {
        char[] ops = new char[3];
        for(int a = 0; a < 4; a++) {
            ops[2] = operators.charAt(a);
            for(int b = 0; b < 4; b++) {
                ops[1] = operators.charAt(b);
                for(int c = 0; c < 4; c++) {
                    ops[0] = operators.charAt(c);
                    try {
                        if(calcExp(ops) == target) {
                            System.out.println("4 " + ops[0] + " 4 " + ops[1] + " 4 " + ops[2] + " 4 = " + target);
                            return;
                        }
                    } catch(Exception ex) {
                        continue;
                    }
                }
            }
        }
        System.out.println("no solution");
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int sum = in.nextInt();
            if(sum == 256) {System.out.println("4 * 4 * 4 * 4 = 256"); continue;}
            if(sum < -60 || sum > 68) {System.out.println("no solution"); continue;}
            bruteForce(sum);
        }
        in.close();
    }
}