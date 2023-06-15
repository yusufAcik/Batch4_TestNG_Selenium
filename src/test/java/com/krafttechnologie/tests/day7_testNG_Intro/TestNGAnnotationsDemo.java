package com.krafttechnologie.tests.day7_testNG_Intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {


    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Method");
    }

    @Test
    public void test1(){
        System.out.println("First assertions");
        Assert.assertEquals("Title","Title");
        System.out.println("second  assertion");
        Assert.assertEquals("url","url");
    }
// ilk assertion hata alırsa 2. çalışmaz testi bitirir

    @Test

    public void test2(){
        System.out.println("third assertion");
        Assert.assertEquals("test2","test2");
    }

    @Test
    public void test3(){
        String expectedTitle="Kraft";
        String actualTitle="Kraftech";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
    }

    @Test
    public void test4(){
        // verify that email contains @
        String email = "dwewr@kraft.tech";
        if(email.contains("@"))
        {
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        Assert.assertTrue(email.contains("@"));
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1);
        // sonuç false olması lazım
    }

    @Test
    public void test6(){
        //Assert.assertNotEquals("two","two"); // kalır
        Assert.assertNotEquals("one","two"); // geçer

    }


    }
