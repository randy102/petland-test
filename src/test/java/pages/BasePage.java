package pages;

import com.codeborne.selenide.SelenideElement;
import element.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage implements BaseElement {
    public abstract void openPage();

    @Step("Open create tab")
    public void openCreateTab() {
        createTab.click();
    }

    @Step("Submit create")
    public void submitCreate() {
        createSubmitButton.click();
    }

    @Step("Submit update")
    public void submitUpdate() {
        updateSubmitButton.click();
    }

    @Step("Confirm popup")
    public void confirmModal() {
        modalOkButton.click();
    }

    @Step("Click update button")
    public void clickUpdateButton() {
        updateButton.click();
        drawerPopup.shouldBe(visible);
    }

    @Step("Click delete button")
    public void clickDeleteButton(){
        deleteButton.click();
    }

    @Step("Click refresh button")
    public void clickRefreshButton(){
        refreshButton.click();
    }

    @Step("Get grid line")
    public SelenideElement gridLine(String key) {
        return $(byXpath("//tr[./td[text()='"+key+"']]"));
    }

    @Step("Check grid line")
    public void checkLine(String key) {
        gridLine(key).find(".ant-table-selection-column>label").click();
    }

    @Step("Clear input")
    public static void clearInput(SelenideElement input){
        input.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    @Step("Clear and send keys")
    public static void clearAndSendInput(SelenideElement input, String keys){
        clearInput(input);
        input.sendKeys(keys);
    }
}
