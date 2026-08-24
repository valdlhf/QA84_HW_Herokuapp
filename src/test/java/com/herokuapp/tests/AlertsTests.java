package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.alerts.AlertsPage;
import com.herokuapp.pages.home.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class AlertsTests extends TestBase {

    AlertsPage alerts;

    @BeforeEach
    public void precondition(){
        alerts = new HomePage(driver).getAlertsPage();
    }

    @Test
    public void verifyAlertsPage(){
        alerts.isPageTitleCorrect("JavaScript Alerts");
    }


    //1
@Test
    public void jsAlert(){
        alerts.getAlerts()
                .acceptAlert().verifyResult("You successfully clicked an alert");
}
//2
    //вариарт для каждого свой метод
//@Test
//    public void jsConfirmOk(){
//        alerts.getConfirm()
//                .clickOnOption("Ok")
//                .verifyResult("Ok");
//}
//
//@Test
//    public void jsConfirmCancel(){
//    alerts.getConfirm()
//            .clickOnOption("Cancel")
//            .verifyResult("Cancel");
//}

// 2 уплотнение до одного метода
@ParameterizedTest
@ValueSource(strings = {"Ok","Cancel"})
public void jsConfirm(String option){
        alerts.getConfirm()
                .clickOnOption(option)
                .verifyResult(option);
}

//3 свои метод для каждой проверки
//    @Test
//    public void jsPromptOk(){
//        alerts.getPrompt()
//                .typeInAlert("Test")
//                .clickOnOption("Ok")
//                .verifyResult("Test");
//    }
//
//    @Test
//    public void jsPromptCancel(){
//        alerts.getPrompt()
//                .typeInAlert("Test")
//                .clickOnOption("Cancel")
//                .verifyResult("null");
//    }

    // 3 уплотнение
    //  для кнопки ок

@ParameterizedTest
    @MethodSource("provideValueForPromptAlert")
    public void jsPromptClickOnButtonOk(String text, String option){
        alerts.getPrompt()
                .typeInAlert(text)
                .clickOnOption(option)
                .verifyResult(text);
}
// подсказка от gpt
    static Stream<Arguments> provideValueForPromptAlert(){
        return Stream.of(
                Arguments.of("Test text", "Ok"),
                Arguments.of("", "Ok"),
                Arguments.of(" ", "Ok"),
                Arguments.of("Тесты 1:4", "Ok")
        );
    }
// для кнопки
    @ParameterizedTest
    @ValueSource(strings = {"Test test","","  "})
    public void jsPromptClickOnButtonCancel(String option){
        alerts.getPrompt()
                .clickOnOption("Cancel")
                .verifyResult("null");
    }


//
    @Test
    public void jsAlertTextTest() {
        alerts
                .getAlerts()
                .verifyAlertText("I am a JS Alert")
                .acceptAlert();
    }
}

