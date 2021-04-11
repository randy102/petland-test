package test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;


public class SetupTest {
    @BeforeTest
    public void setupTest(){
        String env = System.getProperty("env");
        Configuration.browserCapabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        if(env != null && env.equals("server")){
            options.addArguments("--headless");
        }
        Configuration.browser = "chrome";
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.baseUrl = System.getProperty("url");
        Configuration.timeout = 10000;
        System.out.println("Setup Before Class");
    }
}
