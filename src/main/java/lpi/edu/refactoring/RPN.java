package lpi.edu.refactoring;

import java.util.Scanner;
import java.util.StringTokenizer;

class StackNode {
    StackNode(double data, StackNode underneath) {
        this.data = data;
        this.underneath = underneath;
    }

    StackNode underneath;
    double data;
}


class RPN {

    private String command;
    private StackNode top;

    RPN(String command) {
        top = null;
        this.command = command;
    }

    private void push(double new_data) {
        top = new StackNode(new_data, top);
    }

    private double pop() {
        double top_data = top.data;
        top = top.underneath;
        return top_data;
    }

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULT = "*";
    private static final String DIV = "/";
    private static final String POW = "^";

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    double get() {

        StringTokenizer tokenizer = new StringTokenizer(command);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isNumber(token)) {
                push(Double.parseDouble(token));
            } else {
                double b = pop();
                double a = pop();
                if (PLUS.equals(token)) {
                    push(a + b);
                } else if (MINUS.equals(token)) {
                    push(a - b);
                } else if (MULT.equals(token)) {
                    push(a * b);
                } else if (DIV.equals(token)) {
                    push(a / b);
                } else if (POW.equals(token)) {
                    push(Math.pow(a, b));
                } else {
                    throw new IllegalArgumentException("illegal token in expression: " + token);
                }
            }
        }

        double val = pop();

        if (top != null) {
            throw new IllegalArgumentException("number of operations does not reflect number of operands");
        }

        return val;
    }

    /* main method */
    public static void main(String args[]) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter RPN expression or \"quit\".");
            String line = in.nextLine();
            if (line.equals("quit")) {
                break;
            } else {
                RPN calc = new RPN(line);
                System.out.printf("Answer is %f\n", calc.get());
            }
        }
    }
}

