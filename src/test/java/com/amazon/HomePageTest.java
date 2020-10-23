package com.amazon;

import com.amazon.base.Base;
import com.amazon.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends Base {

    HomePage hp;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        hp = new HomePage();
    }

    @Test()
    public void heroImagesCountTest() {
        int count = hp.heroImages();
        System.out.println("TOTAL IMAGES " + count);
        Assert.assertEquals(count, 8);
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}