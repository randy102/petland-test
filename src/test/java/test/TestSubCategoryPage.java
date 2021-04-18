package test;

import api.CategoryApi;
import api.Request;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dto.CategoryDTO;
import dto.SubCategoryDTO;
import io.qameta.allure.Story;
import mock.CategoryMock;
import mock.SubCategoryMock;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CategoryPage;
import pages.SubCategoryPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static utils.Antd.selectedItem;

public class TestSubCategoryPage extends BaseTest<SubCategoryPage> {
    SubCategoryDTO created;
    SubCategoryDTO updated;
    CategoryDTO category;

    @BeforeClass
    public void setup() {
        page = new SubCategoryPage();
    }

    @AfterClass
    public void cleanUp() throws IOException {
        CategoryApi.delete(category);
    }

    @Test
    @Story("Admin can add subcategory")
    public void testAddSubCategory() throws IOException {
        category = CategoryMock.basic();
        category.id = CategoryApi.create(category).get("_id").getAsString();
        created = SubCategoryMock.basic(category);

        page.openCreateTab();

        page.subCategoryForm.shouldBe(visible);
        page.inputSubCategoryForm(created);
        page.submitCreate();

        page.gridLine(category.name).shouldBe(visible);
        page.gridLine(created.category.name).shouldBe(visible);
    }

    @Test(priority = 1)
    @Story("Admin can update category")
    public void testUpdateCategory(){
        page.checkLine(created.name);
        page.clickUpdateButton();

        page.nameInput.shouldHave(value(created.name));

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