# 05 Where to fly my kite?

Recently I bought kite. Instead waiting for best weather in Poland, lets use weather prediction service and filter out locations which match my requirements.
We will go through whole process building this filter service using TDD approach.

## Code

* [Weather](src//main//java//io//github//javafaktura//s01e05//weather//Weather.java) - weather prediction containing basic information about weather, location and date.
### Predition module
* [WeatherPredictor](src//main//java//io//github//javafaktura//s01e05//weather//prediction//WeatherPredictor.java) - weather prediction API which allows to consume Weather predictions for X upcoming days from given starting date.
* [RandomWeatherPredictor](src//main//java//io//github//javafaktura//s01e05//weather//prediction//RandomWeatherPredictor.java) - Dumb implementation generating random values for provided locations.
### Location module -
* [Location](src//main//java//io//github//javafaktura//s01e05//weather//location//Location.java) - Class representing location as two String values: city and country.
* [LocationProvider](src//main//java//io//github//javafaktura//s01e05//weather//location//LocationProvider.java) - API allowing to provide list of Locations.
* [LocationFileProvider](src//main//java//io//github//javafaktura//s01e05//weather//location//LocationFileProvider.java) - Implementation of above API based on csv files.
### Filter module
* [WeatherCriteria](src//main//java//io//github//javafaktura//s01e05//weather//filter//WeatherCriteria.java) - allows to define all weather attributes required for filtering
* [WeatherLocationFilter](src//main//java//io//github//javafaktura//s01e05//weather//filter//WeatherLocationFilter.java) - filter allowing to limit provided source of weather predictions fulfilling given WeatherCriteria

## Requirements
* As User of WeatherLocationFilter I want be able to:
    * filter Weathers where temp is higher than minimal temp defined in WeatherCriteria
    * filter Weathers where temp is lower than maximal temp defined in WeatherCriteria
    * filter Weathers for three defined rain conditions:
        * WET (for any Weather predicting rainfall),
        * DRY (for any Weather predicting rainfall = 0.00 mm/day),
        * WHO_CARES (default value for any rain conditions)
    * provide easy way to convert following kite requirement types to WeatherCriteria:
        ![src//main//resources//images//kitetypes.jpg](src//main//resources//images//kitetypes.jpg)
        * DELTA - allowing to fly for Wind from 9.66 km/h to 24.14 km/h
            ![src//main//resources//images//delta.jpg](src//main//resources//images//delta.jpg)
        * DIAMOND - allowing to fly for Wind from 9.66 km/h to 24.14 km/h
            ![src//main//resources//images//diamond.jpg](src//main//resources//images//diamond.jpg)
        * DRAGON - allowing to fly for Wind from 9.66 km/h to 24.14 km/h
            ![src//main//resources//images//dragon.jpg](src//main//resources//images//dragon.jpg)
        * BOX - allowing to fly for Wind from 12.87 km/h to 40.23 km/h
            ![src//main//resources//images//box.jpg](src//main//resources//images//box.jpg)
        * STICKLESS_PARAFOIL - allowing to fly for Wind from 12.87 km/h to 40.23 km/h
            ![src//main//resources//images//parafoil.jpg](src//main//resources//images//parafoil.jpg)
    * allow to define days in a row in WeatherCriteria, so only results fulfilling this will be filtered out

## TDD - step by step

:closed_book: - fail
:green_book: - pass
:blue_book: - refactor

Inside `io.github.javafaktura.s01e05.weather.filter.tdd` we defined 11 steps of implementing above requirements using TDD approach.

| Step        | Phase           | Comments  |
| ------------- |:-------------:| -----:|
| [Step 1](src//test//java//io//github//javafaktura//s01e05//filter//tdd//step1//WeatherLocationFilterTest.java)        | :closed_book: | First test introduced, we expect to return whole list for empty criteria object      |
