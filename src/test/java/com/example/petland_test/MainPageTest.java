package com.example.petland_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.google.common.truth.Truth.*;


public class MainPageTest {
    private Selenium s;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        s = new Selenium("https://tiki.vn/");
    }

    @AfterMethod
    public void tearDown() {
        s.quit();
    }

    @Test
    public void testTitle() {
        String currentTitle = s.d.getTitle();
        assertThat(currentTitle).isEqualTo("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
    }
}
