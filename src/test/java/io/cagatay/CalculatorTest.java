package io.cagatay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //NAMING
    //test<System Under Test>_<Condition or State Change>_<Expected Result>
    @Test
    void testAddition_When12Addition13_ShouldReturn25() {
        Calculator calculator = new Calculator();
        int numberOne = 12;
        int numberTwo = 13;
        int expectedResult = 25;

        int actualResult = calculator.addition(numberOne, numberTwo);

        //if you write as a lambda function it will execute that line when only fail
        assertEquals(expectedResult, actualResult,
                ()-> numberOne+ " + " +numberTwo+" didnt produce "+expectedResult);

    }
}