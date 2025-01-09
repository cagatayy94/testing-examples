package io.cagatay;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Calculator class Functions")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup(){
        System.out.println("Executing @BeforeAll Method");
    }

    @AfterAll
    static void cleanUp(){
        System.out.println("Executing @AfterAll Method");
    }

    @BeforeEach
    void beforeEachTestMethod(){
        this.calculator = new Calculator();
        System.out.println("Executing @BeforeEach Method");
    }

    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Executing @AfterEach Method");
    }

    //NAMING
    //test<System Under Test>_<Condition or State Change>_<Expected Result>
    @Test
    @DisplayName("Test 12 + 13 = 25")
    void testAddition_When12Addition13_ShouldReturn25() {
        // Arrange  // Given
        int numberOne = 12;
        int numberTwo = 13;
        int expectedResult = 25;

        // Act  // When
        int actualResult = this.calculator.addition(numberOne, numberTwo);

        // Assert  // Then
        //if you write as a lambda function it will execute that line when only fail
        assertEquals(expectedResult, actualResult,
                ()-> numberOne+ " + " +numberTwo+" didnt produce "+expectedResult);

    }

    @Test
    @DisplayName("Division By Zero")
    void testDivisionMethod_WhenDivideByZero_ThrowsException() {
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

    @Test
    @DisplayName("Test 25 - 13 = 12")
    void testSubtraction_When25Subtract13_ShouldReturn12() {
        // Arrange  // Given
        int numberOne = 25;
        int numberTwo = 13;
        int expectedResult = 12;

        // Act  // When
        int actualResult = this.calculator.integerSubtraction(numberOne, numberTwo);

        // Assert  // Then
        //if you write as a lambda function it will execute that line when only fail
        assertEquals(expectedResult, actualResult,
                ()-> numberOne+ " - " +numberTwo+" didnt produce "+expectedResult);

    }


}