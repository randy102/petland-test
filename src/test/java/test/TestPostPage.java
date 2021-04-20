package test;

import api.CategoryApi;
import api.PostApi;
import api.SubCategoryApi;
import com.google.gson.JsonObject;
import dto.CategoryDTO;
import dto.PostDTO;
import dto.SubCategoryDTO;
import io.qameta.allure.Story;
import mock.CategoryMock;
import mock.PostMock;
import mock.SubCategoryMock;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PostPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;

public class TestPostPage extends BaseTest<PostPage> {
    final CategoryDTO category = CategoryMock.basic();
    SubCategoryDTO subCategory;
    PostDTO verifiedPost;
    PostDTO declinedPost;

    @BeforeClass
    public void setup() {
        page = new PostPage();
    }

    @AfterClass
    public void cleanUp() throws IOException {
        PostApi.delete(verifiedPost);
        PostApi.delete(declinedPost);
        SubCategoryApi.delete(subCategory);
        CategoryApi.delete(category);
    }

    @Test
    @Story("Admin can verify post")
    public void testVerifyPost() throws IOException {
        JsonObject categoryRes = CategoryApi.create(category);
        category.id = categoryRes.get("_id").getAsString();

        subCategory = SubCategoryMock.basic(category);
        JsonObject subCategoryRes = SubCategoryApi.create(subCategory);
        subCategory.id = subCategoryRes.get("_id").getAsString();

        verifiedPost = PostMock.basic(category, subCategory);
        JsonObject postRes = PostApi.create(verifiedPost);
        verifiedPost.id = postRes.get("_id").getAsString();
        PostApi.confirm(verifiedPost);

        page.clickRefreshButton();
        page.checkLine(verifiedPost.name);
        page.clickVerifyButton();
        page.confirmModal();
        page.gridLine(verifiedPost.name).shouldHave(text("Đã duyệt"));
    }

    @Test(priority = 1)
    @Story("Admin can decline post")
    public void testDeclinePost() throws IOException {
        declinedPost = PostMock.basic(category, subCategory);
        JsonObject postRes = PostApi.create(declinedPost);
        declinedPost.id = postRes.get("_id").getAsString();
        PostApi.confirm(declinedPost);

        page.clickRefreshButton();
        page.checkLine(declinedPost.name);
        page.clickDeclineButton();
        page.inputDeclineReason("Test");
        page.confirmModal();
        page.gridLine(declinedPost.name).shouldHave(text("Đã từ chối"));
    }
}
