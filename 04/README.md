# 04 Gone with the wind! (anemic vs domain)

![src//main//resources//images//beaufort.png](src//main//resources//images//beaufort.png)

## Code

## Anemic class approach

Anemic classes contains nothing more than just data.
All business logic is stored in separate classes `Services`, `Converters`, `Utils` you call it.

[BeaufortScale](src//main//java//io//github//javafaktura//s01e05//anemic//BeaufortScale.java) - anemic class storing only data
[BeaufortScaleConverter](src//main//java//io//github//javafaktura//s01e05//anemic//BeaufortScaleConverter.java) - logic converting knots to scale

## Domain class approach

Domain classes contains both data and business logic.

[BeaufortScale](src//main//java//io//github//javafaktura//s01e05//domain//BeaufortScale.java) - domain class with more responsible approach data + logic

# Tests (this time both are fine)

## Anemic class approach

[BeaufortScaleTest](src//test//java//io//github//javafaktura//s01e05//anemic//BeaufortScaleTest.java) - all good practices learned in earlier examples

## Domain class approach

[BeaufortScaleTest](src//test//java//io//github//javafaktura//s01e05//domain//BeaufortScaleTest.java) - all good practices learned in earlier examples

# Why domain driven models might be better for testing purposes?

![src//main//resources//images//anemic_vs_ddd.jpg](src//main//resources//images//anemic_vs_ddd.jpg)

* :+1: More modular - smaller classes/methods that are easier to test
* :+1: POJOs with no dependencies on infrastructure - quickly test in isolation
* :+1: This architecture supports higher amount of unit tests


