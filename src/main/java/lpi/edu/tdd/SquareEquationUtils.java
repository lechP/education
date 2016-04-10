package lpi.edu.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO LPI comment me
 *
 * @author Lech Piechota, Capgemini
 */
public class SquareEquationUtils {

    public List<Double> countRoots(double a, double b, double c) {
        ArrayList<Double> result = new ArrayList<>();
        double delta = b*b - 4*a*c;
        if(delta > 0) {
            result.add((-b + Math.sqrt(delta)) / (2 * a));
            result.add((-b - Math.sqrt(delta)) / (2 * a));
        } else if (delta == 0) {
            result.add(-b/(2*a));
        }
        return result;
    }
}
