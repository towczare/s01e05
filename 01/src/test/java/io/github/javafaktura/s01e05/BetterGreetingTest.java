package io.github.javafaktura.s01e05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BetterGreetingTest {

    @Test
    @DisplayName("Should return `Hello Javafaktura` when name Javafaktura is name param")
    void shouldReturnHelloJavafaktura() {
        /** given - prepare your test context **/
        Greeting greeting = new Greeting();

        /** when - actual code you are going to test **/
        String result = greeting.hello("Javafaktura");

        /** then - verify your result with assumption **/
        assertEquals("Hello Javafaktura", result); //

        /** Alternative version:
        /*   Sometimes it is better to combine two earlier phases into single one.
        /*   expect = when + then - verify result of your code with assumption
         **/
        // assertEquals("Hello JUG", greeting.hello("JUG"));
    }
}
