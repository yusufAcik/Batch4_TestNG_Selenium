package com.krafttechnologie.tests.day7_testNG_Intro;

import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test
    public void test1(){
        System.out.println("My first test case");
    }

    // test sıralaması asci kodlarına göre
    @Test
    public void test2(){
        System.out.println("My second test case");
    }
}
