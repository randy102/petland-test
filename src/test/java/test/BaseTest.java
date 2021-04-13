package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.closeWindow;

public abstract class BaseTest<Page extends BasePage> {
    public Page page;

    @BeforeMethod
    public void openUserPage(){
        System.out.println(page);
        page.openPage();
    }

    @AfterMethod
    public void tearDown() {
        closeWindow();
    }
}
