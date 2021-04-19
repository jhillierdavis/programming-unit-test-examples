package com.jhdit.java.learning.concurrency.primes;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeThread extends Thread {
    private Set<Integer> primes = new HashSet<>();

    @Override
    public void run()  {
        // Obtain the primes between 1 & 100
        for (int i = 1; i < 100; i++ )  {
            if (PrimeNumber.isPrime(i)) {
                this.primes.add(i);
            }
        }
    }

    public Set<Integer> getPrimes()    {
        return this.primes;
    }
}

class PrimeRunner implements Runnable {
    private Set<Integer> primes = new HashSet<>();

    public void run()  {
        // Obtain the primes between 1 & 100
        for (int i = 1; i < 100; i++ )  {
            if (PrimeNumber.isPrime(i)) {
                this.primes.add(i);
            }
        }
    }

    public Set<Integer> getPrimes()    {
        return this.primes;
    }
}

public class GeneratePrimesExamples {
    @Test
    void exploreUsingExtendedThread() throws InterruptedException {
        PrimeThread pt = new PrimeThread();
        pt.start();

        while(pt.isAlive()) {
            Thread.sleep(10);
        }

        for (Integer prime: pt.getPrimes()) {
            System.out.print(prime + " ");
        }
        System.out.println();
        assertEquals(25, pt.getPrimes().size());
    }

    @Test
    void exploreUsingRunnableImplementation()   throws InterruptedException {
        PrimeRunner pr = new PrimeRunner();
        Thread t = new Thread(pr);
        t.start(); // Do NOT forget to start the Thread!

        while(t.isAlive()) {
            Thread.sleep(10);
        }

        for (Integer prime: pr.getPrimes()) {
            System.out.print(prime + " ");
        }
        System.out.println();
        assertEquals(25, pr.getPrimes().size());
    }
}
