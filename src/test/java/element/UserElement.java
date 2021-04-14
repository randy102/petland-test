package element;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface UserElement extends BaseElement {
//     SelenideElement userGrid = $(".ant-table-container").find(byText("Email"));
     SelenideElement userGrid = BaseElement.gridWhichHasColumns(new String[]{"Email","Điện thoại","Tên"});

     SelenideElement emailInput = $("#email");
     SelenideElement passwordInput = $("#password");
     SelenideElement nameInput = $("#name");
     SelenideElement phoneInput = $("#phone");
     SelenideElement roleInput = $("#role");

     SelenideElement createForm = BaseElement.formWhichHasInputs(new String[]{"email","password","name","phone"});
     SelenideElement toggleLockButton = $(byXpath("//button[./span[text() = 'Khóa/Mở khóa']]"));
}
