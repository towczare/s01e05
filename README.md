# Unit testing

[x] first simple test - explaining given, when, then
[] parametrized tests
    - antipattern, using for loop
    - data driven tests
    - feature files
[] dealing with time
    - TimeMachine
[] dependencies
    - files
    - database
    - queues
    - external web services
[] fluent builder pattern
    - dużo setterów podczas przygotowywania testów
    - Object Mother
    - shared between tests
    - shared part in fields
[] life cycle
    - @Before, @BeforeAll, @After, @AfterAll
    - antipattern, komplikują kontekst
    - dziel na mniejsze
[] dzielenie klas testowych wg przypadku
    - pattern nazewnictwa, pełniący funkcję konwencji given
[] testowanie wyjątków
    - weryfikowanie treści wyjątku w ramach assercji
[] co z prywatnymi metodami?
    - nie testować
    - to klasy pomocnicze dzielące kod

