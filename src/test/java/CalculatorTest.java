import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("2 + 3 * 4 / 2".getBytes());
        calculator = new Calculator(byteArrayInputStream);
    }

    @Test
    void calculate() {
        int result = calculator.calculate();

        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true", ";,false"}, delimiter = ',')
    void isOperator(String operateString, String expectedResult) {
        boolean expectedBool = Boolean.parseBoolean(expectedResult);

        assertThat(calculator.isOperator(operateString)).isEqualTo(expectedBool);
    }

    @Test
    void plus() {
        assertThat(calculator.plus(3)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(calculator.minus(3)).isEqualTo(-3);
    }

    @Test
    void multiple() {
        assertThat(calculator.multiple(3)).isEqualTo(0);
    }

    @Test
    void divide() {
        assertThat(calculator.divide(0)).isEqualTo(0);
    }
}
