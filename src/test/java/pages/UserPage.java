package pages;

import dto.UserDTO;
import element.UserElement;
import io.qameta.allure.Step;
import mock.UserMock;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static utils.Antd.selectByText;

public class UserPage extends BasePage implements UserElement {
    final LoginPage loginPage = new LoginPage();;

    @Step("Open user page")
    public void openPage() {
        System.out.println(loginPage);
        loginPage.loginAdmin();
        open("/admin/user");
        userGrid.shouldBe(visible);
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

    @Step("Update user's role")
    public void updateUserRole(String role) {
        selectByText(roleInput, role);
    }

    @Step("Click toggle lock button")
    public void clickToggleLockButton() {
        toggleLockButton.click();
    }
}
