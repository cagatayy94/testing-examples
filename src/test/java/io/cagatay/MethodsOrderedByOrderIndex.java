package io.cagatay;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndex {

    @Order(3)
    @Test
    void testB(){
        System.out.println("Running test B");
    }

    @Test
    @Order(2)
    void testA(){
        System.out.println("Running test A");
    }

    @Order(1)
    @Test
    void testD(){
        System.out.println("Running test D");
    }

    @Order(3)
    @Test
    void testC(){
        System.out.println("Running test C");
    }
}
