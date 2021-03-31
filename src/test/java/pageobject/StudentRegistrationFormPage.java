package pageobject;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class StudentRegistrationFormPage {

    Faker faker = new Faker();

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = "Female",
            mobile_Number = faker.phoneNumber().subscriberNumber(10),
            month = "July",
            year = "1991",
            subjects = "Physics",
            hobbies = "Sports",
            address = faker.address().cityName(),
            state = "Uttar Pradesh",
            city = "Lucknow";


    public StudentRegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }


    public StudentRegistrationFormPage fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("[placeholder='Mobile Number']").setValue(mobile_Number);

        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--013").click();


        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText(hobbies)).click();
        $("input#uploadPicture").uploadFromClasspath("audi.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        return this;
    }


    public StudentRegistrationFormPage checkData() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(mobile_Number),
                text("13 " + month + "," + year),
                text(subjects),
                text(hobbies),
                text("audi.jpg"),
                text(address),
                text(state + " " + city));

        return this;
    }

}
