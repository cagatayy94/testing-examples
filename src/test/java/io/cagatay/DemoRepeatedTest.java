package io.cagatay;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {
    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod(){
        this.calculator = new Calculator();
        System.out.println("Executing @BeforeEach Method");
    }

    @DisplayName("Division By Zero")
    @RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of "+
    "{totalRepetitions}")
    void testDivisionMethod_WhenDivideByZero_ThrowsException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() + " of "+
                repetitionInfo.getTotalRepetitions());
        // Arrange
        int dividend = 4;
        int divider = 0;
        String exceptionMessage = "/ by zero";

        // Act & Assert
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, ()->{
            // Act
            this.calculator.divisionInteger(dividend, divider);
        }, "Must have an exception.");

        // Assert
        assertEquals(exceptionMessage, arithmeticException.getMessage(), "Unexpected exception message");
    }
}
