package element;

import com.codeborne.selenide.SelenideElement;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface BaseElement {
    SelenideElement updateButton = $(byXpath("//button[./span[text() = 'Chỉnh sửa']]"));
    SelenideElement updateSubmitButton = $(byXpath("//button[./span[text() = 'Lưu']]"));

    SelenideElement deleteButton = $(byXpath("//button[./span[text() = 'Xóa']]"));

    SelenideElement createTab = $("#rc-tabs-0-tab-add");
    SelenideElement createSubmitButton = $(byXpath("//button[./span[text() = 'Tạo']]"));

    SelenideElement drawerPopup = $(".ant-drawer-wrapper-body");

    SelenideElement modalOkButton = $(byXpath("//button[./span[text() = 'OK']]"));

    static SelenideElement formWhichHasInputs(String[] ids){
        String joinedIds = Arrays.stream(ids).map(id -> ".//input[@id='"+id+"']").collect(Collectors.joining(" and "));
        return $(byXpath("//form["+joinedIds+"]"));
    }

    static SelenideElement gridWhichHasColumns(String[] columns){
        String joinedColumns = Arrays.stream(columns).map(title -> ".//th//span[text()[contains(.,'"+title+"')]]").collect(Collectors.joining(" and "));
        return $(byXpath("//table["+joinedColumns+"]"));
    }
}
