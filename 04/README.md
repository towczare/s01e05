# 04 Gone with the wind! (anemic vs domain)

![src//main//resources//images//beaufort.png](src//test//resources//images//beaufort.png)

## Code

## Anemic class approach

Anemic classes contains nothing more than just data.
All business logic is stored in separate classes `Services`, `Converters`, `Utils` you call it.

[BeaufortScale](src//main//java//io//github//javafaktura//s01e05//anemic//BeaufortScale.java) -
[BeaufortScaleConverter](src//main//java//io//github//javafaktura//s01e05//anemic//BeaufortScaleConverter.java) -

## Domain class approach

Domain classes contains both data and business logic.

[BeaufortScale](src//main//java//io//github//javafaktura//s01e05//ddd//BeaufortScale.java) -

# Tests (this time both are fine)

## Anemic class approach

[BeaufortScaleTest](src//test//java//io//github//javafaktura//s01e05//anemic//BeaufortScaleTest.java) -

## Domain class approach

[BeaufortScaleTest](src//test//java//io//github//javafaktura//s01e05//domain//BeaufortScaleTest.java) -

# Why domain driven models might be better for testing purposes?

![src//main//resources//images//anemic_vs_ddd.jpg](src//test//resources//images//anemic_vs_ddd.jpg)

* :+1: More modular - smaller classes/methods that are easier to test
* :+1: POJOs with no dependencies on infrastructure - quickly test in isolation
* :+1: This architecture supports higher amount of unit tests


