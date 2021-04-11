package element;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface BaseElement {
    SelenideElement editButton = $(byXpath("//button[./span[text() = 'Edit']]"));
    SelenideElement createSubmitButton = $(byXpath("//button[./span[text() = 'Create']]"));
    SelenideElement createTab = $("#rc-tabs-0-tab-add");
    SelenideElement drawerPopup = $(".ant-drawer-wrapper-body");
    SelenideElement updateSubmitButton = $(byXpath("//button[./span[text() = 'Save']]"));
}
