package pages;


import dto.CategoryDTO;
import element.CategoryElement;
import io.qameta.allure.Step;
import mock.CategoryMock;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class CategoryPage extends BasePage implements CategoryElement {
    final LoginPage loginPage = new LoginPage();;

    @Override
    @Step("Open category page")
    public void openPage() {
        loginPage.loginAdmin();
        open("/admin/category");
    }

    @Step("Input new category")
    public void inputCategoryForm(CategoryDTO created) {
        clearAndSendInput(nameInput, created.name);
    }


    @Step("Delete category")
    public void deleteCategory(CategoryDTO category){
        checkLine(category.name);
        clickDeleteButton();
        confirmModal();
        gridLine(category.name).shouldNot(exist);
    }
}
