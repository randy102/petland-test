package utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Antd {
    public static void selectByText(SelenideElement input, String text){
        String id = input.getAttribute("id");
        $(byXpath("//div[contains(@class, 'ant-select-selector') and .//input[@id='"+id+"']]")).click();
        $(byXpath("//div[contains(@class,'ant-select-item-option')][@label='"+ text +"']")).click();
    }

    public static SelenideElement selectedItem(SelenideElement input){
        String id = input.getAttribute("id");
        return $(byXpath("//div[contains(@class, 'ant-select-selector') and .//input[@id='"+id+"']]/span[contains(@class, 'ant-select-selection-item')]"));
    }
}
