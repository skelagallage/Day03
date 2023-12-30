package com.ucsc.automation.testng;

import org.testng.annotations.Test;

public class DependsOnEx {

    @Test(dependsOnMethods = "makeWalls")
    public void makeRoof(){
        System.out.println("makeRoof");
    }

    @Test(dependsOnMethods = {"makeFoundation"})
    public void makeWalls(){
        System.out.println("makeWalls");
    }

    @Test
    public void makeFoundation(){
        System.out.println("makeFoundation");
    }

    @Test(dependsOnMethods = {"makeWalls", "makeRoof"})
    public void makeElectricity(){
        System.out.println("makeElectricity");
    }
}
