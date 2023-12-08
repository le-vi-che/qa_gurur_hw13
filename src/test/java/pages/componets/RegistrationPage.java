package pages.componets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),

    lastNameInput = $("#lastName"),

    userEmailInput = $("#userEmail"),

    genterWrapper =  $("#genterWrapper"),

    userNumberInput = $("#userNumber"),

    subjectsInput = $("#subjectsInput"),

    hobbiesWrapperInput = $("#hobbiesWrapper"),

    uploadPicture = $("#uploadPicture"),

    currentAddress = $("#currentAddress"),

    pressSubmitButton = $("#submit"),

    calendarInput =$("#dateOfBirthInput"),

    chooseState = $("#react-select-3-input"),

    chooseCity = $("#react-select-4-input");

    CalendarComponent calendarComponent = new CalendarComponent();

    TableResponsiveComponent tableResponsiveComponent = new TableResponsiveComponent();


    @Step("Открываем страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Вводим имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Вводим фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим email")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Указываем пол")
    public RegistrationPage setGenterWrapper(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Вводим номер телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Вводим предметы")
    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.val(value).pressEnter();

        return this;
    }

    @Step("Запоняем хобби")
    public RegistrationPage setHobbiesWrapperInput(String value) {
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем изображение")
    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Вводим адрес")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;

    }

    @Step("Вводим дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage setChooseState(String value) {
        chooseState.val(value).pressEnter();

        return this;

    }

    @Step("Выбираем город")
    public RegistrationPage setChooseCity(String value) {
        chooseCity.val(value).pressEnter();

        return this;

    }

    @Step("Нажимаем кнопку принять")
    public RegistrationPage pressSubmit() {
        pressSubmitButton.pressEnter();

        return this;
    }

    @Step("Проверяем данные")
    public RegistrationPage checkResult(String key, String value){
        tableResponsiveComponent.checkResultTable(key, value);

        return this;
    }

    public RegistrationPage checkNotCompleteForm() {
        firstNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
}
