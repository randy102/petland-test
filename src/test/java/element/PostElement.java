package element;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public interface PostElement extends BaseElement{
    SelenideElement postGrid = BaseElement.gridWhichHasColumns("Tên bài đăng","Thể loại","Giống","Xuất xứ");
    SelenideElement verifyButton = BaseElement.buttonByText("Duyệt");
    SelenideElement declineButton = BaseElement.buttonByText("Từ chối");

    SelenideElement reasonInput = $("#reason");
}
