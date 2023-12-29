package com.ucsc.automation.testng;

import org.testng.annotations.*;

public class TestNGOrder {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Im from beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Im from afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Im from beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Im from afterTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Im from beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Im from afterClass");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Im from afterMethod");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Im from beforeMethod");
    }

    @Test
    public void testMethod(){
        System.out.println("Im from testMethod");
    }

}
