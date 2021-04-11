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

    @Step("Confirm popup")
    public void confirmModal() {
        modalOkButton.click();
    }

    @Step("Click update button")
    public void clickUpdateButton() {
        editButton.click();
    }

    @Step("Click delete button")
    public void clickDeleteButton(){
        deleteButton.click();
    };
}
