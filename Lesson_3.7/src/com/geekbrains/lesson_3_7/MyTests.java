package com.geekbrains.lesson_3_7;

public class MyTests {

//    @BeforeSuite
//    public static void beforeSuitTest_1() {
//        System.out.println("Exception must be thrown - more than one @BeforeSuite");
//    }

    @BeforeSuite
    public static void beforeSuitTest() {
        System.out.println("BeforeSuit test");
    }

    @Test
    public static void firstTest() {
        System.out.println("First test");
    }

    @Test(priority = 4)
    public static void secondTest() {
        System.out.println("Second test, but priority = 4");
    }

    @Test(priority = 6)
    public static void thirdTest() {
        System.out.println("Third test, but priority = 6");
    }

    @AfterSuite
    public static void afterSuiteTest() {
        System.out.println("AfterSuite test");
    }

//    @AfterSuite
//    public static void afterSuiteTest_2() {
//        System.out.println("Exception must be thrown - more than one @AfterSuite");
//    }
}
