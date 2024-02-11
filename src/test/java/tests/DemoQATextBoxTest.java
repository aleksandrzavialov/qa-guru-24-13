package tests;

import data.StudentData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

@Tag("textbox")
public class DemoQATextBoxTest extends TestBase {

    @Test
    @Feature("Register student")
    @Story("Register in simplified form with low level of test abstraction")
    @Owner("azavialov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("It is possible to register student with all data and verify registration results")
    void fillTextBoxFormTest() {

        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.openPage();

        textBoxPage.setFullName(StudentData.studentTextBox.fullName);
        textBoxPage.setEmail(StudentData.studentTextBox.email);
        textBoxPage.setCurrentAddress(StudentData.studentTextBox.currentAddress);
        textBoxPage.setPermanentAddress(StudentData.studentTextBox.permanentAddress);
        textBoxPage.submitResult();

        textBoxPage.checkNameResult(StudentData.studentTextBox.fullName);
        textBoxPage.checkEmailResult(StudentData.studentTextBox.email);
        textBoxPage.checkCurrentAddressResult(StudentData.studentTextBox.currentAddress);
        textBoxPage.checkPermanentAddressResult(StudentData.studentTextBox.permanentAddress);

    }
}