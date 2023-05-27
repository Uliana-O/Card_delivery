package ru.netology;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MeetingDate {
    int days = 3;

    public String meetingDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}