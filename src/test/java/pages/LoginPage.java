package pages;

import io.qameta.allure.Step;
import utils.Relenium;

public class LoginPage extends BasePage{
    public LoginPage(Relenium r){
        super(r);
    }

    @Step("Open login page")
    public void openLoginPage(){
        this.to("/login");
    }

    @Step("Click Submit Button")
    public void submit(){
        r.click("button[type='button']");
    }
}
