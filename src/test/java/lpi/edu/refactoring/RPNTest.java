package lpi.edu.refactoring;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNTest {

    @Test
    public void shouldProcessSimpleAddition() throws Exception {
        String operation = "2 3 +";
        double result = new RPN(operation).get();
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void shouldProcessSimpleSubtraction() throws Exception {
        String operation = "2 3 -";
        double result = new RPN(operation).get();
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldProcessSimpleMultiplication() throws Exception {
        String operation = "2 3 *";
        double result = new RPN(operation).get();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldProcessSimpleDivision() throws Exception {
        String operation = "2 3 /";
        double result = new RPN(operation).get();
        assertThat(result).isEqualTo(2.0 / 3);
    }

    @Test
    public void shouldProcessSimplePowerOperation() throws Exception {
        String operation = "2 3 ^";
        double result = new RPN(operation).get();
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void shouldProcessDoubleWithLongTail() throws Exception {
        //given
        String operation = "12.3456789 1.6543211 +";
        //when
        double result = new RPN(operation).get();
        //then
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void shouldHandleManySpaces() throws Exception {
        //given
        String operation = "    2       1    -     ";
        //when
        double result = new RPN(operation).get();
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldProcessComplexOperation() throws Exception {
        //given
        String operation = "2 3 6 * + 15 5 / - 2 3 4 + + +";
        //when
        double result = new RPN(operation).get();
        //then
        assertThat(result).isEqualTo(2 + 3 * 6 - 15 / 5 + 2 + 3 + 4);
    }
}