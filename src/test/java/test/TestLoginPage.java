package test;

import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Relenium;
import utils.TestListener;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@Listeners({TestListener.class})
public class TestLoginPage extends BaseTest{
    public LoginPage page;

    @BeforeClass
    public void setup(){
        super.setup();
        page = new LoginPage(r);
    }

    @Test(description = "Open login page successfully")
    @Story("Admin can open login page")
    public void testOpenLoginPage(){
        page.openLoginPage();
        WebElement formTitle = r.byCss(".title");
        assertThat(formTitle.isDisplayed()).isTrue();
    }

    @Test(priority = 1, description = "Email and password should required")
    @Story("Admin must input email and password")
    public void testRequiredLogin(){
        page.submit();
        WebElement emailError =  r.byXpath("//div[contains(text(),\"'Email' is required!\")]");
        WebElement passwordError =  r.byXpath("//div[contains(text(),\"'Password' is required!\")]");

        assertThat(emailError.isDisplayed()).isTrue();
        assertThat(passwordError.isDisplayed()).isTrue();
    }
}
