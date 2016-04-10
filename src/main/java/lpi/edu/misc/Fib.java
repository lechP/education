package lpi.edu.misc;

import javax.swing.*;

/**
 * Created by LPI on 06.03.2016
 */
public class Fib {
    public static void main(String[] args) {
        boolean ok = false;
        int x = 0; //zmieniam double na int bo potrzebujemy liczby calkowitej
        do {
            ok = true;
            x = downloadNumber("  Write down the number > 0");
            if (x < 0) {
                JOptionPane.showMessageDialog
                        (null, "You assumed number = " + x +
                                        "\nvalue must be positive number!", "Wrong data",
                                JOptionPane.WARNING_MESSAGE);
                ok = false;
            }
        } while (!ok);

        //nie potrzebujemy juz zadnych ifów, bo jesli wyszlismy z petli, to mamy liczbe dodatnia, a dla kazdej liczby dodatniej nasza funkcja rekurencyjna sobie poradzi

        JOptionPane.showMessageDialog
                        //jak tu podales jakas literke 't', to kompilator nie mial w ogole pojecia o co ci chodzi, musisz wywolac jakas okreslona funkcje lub zadeklarowan? zmienn?
                (null, " For number equal to ( " + x + " ) value of Fibonacci is: " + Recursion(x), "Fibonacci",
                        JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

    private static int Recursion(int n) { //nie mozesz jako typu zwracanego ustawic 'void' jesli chcesz zwrocic jakas liczbe
        //w metodzie rekurencyjnej potrzebujesz jakies warunki brzegowe, inaczej bedzie sie wykonywala w nieskonczonosc
        if (n == 0) { //jesli n jest zerem to zwroc 0
            return 0;
        } else if (n == 1) { //jesli 1 to 1
            return 1;
        } else { //a dopiero jak cos wiekszego, to uzywamy rekurencji
            return Recursion(n - 1) + Recursion(n - 2);
        }
    }

    public static int downloadNumber(String Numberdescription) {
        String signNumber = "";
        int number = 0;
        boolean ok = false;
        do
            try {
                signNumber = JOptionPane.showInputDialog(Numberdescription);
                number = Integer.parseInt(signNumber);
                ok = true;
            } catch (NullPointerException e)

            {
            } while (!ok);
        return number;
    }

}
