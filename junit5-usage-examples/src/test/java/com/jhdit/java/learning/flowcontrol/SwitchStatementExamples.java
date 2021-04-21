package com.jhdit.java.learning.flowcontrol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchStatementExamples {

    /**
     * Example use of switch construct with fall-through (case without breaks)
     * @param initialAmount Initial financial amount invested
     * @param yearsOfInterest Years of annual interest to apply
     * @return calculated amount, after applying compound interest (for years accrued)
     */

    private float calculateCompoundInterest(float initialAmount, int yearsOfInterest)   {
        // Initial interest rate of 5%, raising to 10% after first 3 years
        float interestRate = 0.05F, interestRateAfter3Years = 0.10F;
        float amount = initialAmount;

        switch(yearsOfInterest) {
            default: // amount remains unchanged
                break;

            // NB: Intentional lack of break statements (to allow 'fall-through')
            case 3:
                amount += amount * (3 * interestRate);
            case 2:
                amount += amount * (2 * interestRate);
            case 1:
                amount += amount * interestRate;
        }
        return amount;
    }

    @Test
    public void calculateCompoundInterestTest() {
        // Expect: correct compounded amount for years accrued
        assertEquals(10, calculateCompoundInterest(10, 0));
        assertEquals(10.5F, calculateCompoundInterest(10, 1));
        assertEquals(11.55F, calculateCompoundInterest(10, 2));
        assertEquals(13.282499F, calculateCompoundInterest(10, 3));
    }

    @Test
    public void switchWithoutBreakOnMonth() {
        int month = 11;
        String message = "";

        switch(month)   {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                message = "31 days. ";
            case 4: case 6: case 11:
                message = "30 days. ";
            case 2:
                message = "28 days. ";
        }

        assertEquals("28 days. ", message);
    }

    @Test
    void switchWithBreakOnMonth() {
        int month = 11;
        String message = "";

        switch(month)   {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                message = "31 days. ";
                break;
            case 4: case 6: case 11:
                message = "30 days. ";
                break;
            case 2:
                message = "28 days. "; // 29 on leap year!
                break;
        }

        assertEquals("30 days. ", message);
    }
}
