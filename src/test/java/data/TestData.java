package data;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddres = faker.address().streetAddress(),
            genderUser = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthBirth = faker.options().option("January", "February", "March", "April","May", "June",
                    "July", "August", "September", "October", "November", "December"),
            yearBirth = String.valueOf(faker.number().numberBetween(1901, 2023)),
            subjects = faker.options().option("Hindi", "English", "History"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            state = faker.options().option("NCR", "Haryana", "Rajasthan"),
            picture = faker.options().option("picture.png", "picture(2).jpg"),
            city = getCityRandom(state);

    public String getCityRandom(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }
    }
}
