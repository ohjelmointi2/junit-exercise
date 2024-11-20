# Unit testing with the JUnit tool

This repository contains Java exercises to practice unit testing with the help of the JUnit tool.

Unlike previous exercises, this task does not have pre-written tests; you will write the tests yourself. However, the Java classes to be tested are already in the project template.

You can run your tests using either the testing tool in your code editor ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) or the [Gradle automation tool](https://docs.gradle.org/current/userguide/java_testing.html).

## Starting the exercise

Start by cloning the Git repository to your local machine. The exercise must be done in your own copy, so make sure the repository URL includes your GitHub username! You can create your own copy through the GitHub Classroom link provided in your course assignment.

```sh
git clone https://github.com/make-sure-that-the-repository-address-contains-your-account.git
```

After cloning the project to your local machine, open it in your code editor.

## Submitting solutions

Once you have solved some or all of the tasks and committed your answers, submit the solutions for evaluation using the `git push` command. Git push will automatically trigger a GitHub Actions workflow that compiles and tests your solutions, providing a pass or fail result for each test.

Once the GitHub Actions has executed your code, you see the results in your GitHub repository's [Actions tab](../../actions/workflows/classroom.yml). It usually takes a few minutes for the assesment to be completed. 

By clicking on the latest *"GitHub Classroom Workflow"* execution from the link above, you will get detailed information about the task evaluation. At the bottom of the page, you can see the points you received. By clicking on the "Autograding" heading, you can view the steps performed during the evaluation and their results in more detail. You can find an illustrated guide on this topic in the GitHub documentation [View autograding results (github.com)](https://docs.github.com/en/education/manage-coursework-with-github-classroom/learn-with-github-classroom/view-autograding-results).

💡 *You can submit your solution for evaluation as many times as needed until the task deadline. However, ensure that your latest submission yields the best scores, as only the most recent scores will be retained.*

## Exercise 1: PriceFormatter

In this exercise, you need to write unit tests for the provided `PriceFormatter` class and its `formatPrice` method. The method takes a floating-point number as a parameter and returns it formatted as a string according to specific rules. You can call the method as follows:

```java
PriceFormatter formatter = new PriceFormatter();
String price = formatter.formatPrice(3.141592653589793); // Returns "3,14 €"
```

In the basic case, the method should format the given floating-point number as `"123 456,79 €"`. The formatting rules are as follows:

1. A space is used as the thousands separator.
2. A comma is used as the decimal separator.
3. The decimal part is two digits long, with the following clarifications:
    1. The decimal part is rounded to the nearest hundredth (i.e., cent). Additional tip.
    2. If the decimal part is zero after rounding, it is omitted entirely.
4. The Euro symbol `€` is placed at the end of the price.

**Note that you do not need to implement the method or its conditions yourself.** Instead of implementing the method, we will practice *testing* the provided method.

### PriceFormatterTest *(basics)*

Implement your own unit tests in the [PriceFormatterTest](./src/test/java/price/formatter/PriceFormatterTest.java) class of the task template to ensure that the provided `formatPrice` method works as described above with different inputs. We recommend writing a separate test method for each rule.

In your test methods, call the `formatPrice` method with various parameters and ensure that the values returned by the method comply with the specified rules:

```java
PriceFormatter formatter = new PriceFormatter();
String result = formatter.formatPrice(Math.PI); // Should be 3.14 €
```

You can run your tests using either the testing tool in your code editor [VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) or the [Gradle automation tool]((https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests PriceFormatterTest       # unix
.\gradlew.bat test --tests PriceFormatterTest   # windows
```

✅ Note that your own tests should pass at this stage because the method being tested should not have logical errors.

💡 *To test the method, you do not need to delve into its source code. What is more important is that you are aware of the **requirements** for the method's functionality as described above.*

💡 *If you use numbers in your tests that fall exactly halfway between hundredths, you might encounter issues related to the limited precision of floating-point numbers. This problem is not due to Java or your own or the tested code, but rather how computers handle decimal fractions. A more detailed explanation can be found in the file [rounding.md](./rounding.md) in this repository or in the article ["What Every Computer Scientist Should Know About Floating-Point Arithmetic" (oracle.com)](https://docs.oracle.com/cd/E19957-01/806-3568/ncg_goldberg.html).*

⛔ *You must not make any changes to the `PriceFormatter` class.*

### Exercise's points *(5 * 10 %)*

The fact that tests "pass" does not necessarily mean that the tests are comprehensive or that the code being tested is bug-free. To ensure that your tests are comprehensive, your tests will also be run against **five different buggy versions** 😈. Your tests must find the bugs hidden in these versions.

If you wrote comprehensive test cases for all the formatting rules mentioned earlier, this part does not require changes to your tests 😎. If your tests do not find all the bugs in the GitHub classroom's automatic check, continue developing the [`PriceFormatterTest`](./src/test/java/price/formatter/PriceFormatterTest.java) class and ensure that your tests check all the formatting rules mentioned above with different inputs.

💡 *In this part, your tests will be run five times against five different buggy versions of the `formatPrice` method. You will score points for each run if the buggy version of the `formatPrice` method **causes an error** in at least one of your test methods. If the tests pass, it means the bug was not found, and you will not score points.*

💡 *Running these applied tests requires that the original working version of the `formatPrice` method first passes your own tests.*

🚀 *The task assessment applies a method called mutation testing: "Mutation testing is used to design new software tests and evaluate the quality of existing software tests. Mutation testing involves modifying a program in small ways." [(Wikipedia)](https://en.wikipedia.org/wiki/Mutation_testing)*

## Exercise 2: DayOfYear *(applying, 2 * 25 %)*

In the second exercise of this repository, you need to implement JUnit unit tests for the [provided `DayOfYear` class](./src/main/java/refactoring/DayOfYear.java). The class has one static method named `dayOfYear`. This method takes a date as three integers and should return the ordinal number of the given date in that year (1-366). The first day of the year is numbered 1, and the last day is either 365 or 366, depending on the year.

Reading and understanding the method's content is not necessary for the tests. Design the test cases based on how the method **should** work, not how it actually works.

> *"Some data sets specify dates using the year and day of year rather than the year, month, and day of month. The day of year (DOY) is the sequential day number starting with day 1 on January 1st."*
>
> [Day of the Year (DOY) calendar. National Snow and Ice Data Center](https://nsidc.org/data/user-resources/help-center/day-year-doy-calendar)

You can explore the "day of year" numbers corresponding to different dates using the [Day of the Year (DOY) calendar](https://nsidc.org/data/user-resources/help-center/day-year-doy-calendar) (National Snow and Ice Data Center). Note that from March onwards, the numbers for different days vary between common and leap years.

**The provided method contains bugs**, which you need to find using your own JUnit tests in this task.

### Part 2.1: write JUnit unit tests for the `dayOfYear` method

Add a new test class `DayOfYearTest` to the project, where you will use the JUnit testing library to test the functionality of the `dayOfYear` method with various test cases. Test classes should be added to the [src/test/java/](./src/test/java/) directory so that JUnit can find them and utilize the JUnit library. Test classes are typically located in the same package as the classes being tested, so in this case, create a package named `refactoring` in the `src/test/java` directory for this new test. Also, add the line `package refactoring;` at the beginning of your test class.

Write sufficient test cases in your test class to verify the method's functionality and any potential errors at different times of the year, considering the leap year logic. Write each test case in its own `@Test` method.

You can run your test class as usual, either with your code editor or with Gradle. In the automatic assessment, your tests will be run with the command:

```
./gradlew test --tests DayOfYearTest       # unix
.\gradlew.bat test --tests DayOfYearTest   # windows
```

💡 *At this stage, your tests will hopefully find the pre-existing bugs in the method, so not all tests will pass yet.*

💡 *Remember to add the new `src/test/refactoring` directory and `DayOfYearTest.java` file to version control with the `git add` command. If needed, check `git status` for instructions on how to do this.*

### Part 2.2: fixing and refactoring the `dayOfYear` method

So far in your programming studies, you may have focused mainly on getting your programs to work according to the assignment without paying much attention to their readability or maintainability. We can assume that the given `dayOfYear` method was created in this way. In professional software development, it is rare for the same code to be worked on only once or by only one developer. On the contrary, code is written in teams where developers change, and existing features are constantly modified and fixed.

You will therefore be further developing code written by someone else years ago, just as someone else will be further developing your code. It is very important that the code can be modified without unexpected breakages and that other developers understand each other's code and can use and modify it.

When you read the code contained in the `dayOfYear` method more closely, you will notice that it uses basic programming structures quite narrowly. The code consists of a very long `if-else` structure and similar integer additions. The same numbers also appear repeatedly in the code and may be incorrect.

When fixing bugs, you might find the Java [`Year` class and its `isLeap` method](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Year.html#isLeap(long)) useful. You can also check the correct lengths of different months, for example, on [Wikipedia](https://fi.wikipedia.org/wiki/Kuukausi). However, hardcoding the lengths of months is not necessarily advisable, as Java already provides both the [Month](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Month.html) and [YearMonth](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/YearMonth.html) classes, which [contain logic for calculating the lengths of months](https://github.com/AdoptOpenJDK/openjdk-jdk9u/blob/9347c48cc4ce5d966c7f0c0a751c313eb0cba99a/jdk/src/java.base/share/classes/java/time/Month.java#L425-L437).

📣 The code you fix should be more understandable and maintainable than the original code, but it should function externally in the same way. **Therefore, you must not change the method's signature or the order of its parameters.**

> *"In computer programming and software design, code refactoring is the process of restructuring existing source code—changing the factoring—without changing its external behavior. Refactoring is intended to improve the design, structure, and/or implementation of the software (its non-functional attributes), while preserving its functionality."*
>
> Wikipedia. [Code refactoring](https://en.wikipedia.org/wiki/Code_refactoring). Cited on 20.11.2024. [CC BY–SA 3.0](https://fi.wikipedia.org/wiki/Wikipedia:Creative_Commons_Attribution-Share_Alike_3.0_Unported_-lisenssiehdot)

⛔ *The Java standard library contains several ready-made implementations for calculating the ordinal number of a day. In a real software project, you should naturally use an existing solution rather than trying to reinvent the wheel. However, the goal of this exercise is to learn how to test and refactor code, so we recommend creating your own solution by modifying the given code.*

**"Code smells"**

Familiarize yourself with the following "code smells" in the example code and improve the code as best as you can:

- [Don't Repeat Yourself](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself)
- [Comments Where Needed](https://stackoverflow.blog/2021/12/23/best-practices-for-writing-code-comments/)
- [Fail Fast](https://en.wikipedia.org/wiki/Fail-fast)
- [Avoid Magic Numbers](https://en.wikipedia.org/wiki/Magic_number_(programming))
- [One Purpose For Each Variable](https://en.wikipedia.org/wiki/Single-responsibility_principle)

The above list of code smells has been reviewed using this same example code at <https://web.mit.edu/6.005/www/fa16/classes/04-code-review/>. You can also use other sources.

**Links**

* [Year class](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/Year.html)
* [Month class](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/Month.html)
* [YearMonth class](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/YearMonth.html)
* [The original source for the exercise](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/)

### Virheelliset parametrit &mdash; bugi vai ominaisuus? *(pohdittavaa)*

`dayOfYear`-esimerkkikoodin [alkuperäisessä lähteessä](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/#fail_fast) tuodaan esiin fail fast -ajattelutapa, jonka mukaisesti ongelmat on sitä helpompi korjata mitä aikaisemmin ne havaitaan. Tämän metodin tapauksessa metodi palauttaa kokonaislukuja riippumatta siitä, ovatko kuukausien ja päivien numerot annettu oikeassa järjestyksessä tai ovatko ne sallituilta väleiltä.

Voit halutessasi lisätä metodiin tarkastuksia ja heittää esimerkiksi `IllegalArgumentException`-poikkeuksen, mikäli metodille annetut numerot eivät vastaa todellista päivämäärää. Tämä ei kuitenkaan ole tehtävän kannalta välttämätöntä, emmekä laske virheellisiä syötteitä tämän metodin bugeiksi.


### Tehtävän pisteytys *(25 % + 25 %)*

`DayOfYear`-tehtävä arvioidaan automaattisesti kahdessa osassa. Ensimmäisessä osassa suoritamme oman `DayOfYearTest`-testiluokkasi, jonka tulee läpäistä kaikki kirjoittamasi testit.

```
./gradlew test --tests DayOfYearTest       # unix
.\gradlew.bat test --tests DayOfYearTest   # windows
```

Toisessa osassa suoritamme erillisen testiluokan, jossa varmistetaan, että `dayOfYear`-metodi toimii oikein tekemiesi korjausten jälkeen. Mikäli erillinen testiluokka havaitsee virheitä automaattisessa arvioinnissa, lue tarkasti [Actions-välilehdeltä](../../actions/workflows/classroom.yml) löytyvä raportti testien suorituksesta.



## Lisenssi ja tekijät

### DayOfYear-esimerkkiluokka (Smelly Example #1)

Tehtävässä hyödynnetty [`DayOfYear`-esimerkkiluokka](./src/main/java/refactoring/DayOfYear.java) on lainattu [MIT:n Software Construction -kurssin oppimateriaaleista](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/). Sen tekijät ja lisenssi ovat:

> *Collaboratively authored with contributions from: Saman Amarasinghe, Adam Chlipala, Srini Devadas, Michael Ernst, Max Goldman, John Guttag, Daniel Jackson, Rob Miller, Martin Rinard, and Armando Solar-Lezama.*
>
> *Licensed under [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0/deed.fi).*


### Tämä tehtävä

Tämän tehtävän on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA -lisenssillä](https://creativecommons.org/licenses/by-nc-sa/4.0/).

Tehtävänannon, lähdekoodien ja testien toteutuksessa on hyödynnetty ChatGPT 3.5 -kielimallia sekä GitHub copilot -tekoälyavustinta.
