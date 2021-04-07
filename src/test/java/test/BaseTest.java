package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import utils.Relenium;
import utils.TestListener;


public class BaseTest {
    public Relenium r;

    public BaseTest(){
        r = new Relenium();
    }

    public Relenium getR(){return r;}

    public WebDriver getD(){return getR().d;}

    public void tearDown(){
        r.quit();
    }
}