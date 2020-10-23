package com.amazon.pages;

import com.amazon.base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage extends Base {

        @FindBy(xpath="//a[@class='a-link-normal aok-inline-block']")
        List<WebElement> allImages;

        @FindBy(xpath="//a[@id='nav-link-accountList']/div/span")
        WebElement signInText;

        public HomePage()
        {
            //how we initialize in page factory?
            //initializing the elements
            //all elements are initialized with this driver
            PageFactory.initElements(driver,this);
        }

        public String isUserLoggedIn()
        {
            return signInText.getText();
        }


        public int heroImages()
        {
            return allImages.size();
        }

        public String getTitle()
        {
            return driver.getTitle();
        }

    }


