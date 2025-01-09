package io.cagatay;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"John", "Caca", "Alice"})
    void valueSourceDemonstration(String firstname){
        System.out.println(firstname);
        assertNotNull(firstname);
    }


    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
    //@MethodSource()
    /*
    @CsvSource({
            "33, 1, 32",
            "55, 12, 43",
            "54, 1, 53",
    })
     */
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {

        System.out.println("Running test "+minuend+" - "+subtrahend+" = "+expectedResult);

        // Act  // When
        int actualResult = this.calculator.integerSubtraction(minuend, subtrahend);

        // Assert  // Then
        //if you write as a lambda function it will execute that line when only fail
        assertEquals(expectedResult, actualResult,
                ()-> minuend+ " - " +subtrahend+" didnt produce "+expectedResult);

    }
/*
    private static Stream<Arguments> integerSubtraction (){
        return Stream.of(
                Arguments.of(25, 13, 12),
                Arguments.of(24, 1, 23),
                Arguments.of(54, 14, 40),
                Arguments.of(25, 12, 13)
        );
    }

*/
}