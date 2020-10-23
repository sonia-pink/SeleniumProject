package com.amazon.pages;

import com.amazon.base.Base;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Base {

    public SearchPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String checkTitle()
    {
       return driver.getTitle();
    }



}
