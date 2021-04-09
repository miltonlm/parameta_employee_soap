package com.parameta.employee.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;


/**
 * Utilities class with useful methods for the system.
 * */
@Component
public class Utilities {

    /**
     * Gets a description of elapsed time between the two dates.
     * @param from first date.
     * @param to last date.
     * @return String containing the description.
     * */
    public String getPeriodDescription(LocalDate from, LocalDate to) {
        Period period = Period.between(from, to);
        return String.format("%d year/s, %d month/s, %d day/s", period.getYears(), period.getMonths(), period.getDays());
    }
}
