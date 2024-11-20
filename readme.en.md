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

### Osa 2.1: kirjoita `dayOfYear`-metodille JUnit-yksikkötestit

Lisää projektiin uusi testiluokka `DayOfYearTest`, jossa hyödynnät  JUnit-testikirjastoa testataksesi `dayOfYear`-metodin toimivuutta erilaisilla testitapauksilla. Testiluokat tulee lisätä [src/test/java/](./src/test/java/)-hakemistoon, jotta JUnit löytää ne ja jotta niissä voidaan hyödyntää JUnit-kirjastoa. Testiluokat sijaitsevat tyypillisesti samannimisessä paketissa kuin testattavat luokat, eli tässä tapauksessa luo `src/test/java`-hakemistoon tätä uutta testiä varten paketti nimeltä `refactoring`. Lisää testiluokkasi alkuun myös rivi: `package refactoring;`.

Kirjoita testiluokkaasi riittävät testitapaukset, jotta voit todentaa metodin toiminnan ja siinä mahdollisesti esiintyvät virheet vuoden eri ajankohtina huomioiden karkausvuosilogiikan. Kirjoita eri testitapaukset kukin omaan `@Test`-metodiin.

Voit suorittaa testiluokkasi tuttuun tapaan joko koodieditorillasi tai Gradlen avulla. Automaattisessa arvioinnissa testisi suoritetaan komennolla:

```
./gradlew test --tests DayOfYearTest       # unix
.\gradlew.bat test --tests DayOfYearTest   # windows
```

💡 *Tässä vaiheessa testisi toivottavasti löytävät metodissa valmiiksi olevia bugeja, joten kaikki testit eivät vielä mene läpi.*

💡 *Muista lisätä uusi `src/test/refactoring`-hakemisto ja `DayOfYearTest.java`-tiedosto versionhallintaan `git add`-komennolla. Katso tarvittaessa `git status`, joka kertoo miten tämä tehdään.*


### Osa 2.2: `dayOfYear`-metodin korjaus ja refaktorointi

Tähän asti olet ohjelmointiopinnoissasi kenties keskittynyt lähinnä saamaan ohjelmasi toimimaan tehtävänannon mukaisesti kiinnittämättä suurempaa huomiota sen ymmärrettävyyteen tai jatkokehitettävyyteen. Voimme olettaa myös annetun `dayOfYear`-metodin syntyneen näin. Ammatillisessa ohjelmistokehityksessä on harvinaista, että samaa koodia työstettäisiin vain kerran tai vain yhden kehittäjän toimesta. Päinvastoin, koodia kirjoitetaan tiimeissä, joissa kehittäjät vaihtuvat ja olemassa oleviin ominaisuuksiin tehdään jatkuvasti muutoksia ja korjauksia.

Tulet siis itse jatkokehittämään jonkun toisen vuosia sitten kirjoittamaa koodia, aivan kuten joku muu tulee jatkokehittämään sinun koodiasi. Tällöin on erittäin tärkeää, että koodi on muokattavissa ilman odottamattomia rikkoutumisia ja että muut kehittäjät ymmärtävät toistensa koodia ja pystyvät hyödyntämään ja muokkaamaan sitä.

Kun luet `dayOfYear`-metodin sisältämää koodia tarkemmin, huomaat, että siinä on käytetty ohjelmoinnin perusrakenteita melko suppeasti. Koodi koostuukin erittäin pitkästä `if-else`-rakenteesta sekä samanlaisista kokonaislukujen yhteenlaskuista. Samat numerot myös esiintyvät koodissa toistuvasti ja ne saattavat olla virheellisiä.

Bugien korjauksessa sinulle voi olla hyötyä Javan valmiista [`Year`-luokasta ja sen `isLeap`-metodista](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Year.html#isLeap(long)). Voit myös tarkistaa eri kuukausien oikeat pituudet esimerkiksi [Wikipediasta](https://fi.wikipedia.org/wiki/Kuukausi). Kuukausien pituuksien "kovakoodaus" ei toisaalta ole välttämättä kannattavaa, koska Javasta löytyy valmiiksi sekä [Month](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Month.html)- että [YearMonth](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/YearMonth.html)-luokat, jotka [sisältävät logiikkaa kuukausien pituuksien laskemiseksi](https://github.com/AdoptOpenJDK/openjdk-jdk9u/blob/9347c48cc4ce5d966c7f0c0a751c313eb0cba99a/jdk/src/java.base/share/classes/java/time/Month.java#L425-L437).

📣 Korjaamasi koodin tulee olla ymmärrettävämpää ja ylläpidettävämpää kuin alkuperäinen koodi, mutta toimia ulkoisesti samalla tavalla. **Et siis saa muuttaa metodin otsikkoa etkä esimerkiksi parametrien järjestystä.**

> *"Refaktorointi tarkoittaa prosessia, jossa tietokoneohjelman lähdekoodia muutetaan siten, että sen toiminnallisuus säilyy, mutta sen sisäinen rakenne muuttuu. Muutokset voivat koskea esimerkiksi luettavuutta tai ohjelmakomponenttien työnjaon selkeyttämistä."*
>
> Wikipedia. [Refaktorointi](https://fi.wikipedia.org/wiki/Refaktorointi). Viitattu 28.11.2023. [CC BY–SA 3.0](https://fi.wikipedia.org/wiki/Wikipedia:Creative_Commons_Attribution-Share_Alike_3.0_Unported_-lisenssiehdot)


⛔ *Javan standardikirjastossa on olemassa useita valmiita toimivia toteutuksia päivän järjestysnumeron laskemiselle. Oikeassa ohjelmistoprojektissa sinun tulisi luonnollisesti käyttää valmista ratkaisua, eikä yrittää keksiä pyörää uudestaan. Tämän harjoituksen tavoitteena on kuitenkin opetella testaamaan ja refaktoroimaan koodia, joten suosittelemme muodostamaan oman ratkaisun annettua koodia muokkaamalla.*


**"Code smells"**

Tutustu seuraaviin "koodin hajuihin" esimerkkikoodissa ja parantele koodia parhaasi mukaan:

- [Don't Repeat Yourself](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself)
- [Comments Where Needed](https://stackoverflow.blog/2021/12/23/best-practices-for-writing-code-comments/)
- [Fail Fast](https://en.wikipedia.org/wiki/Fail-fast)
- [Avoid Magic Numbers](https://en.wikipedia.org/wiki/Magic_number_(programming))
- [One Purpose For Each Variable](https://en.wikipedia.org/wiki/Single-responsibility_principle)

Edellä mainittu lista koodin "hajuista" on käyty läpi tämän saman esimerkkikoodin avulla osoitteessa [https://web.mit.edu/6.005/www/fa16/classes/04-code-review/](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/). Voit käyttää myös muita lähteitä.


**Linkit**

* [Year-luokka](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/Year.html)
* [Month-luokka](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/Month.html)
* [YearMonth-luokka](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/YearMonth.html)
* [Tehtävän alkuperäinen lähde](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/)


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
