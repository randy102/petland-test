package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import utils.Relenium;
import utils.TestListener;


public interface BaseTest {
    public Relenium r = null;
}
