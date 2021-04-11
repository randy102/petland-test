package pages;

import com.codeborne.selenide.SelenideElement;
import dto.UserDTO;
import element.UserElement;
import io.qameta.allure.Step;
import mock.UserMock;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static utils.Antd.selectByText;

;

public class UserPage extends BasePage implements UserElement {
    LoginPage loginPage;

    public UserPage(){
        loginPage = new LoginPage();
    }

    @Step("Open user page")
    public void openPage() {
        loginPage.loginAdmin();
        open("/admin/user");
        userGrid.shouldBe(visible);
    }

    @Step("Open create user form")
    public void openCreateForm() {
        createTab.click();
    }

    @Step("Input create user form")
    public UserDTO inputNewUser(String role) {
        UserDTO user = UserMock.basic(role);
        emailInput.sendKeys(user.email);
        passwordInput.sendKeys(user.password);
        nameInput.sendKeys(user.name);
        phoneInput.sendKeys(user.phone);
        return user;
    }

    public SelenideElement userLine(UserDTO user) {
        return $(byXpath("//tr[./td[text()='"+user.email+"']]"));
    }


    @Step("Check user line")
    public void checkLine(UserDTO created) {
        userLine(created).find(".ant-table-selection-column>label").click();
    }

    @Step("Update user's role")
    public void updateUserRole(String role) {
        selectByText(roleInput, role);
    }

    @Step("Click toggle lock button")
    public void clickToggleLockButton() {
        toggleLockButton.click();
    }
}
