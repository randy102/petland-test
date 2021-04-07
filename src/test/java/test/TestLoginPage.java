package test;

import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Relenium;

import static com.google.common.truth.Truth.assertThat;

public class TestLoginPage extends BaseTest{
    private LoginPage page;

    @BeforeClass
    public void setup(){
        page = new LoginPage(getR());
    }

    @Test(priority = 0, description = "Open login page successfully")
    @Story("Admin can open login page")
    public void testOpenLoginPage(){
        page.openLoginPage();
        WebElement formTitle = getR().byCss(".title");
        assertThat(formTitle.isDisplayed()).isTrue();
    }
}
