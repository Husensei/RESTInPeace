package stepDefinition;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

class Hooks {

    @BeforeAll
    public static void setUp() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeTest() {
        System.out.println("Before All");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Before All");
    }
}
