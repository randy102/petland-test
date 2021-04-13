package pages;


import dto.CategoryDTO;
import element.CategoryElement;
import io.qameta.allure.Step;

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
    public void inputNewCategory(CategoryDTO created) {
        nameInput.sendKeys(created.name);
    }
}
