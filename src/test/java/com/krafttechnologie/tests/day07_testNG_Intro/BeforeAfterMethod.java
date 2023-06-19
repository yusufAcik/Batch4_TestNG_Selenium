package com.krafttechnologie.tests.day07_testNG_Intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeMethod
    public void setUp(){
        System.out.println("*************before method***************");
        System.out.println("Webdriver, opening browser");
    }
    @Test (priority = 2)
    public  void test1(){
        System.out.println("First test case");
    }

    //@Test yada @Ignore ignore daha kullanılışlı
    @Test (priority = 3)
    public  void test2(){
        System.out.println("second test case");
    }
    @Test (priority = 1)
    public  void test3(){
        System.out.println("third test case");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("***************after method**************");
        System.out.println("closing browser, quit");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("----before class-----");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-------after class-------");
    }

}
