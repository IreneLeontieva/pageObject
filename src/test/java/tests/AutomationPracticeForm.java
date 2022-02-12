package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {
    private RegistrationPage registrationPage = new RegistrationPage();
    private String
            firstName = "Irina",
            lastName = "Leonteva",
            userEmail = "test@test.ru",
            gender = "Female",
            userNumber = "8921634771",
            year = "1994",
            month = "December",
            day = "13",
            subject = "Biology",
            hobby = "Reading",
            currentAddress = "Moscow",
            state = "NCR",
            city = "Delhi",
            fileName = "pik.png";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillForm() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .chooseGender(gender)
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .fillSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(fileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .checkTable()
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobby)
                .checkForm("Picture", fileName)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);
    }
}