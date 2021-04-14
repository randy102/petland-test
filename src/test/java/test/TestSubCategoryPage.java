package test;

import dto.CategoryDTO;
import dto.SubCategoryDTO;
import io.qameta.allure.Story;
import mock.SubCategoryMock;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CategoryPage;
import pages.SubCategoryPage;

import static com.codeborne.selenide.Condition.*;
import static utils.Antd.selectedItem;

public class TestSubCategoryPage extends BaseTest<SubCategoryPage> {
    SubCategoryDTO created;
    SubCategoryDTO updated;
    final CategoryPage categoryPage = new CategoryPage();

    @BeforeClass
    public void setup() {
        page = new SubCategoryPage();
    }

    @AfterClass
    public void cleanUp(){
        categoryPage.openPage();
        categoryPage.deleteCategory(created.category);
    }

    @Test
    @Story("Admin can add subcategory")
    public void testAddSubCategory(){
        created = page.createSubCategory();
    }

    @Test(priority = 1)
    @Story("Admin can update category")
    public void testUpdateCategory(){
        page.checkLine(created.name);
        page.clickUpdateButton();

        page.nameInput.shouldHave(value(created.name));
        // selectedItem(page.categoryInput).shouldHave(text(created.category.name));

        updated = SubCategoryMock.basic(created.category);
        BasePage.clearAndSendInput(page.nameInput, updated.name);
        page.submitUpdate();

        page.gridLine(updated.name).shouldBe(visible);
        page.gridLine(updated.category.name).shouldBe(visible);
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