package pages;

import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            dayOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            inputPicture = $("#uploadPicture"),
            currentAdressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            tableHeader = $(".modal-header"),
            resultsTable = $(".table-responsive");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String userRmail) {
        emailInput.setValue(userRmail);
        return this;
    }

    public RegistrationPage chooseGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setNumber(String userNumber) {
        numberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $(dayOfBirthInput).click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage fillSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        $(byText(hobby)).scrollTo().click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        $(inputPicture).uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        $(currentAdressInput).setValue(currentAddress);
        return this;
    }

    public RegistrationPage setState(String state) {
        $(stateInput).click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        $(cityInput).click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkTable() {
        $(tableHeader).shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}
