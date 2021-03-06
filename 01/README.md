# 01 Hello tests

## Code

[Greeting.java](src//main//java//io//github//javafaktura//s01e05//Greeting.java) - simple class with single method printing greeting.

## Bad Tests

[BadGreetingTest.java](src//test//java//io//github//javafaktura//s01e05//BadGreetingTest.java) - single failing test with dummy error and couple bad practices.

Smells (sometimes opinionated):
* :hankey: unnecessary public modifiers
* :hankey: tests naming
* :hankey: no [literals](https://en.wikipedia.org/wiki/Literal_(computer_programming))
* :hankey: no sections, conventions defined

## Better Tests

[BetterGreetingTest.java](src//test//java//io//github//javafaktura//s01e05//BetterGreetingTest.java) - single passing test, introducing some better practices
Good practices (sometimes opinionated):
* :+1: better test naming, both method naming and descriptive one
* :+1: using [literals](https://en.wikipedia.org/wiki/Literal_(computer_programming))
* :+1: given / when / then - convention introduced
