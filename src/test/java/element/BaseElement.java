package element;

import com.codeborne.selenide.SelenideElement;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface BaseElement {
    SelenideElement refreshButton = buttonByText("Tải lại");

    SelenideElement updateButton = buttonByText("Chỉnh sửa");
    SelenideElement updateSubmitButton = buttonByText("Lưu");

    SelenideElement deleteButton = buttonByText("Xóa");

    SelenideElement createTab = $("#rc-tabs-0-tab-add");
    SelenideElement createSubmitButton = buttonByText("Tạo");

    SelenideElement drawerPopup = $(".ant-drawer-wrapper-body");

    SelenideElement modalOkButton = buttonByText("OK");

    static SelenideElement formWhichHasInputs(String... ids){
        String joinedIds = Arrays.stream(ids).map(id -> ".//input[@id='"+id+"']").collect(Collectors.joining(" and "));
        return $(byXpath("//form["+joinedIds+"]"));
    }

    static SelenideElement gridWhichHasColumns(String... columns){
        String joinedColumns = Arrays.stream(columns).map(title -> ".//th//span[text()[contains(.,'"+title+"')]]").collect(Collectors.joining(" and "));
        return $(byXpath("//table["+joinedColumns+"]"));
    }

    static SelenideElement buttonByText(String text){
        return  $(byXpath("//button[./span[text() = '"+text+"']]"));
    }
}
