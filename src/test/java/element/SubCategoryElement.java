package element;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public interface SubCategoryElement extends BaseElement{
    SelenideElement subCategoryForm = BaseElement.formWhichHasInputs("name","categoryID");
    SelenideElement nameInput = $("#name");
    SelenideElement categoryInput = $("#categoryID");
    SelenideElement subCategoryGrid = BaseElement.gridWhichHasColumns("Tên","Thể loại");
}
