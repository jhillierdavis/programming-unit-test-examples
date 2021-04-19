package com.jhdit.java.learning.concurrency.primes;

public class PrimeNumber {
    static boolean isPrime(int value)   {
        if (value <= 1) {
            return false;
        }

        if (value > 2 && 0 == value % 2)    {
            return false; // Even (& not 2)
        }

        int i = 2;
        while (i  < value / 2)   {
            if (value % i == 0) {
                return false;
            }
            i++;
        }

        return true;
    }

}
