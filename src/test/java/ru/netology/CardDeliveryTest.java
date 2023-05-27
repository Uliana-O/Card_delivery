package ru.netology;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;


public class CardDeliveryTest {
    @BeforeEach

    void setUp() {
        open( "http://localhost:7777/" );}
    MeetingDate meetingDate = new MeetingDate();
    int days = 3;
    @Test
    void sendCardForm() {

        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(BACK_SPACE);
        $("[data-test-id='date'] input").setValue(meetingDate.meetingDate(days));
        $("[data-test-id= 'name'] input").setValue("Сергеев Сергей");
        $("[data-test-id='phone'] input").setValue("+79220100001");
        $("[data-test-id ='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Успешно" + meetingDate), Duration.ofSeconds(15));
    }
}
