package pages;

import element.PostElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class PostPage extends BasePage implements PostElement {
    final LoginPage loginPage = new LoginPage();;

    @Override
    @Step("Open post page")
    public void openPage() {
        loginPage.loginAdmin();
        open("/admin/post");
        postGrid.shouldBe(visible);
    }

    @Step("Click verify button")
    public void clickVerifyButton(){
        verifyButton.click();
    }

    @Step("Click decline button")
    public void clickDeclineButton(){
        declineButton.click();
    }

    @Step("Input decline reason")
    public void inputDeclineReason(String reason){
        reasonInput.sendKeys(reason);
    }

}
