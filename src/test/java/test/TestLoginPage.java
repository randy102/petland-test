package test;

import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestListener;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners({TestListener.class})
public class TestLoginPage {
    public LoginPage page;

    @BeforeClass
    public void setup(){
        page = new LoginPage();
    }

    @AfterMethod
    public void tearDown() { closeWindow(); }


    @Test(priority = 1)
    @Story("Email and password should be required")
    public void testRequiredLogin(){
        page.openPage();
        page.submit();
        page.emailRequiredError.shouldBe(visible);
        page.passwordRequiredError.shouldBe(visible);
    }

    @Test(priority = 2)
    @Story("Admin can login")
    public void testLoginSuccessfully(){
        page.openPage();
        page.loginTitle.shouldBe(visible);
        page.inputAdmin();
        page.submit();
        page.loginTitle.shouldNot(exist);
    }
}
