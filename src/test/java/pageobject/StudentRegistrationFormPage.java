package pageobject;

import dataforsite.DataforStudent;

import java.io.File;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {
 DataforStudent dataforStudent = new DataforStudent();


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }


    public void fillForm() {
        $("#firstName").setValue(dataforStudent.firstName);
        $("#lastName").setValue(dataforStudent.lastName);
        $("#userEmail").setValue(dataforStudent.userEmail);
        $(byText(dataforStudent.gender)).click();
        $("[placeholder='Mobile Number']").setValue(dataforStudent.mobile_Number);

        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption(dataforStudent.month);
        $(".react-datepicker__year-select").selectOption(dataforStudent.year);
        $(".react-datepicker__day--013").click();


        $("#subjectsInput").setValue(dataforStudent.subjects).pressEnter();
        $(byText(dataforStudent.hobbies)).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/audi.jpg"));
        $("#currentAddress").setValue(dataforStudent.address);
        $("#state").click();
        $("#react-select-3-input").setValue(dataforStudent.state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(dataforStudent.city).pressEnter();
        $("#submit").click();
    }


    public void checkData() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(
                text(dataforStudent.firstName + " " + dataforStudent.lastName),
                text(dataforStudent.userEmail),
                text(dataforStudent.gender),
                text(dataforStudent.mobile_Number),
                text("13 " + dataforStudent.month + "," + dataforStudent.year),
                text(dataforStudent.subjects),
                text(dataforStudent.hobbies),
                text("audi.jpg"),
                text(dataforStudent.address),
                text(dataforStudent.state + " " + dataforStudent.city));
    }

}
