package test;

import static com.codeborne.selenide.Condition.*;

import dto.UserDTO;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import pages.UserPage;

import static mock.UserMock.basic;
import static utils.Antd.selectedItem;

public class TestUserPage extends BaseTest<UserPage>{
    public UserDTO created;
    public UserDTO updated;

    @BeforeClass
    public void setup() {
        page = new UserPage();
    }

    @Test(priority = 1)
    @Story("Admin can create user")
    public void testCreateUser(){
        page.openCreateTab();
        page.createForm.shouldBe(visible);
        created = page.inputNewUser("USER");
        page.submitCreate();
        page.gridLine(created.email).shouldBe(visible);
    }

    @Test(priority = 2)
    @Story("Admin can update user's role")
    public void testUpdateUser(){
        page.checkLine(created.email);
        page.clickUpdateButton();

        page.emailInput.shouldHave(value(created.email));
        page.nameInput.shouldHave(value(created.name));
        selectedItem(page.roleInput).shouldHave(text(created.role));
        page.phoneInput.shouldHave(value(created.phone));

        updated = basic("MOD");
        page.updateUserRole(updated.role);
        page.submitUpdate();

        page.userGrid.shouldBe(visible);
        page.gridLine(created.email).shouldHave(text(created.role));
    }

    @Test(priority = 3)
    @Story("Admin can lock user")
    public void testLockUser(){
        page.checkLine(created.email);
        page.clickToggleLockButton();
        page.confirmModal();
        page.gridLine(created.email).shouldHave(text("Bị khóa"));
    }

    @Test(priority = 4)
    @Story("Admin can unlock user")
    public void testUnLockUser(){
        page.checkLine(created.email);
        page.clickToggleLockButton();
        page.confirmModal();
        page.gridLine(created.email).shouldHave(text("Hoạt động"));
    }

    @Test(priority = 5)
    @Story("Admin can delete user")
    public void testDeleteUser(){
        page.checkLine(created.email);
        page.clickDeleteButton();
        page.confirmModal();
        page.gridLine(created.email).shouldNot(exist);
    }
}
