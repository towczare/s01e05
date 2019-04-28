# 03 Only good weather data, (no) exceptions!

## Code

[WeatherConsumer](src//main//java//io//github//javafaktura//s01e05//WeatherConsumer.java) - Simplified weather data consumer. Consuming weather containing temperature, wind speed and rainfall data.
[WeatherInMemoryRepository](src//main//java//io//github//javafaktura//s01e05//WeatherInMemoryRepository.java) - Simple storage implementation based on hashmap.
[WeatherValidator](src//main//java//io//github//javafaktura//s01e05//WeatherValidator.java) - Since we don't want to get badly measured data saved, we are throwing multiple exceptions for non consistent data.

## Bad Tests

[](src//test//java//io//github//javafaktura//s01e05//WeatherValidatorTest.java) - checking multiple scenarios, when our service should throw given exception.

### Nice parts and lessons learned included:
* :+1: DDT - Data Driven Test done right using parametrized tests
* :+1: Good descriptive names for both methods and test scenarios

Smells (sometimes opinionated):
* :hankey: Testing only happy path scenarios
... tbc


## Better Tests

[](src//test//java//io//github//javafaktura//s01e05//.java) -
Good practices (sometimes opinionated):
* :+1:
