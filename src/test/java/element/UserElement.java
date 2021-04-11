package element;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface UserElement extends BaseElement {
     SelenideElement userGrid = $(".ant-table-container").find(byText("Email"));

     SelenideElement emailInput = $("#email");
     SelenideElement passwordInput = $("#password");
     SelenideElement nameInput = $("#name");
     SelenideElement phoneInput = $("#phone");
     SelenideElement roleInput = $("#role");

     SelenideElement createForm = $("form").find("input#email");
}
