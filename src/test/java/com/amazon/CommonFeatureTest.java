package com.amazon;

import com.amazon.base.Base;
import com.amazon.pages.CommonFeature;
import com.amazon.pages.HomePage;
import com.amazon.pages.SearchPage;
import com.amazon.util.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class CommonFeatureTest extends Base
{
    HomePage hp;
    CommonFeature cf;
    SearchPage sp;
    Utilities sheet1 ;

    String userDir =System.getProperty("user.dir");
    String filePath = userDir + "/src/main/resources" ;
    String fileName = "testData9.xlsx" ;
    String sheetName ="Sheet 1";

    public CommonFeatureTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        hp = new HomePage();
        cf = new CommonFeature();
        sheet1 = new Utilities();
    }


    @Test()
    public void isLogoDisplayed()
    {
        boolean logo = cf.LogoDisplayed();
        Assert.assertTrue(logo);
        System.out.println("Logo is Displayed");

    }

    /*@Parameters({"Username","Password"})
    @Test()
    public void isUserLoggedInTest(String username, String password)
    {
        hp = cf.signIn(username,password);
        String text = hp.isUserLoggedIn();
        Assert.assertEquals(text,"Hello, Roses","Not logged in to user account");
    }

    @Parameters({"Username","Password"})
    @Test()
    public void selectItems(String username, String password)
    {
        hp = cf.signIn(username,password);
        cf.selectFromOptionMenu();

    }
*/


    @Test()
    public void isFooterVisible()
    {
        boolean footer = cf.footerPresent();
        Assert.assertTrue(footer);
        System.out.println("Footer is visible");
    }

    @Test
    public void footerLinksCountTest()
    {
        int count = cf.footerLinksCount();
        Assert.assertEquals(count,41);
        System.out.println("link count match");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        sheet1 = new Utilities();
        Object data[][] = sheet1.readExcel(filePath,fileName,sheetName);
        return data;
    }

    @Test(dataProvider = "getData")
    public void search(String searchText,String expectedTitle)
    {
        sp = cf.searchFeature(searchText, expectedTitle);
        String title = sp.checkTitle();
        Assert.assertEquals(title,expectedTitle,"Search page title did not match");
        System.out.println("Title matched");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
