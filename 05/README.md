# 05

This module contains weather prediction module.
Currently it uses very stupid random implementation, but in the future we are going to use the same API from external provider providing best Weather forecast.
Our job is to provide couple additional modules:

* Filter module - this module is going to provide following requirements:
    [] minimalTemp - allows to define minimal temp and limit weather predictions fulfilling this requirement
    [] maximalTemp - allows to define maximal temp and limit weather predictions fulfilling this requirement
    [] rain - allows to define following options:
        - no rain weather predictions
        - rain weather predictions
        - no filtering
    [] daysSpree - looking for weather predictions when given conditions occurs given times in a row
    [] kiteWeather - allows to filter weather for given kite types:
        - Deltas, Diamonds and Dragon - no rain, 6-15 mph
        - Box Kites and stickless Parafoil - no rain, 8-25 mph
        - All kite types - no rain 6-25 mph

## Code

[](src//main//java//io//github//javafaktura//s01e05//.java) -

## Bad Tests

[](src//test//java//io//github//javafaktura//s01e05//.java) -

### Nice parts and lessons learned included:
* :+1:

Smells (sometimes opinionated):
* :hankey:

## Better Tests

[](src//test//java//io//github//javafaktura//s01e05//.java) -
Good practices (sometimes opinionated):
* :+1:
