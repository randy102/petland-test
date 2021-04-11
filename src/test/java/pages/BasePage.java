package pages;

import element.BaseElement;
import io.qameta.allure.Step;

public abstract class BasePage implements BaseElement {
    public abstract void openPage();

    @Step("Submit create user")
    public void submitCreate() {
        createSubmitButton.click();
    }

    @Step("Submit update user")
    public void submitUpdate() {
        updateSubmitButton.click();
    }
}
