package com.jpmc.theater;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateProviderTests {
    @Test
    void makeSureCurrentTime() {
        LocalDate currentDateTime = LocalDate.now();
        assertEquals(currentDateTime, LocalDateProvider.singleton().currentDate());   //UPDATES - use JUnit test
    }
}
