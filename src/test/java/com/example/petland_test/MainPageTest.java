package com.example.petland_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.google.common.truth.Truth.*;
import static java.lang.System.getProperty;

public class MainPageTest {
    private Selenium s;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        String url = getProperty("url");
        s = new Selenium(url);
    }

    @Test
    public void testTitle() {
        String currentTitle = s.d.getTitle();
        assertThat(currentTitle).isEqualTo("Tiki");
    }

    @Test
    public void testFail(){
        assertThat(1).isEqualTo(2);
    }
}
