package com.jhdit.java.learning.designpatterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Use a singleton to create an object only once in memory & have it shared within an application by multiple classes / threads.
 *
 * Singletons are created as private static variables within the class (often with name instance).
 * They are accessed via a single public static method (often named getInstance() ), which returns the singleton instance.
 * All constructors in a singleton class are marked private (to prevent another class from instantiating another version of the class).
 *
 * Examples of scenarios that could benefit from using a singleton pattern:
 *
 * * Manage a reusable (single) cache of objects.
 * * Manage write access to a (single) log file.
 * * Provide central (single) access application configuration data.
 */

class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() { /* prevent external instantiation */ }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() { /* prevent external instantiation */ }

    public static synchronized LazySingleton getInstance() {
        // lazy instantiation - create the singleton instance on the first call to obtain it
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

class DoubleCheckedLockingLazySingleton {
    private static volatile DoubleCheckedLockingLazySingleton instance; // volatile to prevent compiler optimisation undoing intent

    private DoubleCheckedLockingLazySingleton() { /* prevent external instantiation */ }

    public static DoubleCheckedLockingLazySingleton getInstance() {
        // lazy instantiation - create the singleton instance on the first call to obtain it
        if (null == instance) {
            synchronized (DoubleCheckedLockingLazySingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckedLockingLazySingleton();
                }
            }
        }
        return instance;
    }
}

public class SingletonPatternExamples {
    @Test
    void explore()  {
        assertSame(EagerSingleton.getInstance(), EagerSingleton.getInstance());
        assertSame(LazySingleton.getInstance(), LazySingleton.getInstance());
        assertSame(DoubleCheckedLockingLazySingleton.getInstance(), DoubleCheckedLockingLazySingleton.getInstance());
    }
}
