package test;

import com.codeborne.selenide.Condition;
import dto.CategoryDTO;
import io.qameta.allure.Story;
import mock.CategoryMock;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CategoryPage;

import static com.codeborne.selenide.Condition.*;

public class TestCategoryPage extends BaseTest<CategoryPage>{
    final CategoryDTO created = CategoryMock.basic();

    @BeforeTest
    public void setup() {
        page = new CategoryPage();
    }

    @Test
    @Story("Admin can add category")
    public void testAddCategory(){
        page.openCreateTab();
        page.createForm.shouldBe(visible);
        page.inputNewCategory(created);
        page.submitCreate();
        page.categoryGrid.shouldBe(visible);
    }
}
