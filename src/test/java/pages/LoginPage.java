package pages;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static element.UserElement.userGrid;

public class LoginPage extends BasePage{
    public final SelenideElement loginTitle = $(byText("Đăng nhập"));
    public final SelenideElement emailRequiredError = $(byText("Email không được để trống!"));
    public final SelenideElement passwordRequiredError = $(byText("Mật khẩu không được để trống!"));


    @Step("Open login page")
    public void openPage(){
        open("/login");
    }

    @Step("Click Submit Button")
    public void submit(){
        $("button[type='button']").click();
    }

    @Step("Type email and password")
    public void inputAdmin(){
        $("#email").setValue("welldey102@gmail.com");
        $("#password").setValue("123456");
    }

    @Step("Login with Admin")
    public void loginAdmin(){
        if (System.getProperty("page_token") == null){
            openPage();
            inputAdmin();
            submit();
            userGrid.shouldBe(visible);
            String token = localStorage().getItem("token");
            assert token != null;
            System.setProperty("page_token", token);
        } else {
            open("/");
            localStorage().setItem("token", System.getProperty("page_token"));
            openPage();
        }
    }
}
