package element;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface BaseElement {
    SelenideElement grid = $(".ant-table-container");
    SelenideElement editButton = $(byXpath("//button[./span[text() = 'Edit']]"));
    SelenideElement deleteButton = $(byXpath("//button[./span[text() = 'Delete']]"));

    SelenideElement createSubmitButton = $(byXpath("//button[./span[text() = 'Create']]"));
    SelenideElement createTab = $("#rc-tabs-0-tab-add");
    SelenideElement drawerPopup = $(".ant-drawer-wrapper-body");
    SelenideElement updateSubmitButton = $(byXpath("//button[./span[text() = 'Save']]"));
    SelenideElement modalOkButton = $(byXpath("//button[./span[text() = 'OK']]"));

//    static SelenideElement formWhichHasInputs(String[] ids){
//        String joinedIds = Arrays.stream(ids).map(id -> ".//input[@id='"+id+"']").collect(Collectors.joining(" and "));
//        return $(byXpath("//form["+joinedIds+"]"));
//    }
//
//    static SelenideElement gridWhichHasColumns(String[] columns){
//        String joinedColumns = Arrays.stream(columns).map(title -> ".//th[text()[contains(.,'"+title+"')]]").collect(Collectors.joining(" and "));
//        return $(byXpath("//table["+joinedColumns+"]"));
//    }
}