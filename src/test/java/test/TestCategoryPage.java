package test;

import dto.CategoryDTO;
import io.qameta.allure.Story;
import mock.CategoryMock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CategoryPage;

import static com.codeborne.selenide.Condition.*;

public class TestCategoryPage extends BaseTest<CategoryPage> {
    CategoryDTO created;
    final CategoryDTO updated = CategoryMock.basic();

    @BeforeClass
    public void setup() {
        page = new CategoryPage();
    }

    @Test
    @Story("Admin can add category")
    public void testAddCategory(){
        created = CategoryMock.basic();
        page.openCreateTab();
        page.categoryForm.shouldBe(visible);
        page.inputCategoryForm(created);
        page.submitCreate();
        page.gridLine(created.name).shouldBe(visible);
    }

    @Test(priority = 1)
    @Story("Admin can update category")
    public void testUpdateCategory(){
        page.checkLine(created.name);
        page.clickUpdateButton();

        page.categoryForm.shouldBe(visible);
        page.nameInput.shouldHave(value(created.name));

        page.inputCategoryForm(updated);
        page.submitUpdate();

        page.gridLine(updated.name).shouldBe(visible);
    }

    @Test(priority = 2)
    @Story("Admin can delete category")
    public void testDeleteCategory(){
        page.checkLine(updated.name);
        page.clickDeleteButton();
        page.confirmModal();
        page.gridLine(updated.name).shouldNot(exist);
    }
}