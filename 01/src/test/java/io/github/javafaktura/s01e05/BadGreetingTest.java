package io.github.javafaktura.s01e05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadGreetingTest {

    @Test
    public void firstTest() {
        String name = "Javafaktura";
        assertEquals("Hello" + name, new Greeting().hello(name));
    }
}
