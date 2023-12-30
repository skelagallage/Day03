package com.ucsc.automation.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupingEx {

    @BeforeGroups("regression")
    public void beforeRegression(){
        System.out.println("beforeRegression is called");
    }

    @BeforeGroups("smoke")
    public void beforeSmoke(){
        System.out.println("beforeSmoke is called");
    }

    @AfterGroups("regression")
    public void afterRegression(){
        System.out.println("afterRegression is called");
    }

    @AfterGroups("smoke")
    public void afterSmoke(){
        System.out.println("afterSmoke is called");
    }

    @Test(groups = "smoke")
    public void method1(){
        System.out.println("I'm from method1");
    }

    @Test(groups = "regression")
    public void method2(){
        System.out.println("I'm from method2");
    }

    @Test(groups = "smoke")
    public void method3(){
        System.out.println("I'm from method3");
    }

    @Test(groups = {"smoke", "regression"})
    public void method4(){
        System.out.println("I'm from method4");
    }

    @Test
    public void method5(){
        System.out.println("I'm from method5");
    }
}
