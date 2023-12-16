package com.ucsc.automation.testng;

import org.testng.annotations.Test;

public class PriorityEx {

    @Test(priority = 2)
    public void method1(){
        System.out.println("Im from method1");
    }

    @Test(priority = 1)
    public void method2(){
        System.out.println("Im from method2");
    }

    @Test
    public void method3(){
        System.out.println("Im from method3");
    }

    @Test(priority = 3)
    public void method4(){
        System.out.println("Im from method4");
    }

    @Test(priority = 4)
    public void method5(){
        System.out.println("Im from method5");
    }
}
