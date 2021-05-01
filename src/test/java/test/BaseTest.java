package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.BasePage;
import utils.TestListener;

import static com.codeborne.selenide.Selenide.closeWindow;

@Listeners({TestListener.class})
public abstract class BaseTest<Page extends BasePage> {
    public Page page;

    @BeforeMethod
    public void openPage(){
        System.out.println(page);
        page.openPage();
    }

    @AfterMethod
    public void tearDown() {
        closeWindow();
    }
}
