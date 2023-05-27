package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(priority = 3 , invocationCount = 5)
    public void test1(){
        System.out.println("I am test1");
    }
    @Test(priority = 2)
    public void test3(){
        System.out.println("I am test2");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("I am test3");
    }

}
