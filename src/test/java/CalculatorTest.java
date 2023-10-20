import org.example.exercise2.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    static Calculator calculator;


    @BeforeAll
    public static void setup() { calculator = new Calculator();}


    @ParameterizedTest
    @ValueSource(ints = {3, 23, 311, 487, 653, 947})
    public void isPrime_ShouldReturnTrueForPrimeNumbers(int number) {
        assertTrue(calculator.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 64, 2, 20, 30, 26})
    public void isEven_ShouldReturnTrueForEvenNumbers(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({"23, 23", "46, 23", "115, 23", "184, 23", "207, 23", "230, 23" })
    public void isMultipleTest(int number, int divisor) {
        assertTrue(calculator.isMultiple(number, divisor));
    }
}
