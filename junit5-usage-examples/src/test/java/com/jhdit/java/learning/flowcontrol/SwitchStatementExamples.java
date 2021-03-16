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
}
