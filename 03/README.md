# 03 Only good weather data, (no) exceptions!

## Code

* [WeatherConsumer](src//main//java//io//github//javafaktura//s01e05//WeatherConsumer.java) - Simplified weather data consumer. Consuming weather containing temperature, wind speed and rainfall data.
* [WeatherValidator](src//main//java//io//github//javafaktura//s01e05//WeatherValidator.java) - Since we don't want to get badly measured data saved, we are throwing multiple exceptions for non consistent data.

## Bad Tests

[BadWeatherValidatorTest](src//test//java//io//github//javafaktura//s01e05//BadWeatherValidatorTest.java) - checking multiple scenarios, when our service should throw given exception.

### Nice parts and lessons learned included:
* :+1: DDT - Data Driven Test done right using parametrized tests
* :+1: Good descriptive names for both methods and test scenarios
* :+1: Not introducing too many new custom exception types

Smells (sometimes opinionated):
* :hankey: Trying to comparee IllegalArgumentException objects, but all exceptions inherit equals method from Object which means all of them (not custom one) will be different objects
* :hankey: No distinction between error types
* :hankey: Ugly to read flow of testing exceptions


## Better Tests

[BetterWeatherValidatorTest](src//test//java//io//github//javafaktura//s01e05//BetterWeatherValidatorTest.java) -
Good practices (sometimes opinionated):
* :+1: Using right API provided by JUnit5 to test exception throws, more readable
* :+1: Testing different scenarios by asserting exception messages
* :+1: Not introducing any new Exception types
* :+1: Introducing one scenario beside happy path (happy path with exceptions :laughing:)


