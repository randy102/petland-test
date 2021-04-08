package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    @Step("Open login page")
    public void openPage(){
        open("/login");
    }

    @Step("Click Submit Button")
    public void submit(){
        $("button[type='button']").click();
    }

    @Step("Type email and password")
    public void input(){
        $("#email").setValue("welldey102@gmail.com");
        $("#password").setValue("123456");
    }
}
