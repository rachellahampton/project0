package com.test;

import org.junit.jupiter.api.*;

public class HelloJUnitTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Hello from beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Hello from afterAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("This method will be executed before each test case in your class");
    }

    @Test
    public void helloTest1(){
        System.out.println("hello from Test1");
    }

    @Test
    public void helloTest2(){
        System.out.println("hello from Test2");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("this will be executed after each test case in the class");
    }
}
