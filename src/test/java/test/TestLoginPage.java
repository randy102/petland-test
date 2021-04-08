package test;

import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestListener;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Listeners({TestListener.class})
public class TestLoginPage {
    public LoginPage page;

    @BeforeClass
    public void setup(){
        page = new LoginPage();
    }

    @Test
    @Story("Admin can open login page")
    public void testOpenLoginPage(){
        page.openPage();
        $(".title").shouldBe(visible);
    }

    @Test(priority = 1)
    @Story("Admin must input email and password")
    public void testRequiredLogin(){
        page.openPage();
        page.submit();
        $(byText("'Email' is required!")).shouldBe(visible);
        $(byText("'Password' is required!")).shouldBe(visible);
    }

    @Test(priority = 2)
    @Story("Admin can login")
    public void testLoginSuccessfully(){
        page.openPage();
        page.input();
        page.submit();
        $(byText("Login")).should(exist);
    }
}
