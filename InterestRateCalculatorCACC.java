import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InterestRateCalculatorCACC {

    private static Stream<Arguments> testData() {
        return Stream.of(
                // A major clause
                Arguments.of(800, false, 9000, 7, 4.4),
                Arguments.of(800, false, 9000, 2, 8.3),

                // B major clause
                Arguments.of(800, true, 9000, 7, 8.3),
                Arguments.of(800, true, 15000, 7, 5),

                // C major clause
                Arguments.of(600, false, 9000, 7, 4.4),
                Arguments.of(600, true, 9000, 7, 8.3),

                // D major clause
                Arguments.of(800, true, 15000, 2, 5),
                Arguments.of(600, true, 15000, 2, 9.5)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testCalculateAdjustedInterestRate(int creditScore, boolean isFirstTimeBorrower, double loanAmount,
                                           int yearsEmployed, double expected) {
        double result = InterestRateCalculator.calculateAdjustedInterestRate(
                creditScore, isFirstTimeBorrower, loanAmount, yearsEmployed);
        assertEquals(expected, result, 0.001);
    }
}
