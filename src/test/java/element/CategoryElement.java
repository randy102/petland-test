package element;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface CategoryElement extends BaseElement{
    SelenideElement createForm = BaseElement.formWhichHasInputs(new String[]{"name"});
    SelenideElement nameInput = $("#name");
    SelenideElement categoryGrid = BaseElement.gridWhichHasColumns(new String[]{"Tên"});
}
