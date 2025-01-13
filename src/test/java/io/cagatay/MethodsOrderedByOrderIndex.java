package io.cagatay;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD) this is default settings
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndex {
    StringBuilder executed = new StringBuilder();

    @AfterEach
    void afterEach(){
        System.out.println("executed is "+ executed);
    }

    @Order(3)
    @Test
    void testB(){
        System.out.println("Running test B");
        executed.append("4");
    }

    @Test
    @Order(2)
    void testA(){
        System.out.println("Running test A");
        executed.append("2");
    }

    @Order(1)
    @Test
    void testD(){
        System.out.println("Running test D");
        executed.append("1");
    }

    @Order(4)
    @Test
    void testC(){
        System.out.println("Running test C");
        executed.append("3");
    }
}
