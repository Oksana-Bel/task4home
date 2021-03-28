package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageobject.StudentRegistrationFormPage;

public class StudentRegistrationFormTests {
    //создание экземпляра объекта  StudentRegistrationFormPage
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @BeforeAll
    static void setup(){
        Configuration.startMaximized=true;
    }

    @Test
    void successfulFillFormTest(){
        studentRegistrationFormPage.openPage();
        studentRegistrationFormPage.fillForm();
        studentRegistrationFormPage.checkData();
    }
}
