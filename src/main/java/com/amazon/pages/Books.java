package com.amazon.pages;

import com.amazon.base.Base;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Books extends Base {

    //@FindBy()



    public Books()
    {
        PageFactory.initElements(driver,this);

    }



}
