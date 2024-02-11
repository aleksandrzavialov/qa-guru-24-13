package tests;

import data.StudentData;
import io.qameta.allure.*;
import models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;


public class DemoQAFullFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTable = new ResultTableComponent();

    @Test
    @Feature("Register student")
    @Story("Register in complex form with high level of test abstraction")
    @Owner("azavialov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("It is possible to register student with all possible data and verify registration results")
    void successfulRegisterFullDataTest() {

        Student student = StudentData.studentFullData;

        //Preconditions
        registrationPage.openPage();

        //Form filling
        registrationPage.fillAllStudentFields(student);
        registrationPage.submitResult();

        //Checking submit results
        resultTable.checkResultTableUI().
                checkAllStudentFields(student);
    }

    @Test
    @Feature("Register student")
    @Story("Register in complex form with low level of test abstraction")
    @Owner("azavialov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("It is possible to register student with minimal possible data and verify registration results")
    void successfulRegisterMinimalDataTest() {

        //Preconditions
        registrationPage.openPage();

        //Form filling
        registrationPage.setFirstName(StudentData.studentMinimumData.name).
                setLastName(StudentData.studentMinimumData.lastName).
                setGender(StudentData.studentMinimumData.gender).
                setUserNumber(StudentData.studentMinimumData.phone).
                setDateOfBirth(StudentData.studentMinimumData.dayOfBirth,
                        StudentData.studentMinimumData.monthOfBirth, StudentData.studentMinimumData.yearOfBirth);

        registrationPage.submitResult();

        //Checking submit results
        resultTable.checkResultTableUI().
                checkResult("Student Name",
                        StudentData.studentMinimumData.name + " " + StudentData.studentMinimumData.lastName).
                checkResult("Student Email", " ").
                checkResult("Gender", StudentData.studentMinimumData.gender).
                checkResult("Mobile", StudentData.studentMinimumData.phone).
                checkResult("Date of Birth",
                        StudentData.studentMinimumData.dayOfBirth + " " +
                                StudentData.studentMinimumData.monthOfBirth + "," +
                                StudentData.studentMinimumData.yearOfBirth).
                checkResult("Subjects", " ").
                checkResult("Hobbies", " ").
                checkResult("Picture", " ").
                checkResult("Address", " ").
                checkResult("State and City", " ");

    }

    @Test
    @Feature("Register student")
    @Story("Register in complex form with low level of test abstraction")
    @Owner("azavialov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("It is not possible to register student without mandatory fields")
    void unsuccessfulRegisterNoGenderEnteredTest() {

        //Preconditions
        registrationPage.openPage();

        //Form filling
        registrationPage.setFirstName(StudentData.studentMinimumData.name).
                setLastName(StudentData.studentMinimumData.lastName).
                setUserNumber(StudentData.studentMinimumData.phone).
                setDateOfBirth(StudentData.studentMinimumData.dayOfBirth,
                        StudentData.studentMinimumData.monthOfBirth,
                        StudentData.studentMinimumData.yearOfBirth);

        registrationPage.submitResult();

        //Checking submit results
        resultTable.checkTableIsNotVisible();

    }

}


