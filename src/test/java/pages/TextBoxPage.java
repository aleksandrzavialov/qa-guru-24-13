package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxPage {
    private final SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            userCurrentAddressInput = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            tableContent = $("#output");


    @Step("Open text box page")
    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set full name")
    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);

        return this;
    }

    @Step("Set email")
    public TextBoxPage setEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    @Step("Set current address")
    public TextBoxPage setCurrentAddress(String currentAddress) {
        userCurrentAddressInput.setValue(currentAddress);

        return this;
    }

    @Step("Set permanent address")
    public TextBoxPage setPermanentAddress(String permanentAddress) {
        userPermanentAddress.setValue(permanentAddress);

        return this;
    }


    @Step("Submit result")
    public void submitResult() {
        submitButton.click();
    }


    @Step("Check saved name")
    public TextBoxPage checkNameResult(String name) {
        tableContent.$("#name").shouldHave(text("Name:" + name));

        return this;
    }

    @Step("Check saved email")
    public TextBoxPage checkEmailResult(String email) {
        tableContent.$("#email").shouldHave(text("Email:" + email));

        return this;
    }

    @Step("Check current address")
    public TextBoxPage checkCurrentAddressResult(String currentAddress) {
        tableContent.$("#currentAddress").shouldHave(text("Current Address :" + currentAddress));

        return this;
    }

    @Step("Check permanent address")
    public TextBoxPage checkPermanentAddressResult(String permanentAddress) {
        tableContent.$("#permanentAddress").shouldHave(text("Permananet Address :" + permanentAddress));

        return this;
    }


}