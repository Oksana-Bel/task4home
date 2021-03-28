package dataforsite;


import com.github.javafaker.Faker;


public class DataforStudent {
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

}

