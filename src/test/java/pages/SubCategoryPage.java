package pages;
import dto.SubCategoryDTO;
import element.SubCategoryElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static utils.Antd.selectByText;

public class SubCategoryPage extends BasePage implements SubCategoryElement {
    final LoginPage loginPage = new LoginPage();;

    @Override
    @Step("Open subcategory page")
    public void openPage() {
        loginPage.loginAdmin();
        open("/admin/subcategory");
        subCategoryGrid.shouldBe(visible);
    }

    @Step("Input subcategory form")
    public void inputSubCategoryForm(SubCategoryDTO created) {
        selectByText(categoryInput, created.category.name);
        clearAndSendInput(nameInput, created.name);
    }
}
