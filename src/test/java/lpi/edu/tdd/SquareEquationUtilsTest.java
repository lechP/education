package lpi.edu.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Lech Piechota, Capgemini
 */
public class SquareEquationUtilsTest {

    private SquareEquationUtils testedObj;

    @Before
    public void setUp(){
        testedObj = new SquareEquationUtils();
    }

    @Test
    public void countRootsFindsTwoForPositiveDelta(){

        double a = 1;
        double b = 5;
        double c = 6;

        List<Double> result = testedObj.countRoots(a,b,c);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(-2d);
        assertThat(result).contains(-3d);
    }

    @Test
    public void countRootsFindsOneForDeltaEqualToZero(){

        double a = 1;
        double b = 4;
        double c = 4;

        List<Double> result = testedObj.countRoots(a,b,c);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result).contains(-2d);
    }

    @Test
    public void countRootsReturnsEmptyListForDeltaBelowZero(){

        double a = 1;
        double b = 1;
        double c = 2;

        List<Double> result = testedObj.countRoots(a,b,c);

        assertThat(result).isEmpty();
    }

}