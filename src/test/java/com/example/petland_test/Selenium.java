package com.example.petland_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.UUID;

public class Selenium {
    WebDriver d;

    public Selenium(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");
        d = new ChromeDriver(options);
    }

    public Selenium(String url) throws InterruptedException {
        this();
        d.get(url);
        Thread.sleep(1000);
    }

    public void input(String css, CharSequence... content){
        this.byCss(css).sendKeys(content);
    }

    public void click(String css){
        this.byCss(css).click();
    }

    public void hover(String css){
        WebElement element = byCss(css);
        Actions action = new Actions(d);
        action.moveToElement(element).perform();
    }

    public void select(String css,String value){
        Select selectList = new Select(this.byCss(css));
        selectList.selectByValue(value);
    }

    public void scrollDown(int pixel) throws InterruptedException {
        ((JavascriptExecutor) d).executeScript("window.scrollBy(0,"+pixel+")", "");
        Thread.sleep(500);
    }

    public String getUrl(){
        return d.getCurrentUrl();
    }

    public String getText(String css){
        return byCss(css).getText();
    }

    public void quit(){
        d.quit();
    }

    public WebElement byCss(String css){
        return d.findElement(By.cssSelector(css));
    }

    public List<WebElement> listByCss(String css){
        return d.findElements(By.cssSelector(css));
    }

    public static String randomStr(int len){
        return UUID.randomUUID().toString().substring(0,len).replace('-','0');
    }
}
