package io.cagatay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Calculator class Functions")
class CalculatorTest {

    //NAMING
    //test<System Under Test>_<Condition or State Change>_<Expected Result>
    @Test
    @DisplayName("Test 12 + 13 = 25")
    void testAddition_When12Addition13_ShouldReturn25() {
        // Arrange  // Given
        Calculator calculator = new Calculator();
        int numberOne = 12;
        int numberTwo = 13;
        int expectedResult = 25;

        // Act  // When
        int actualResult = calculator.addition(numberOne, numberTwo);

        // Assert  // Then
        //if you write as a lambda function it will execute that line when only fail
        assertEquals(expectedResult, actualResult,
                ()-> numberOne+ " + " +numberTwo+" didnt produce "+expectedResult);

    }
}