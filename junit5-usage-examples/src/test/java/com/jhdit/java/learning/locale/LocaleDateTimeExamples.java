package com.jhdit.java.learning.locale;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocaleDateTimeExamples {

    @Test
    public void calculateTimeWorked() {
        // Given: a start & finish time
        LocalTime startWorkTime = LocalTime.of(9, 0);
        LocalTime finishWorkTime = LocalTime.of(17, 30);

        // When: the interval is calculated
        Duration timeWorked = Duration.between(startWorkTime, finishWorkTime);

        // Then: the result is expected
        assertEquals("PT8H30M", timeWorked.toString());
        assertEquals(8, timeWorked.toHours()); // Rounded down
        assertEquals(8.5 * 60, timeWorked.toMinutes());
        assertEquals(8.5 * 60 * 60, timeWorked.getSeconds()); // 30960 seconds
    }

    @Test
    public void timeZoneDifference() {
        ZoneId zoneForLondon = ZoneId.of("Europe/London");
        ZoneId zoneForSeattle = ZoneId.of("America/Los_Angeles"); // use for Seattle / PST (Pacific Standard Time)


        LocalDateTime localDateTime = LocalDateTime.of(2020, 12, 25, 12, 0, 0);
        ZonedDateTime londonDateTime = ZonedDateTime.of(localDateTime, zoneForLondon);
        ZonedDateTime seattleDateTime = londonDateTime.withZoneSameInstant(zoneForSeattle);

        assertEquals(0, londonDateTime.getOffset().getTotalSeconds());
        assertEquals(-28800, seattleDateTime.getOffset().getTotalSeconds()); // 8 hours = 28,800 seconds
    }
}
