package element;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface CategoryElement extends BaseElement{
    SelenideElement categoryForm = BaseElement.formWhichHasInputs("name");
    SelenideElement nameInput = $("#name");
    SelenideElement categoryGrid = BaseElement.gridWhichHasColumns("Tên");
}
