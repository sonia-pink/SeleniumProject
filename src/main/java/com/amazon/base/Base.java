package com.amazon.base;

import com.amazon.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

        public static WebDriver driver;
        public static Properties prop;
        public static EventFiringWebDriver event_Driver;
        public static WebEventListener eventListener;

        //Read the properties
        public Base() {

            try {
                prop = new Properties();
                FileInputStream fip = new FileInputStream("/Users/ev/Desktop/sonia-workspaces/MyWork/SeleniumFrameworkFinal/src/main/java/com/amazon/config/config.properties");
                prop.load(fip);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

        public static void initialization()
        {
            String browserName = prop.getProperty("browser");
            if(browserName.equals("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", "/Users/ev/Desktop/sonia-workspaces/MyWork/SeleniumFrameworkFinal/src/main/resources/chromedriver");
                driver = new ChromeDriver();
            }
            else if(browserName.equals("firefox"))
            {
                System.setProperty("webdriver.chrome.driver", "/Users/ev/Desktop/sonia-workspaces/MyWork/SeleniumFrameworkFinal/src/main/resources/geckodriver");
                driver = new FirefoxDriver();
            }

            /*event_Driver = new EventFiringWebDriver(driver);
            eventListener = new WebEventListener();
            event_Driver.register(eventListener);
            driver = event_Driver;*/

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));

        }
}

