package com.amazon.pages;

import com.amazon.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonFeature extends Base {

    //private static Logger log = LogManager.getLogger(CommonFeature.class);

    @FindBy(css=".nav-logo-link")
    WebElement logo;

    @FindBy(css="#navFooter")
    WebElement footer;

    @FindBy(css=".navFooterMoreOnAmazon")
    WebElement footerLinks;

    @FindBy(css="#twotabsearchtextbox")
     WebElement searchBox;

    @FindBy(css="input[type='submit'")
    WebElement submitButton;


    @FindBy(css="div#nav-signin-tooltip  .nav-action-inner")
    WebElement signInButton;

    @FindBy(css="#ap_email")
    WebElement email;

    @FindBy(css="#continue")
    WebElement continueButton;

    @FindBy(css="#ap_password")
    WebElement pass;

    @FindBy(css="#signInSubmit")
    WebElement signIn;

    @FindBy(css=".a-cardui")
    List<WebElement> allImages;

     @FindBy(css="nav-hamburger-menu")
     WebElement optionsMenu;

     @FindBy(xpath = "//ul[@data-menu-id='1']")
     WebElement menuList;

     @FindBy(xpath = "//div[@id='hmenu-content']/ul[1]/li[14]")
     WebElement optionBooks;

    @FindBy(xpath = "//div[@id='hmenu-content']/ul[12]/li[13]/a ")
    WebElement kindle;


    public CommonFeature()
    {
        PageFactory.initElements(driver,this);
    }

    public void selectFromOptionMenu()
    {
       optionsMenu.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",optionBooks );
        optionBooks.click();
        js.executeScript("arguments[0].scrollIntoView();",kindle );
        kindle.click();
    }



    /*public HomePage signIn(String username, String password)
    {
       signInButton.click();
       email.sendKeys(username);
       continueButton.click();
       pass.sendKeys(password);
       signIn.click();
       //WebDriverWait wait = new WebDriverWait(driver,25);
       //wait.until(ExpectedConditions.visibilityOfAllElements(allImages));
        return new HomePage();
    }*/


    public boolean LogoDisplayed()
    {
         return logo.isDisplayed();
    }

    public boolean footerPresent()
    {
       return footer.isDisplayed();
    }

    public int footerLinksCount()
    {
        List<WebElement> getFooterLinksCount =footerLinks.findElements(By.tagName("a"));
        //log.info("Testing fo number of links in the page footer ");
        return (getFooterLinksCount.size());

    }


    public SearchPage searchFeature(String searchText,String expectedTitle)
    {
        searchBox.sendKeys(searchText);
        submitButton.click();
        return new SearchPage();
    }

}
