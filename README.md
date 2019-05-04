# Javafaktura s01e05 - Unit testing

![.images/javafaktura.png](.images/javafaktura.png)

## How to read this repository?

Whole repository is divided into couple modules covering various examples and testing techniques.
Each module contains its own `README.md` file which dives into details particular example. In details contains following:
* Introduction - covers basic information about domain
* Code - what are main code classes we are testing and what they actually do
* Bad Tests - testing code which is not written in most efficient way. Main purpose is to present most common mistakes
    * :hankey: Smells - comments whats wrong with this particular `Bad*` examples
* Better Tests - alternative version of testing code, which should be better. It fixes smells and shows good practices (sometimes opinionated)
    * :+1: Good practices -  comments exactly, whats better and what mistakes has been resolved

#### `Bad` vs `Better` prefix naming convention
* `Bad*` - classes representing common mistakes and anti-patterns
* `Better*` - alternative classes showing how above examples could be easily improved

#### Comment types:
* ```
    /** All comments storing additional information withing presented example **/
  ```

* ```
    // Alternative version of code **/
  ```

01. [Hello tests](01/README.md) - your first test

    ![.images/01.jpg](.images/01.jpg)

02. [Fifty shades of smog](02/README.md) - dealing with multiple data

    ![.images/02.jpg](.images/02.jpg)

03. [Only good weather data, (no) exceptions](03/README.md) - testing exceptions

    ![.images/03.png](.images/03.png)

03. [Gone with the wind! (anemic vs domain)](04/README.md) - simple difference between anemic and domain models

    ![.images/04.png](.images/04.png)