package lpi.edu.misc;

public class RecursionDemo {

    public static void main(String[] args) {

        System.out.println("Let's try recursion with positive parameter: ");
        iAmRecursive(10);

        System.out.println("\n\n\nAnd now with zero: ");
        iAmRecursive(0);

        System.out.println("\n\n\nAnd at last with negative one: ");
        iAmRecursive(-3);
    }

    private static void iAmRecursive(int counter){
        System.out.println("\nI'm now called with parameter: " + counter);
        if(counter < 0){
            System.out.println("WTF?! Negative argument is illegal!!!!");
        } else if (counter == 0) {
            System.out.println("Counter is 0. It's time to shut down. Bye!");
        } else {
            System.out.println("Counter is positive. I'm gonna call myself again with the counter lowered by 1...");
            iAmRecursive(counter - 1);
        }
    }

}
