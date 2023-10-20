# Yksikkötestaus JUnit-työkalulla

Tämä repositorio sisältää Java-harjoituksia, joiden avulla harjoittelet yksikkötestausta [JUnit-työkalun](https://junit.org) avustuksella.

Aikaisemmista tehtävistä poiketen tässä tehtävässä ei ole valmiita testejä, vaan kirjoitat testit itse. Testattava Java-luokka sen sijaan on annettuna valmiina.

Voit suorittaa testisi joko koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html).


## Tehtävän aloittaminen

Aloita kloonaamalla Git-repositorio omalle koneellesi. Harjoitus täytyy tehdä omassa kopiossasi, eli varmista, että repositorion osoitteessa on mukana oma GitHub-käyttäjätunnuksesi! Oman kopiosi saat luotua kurssitoteutuksesi tehtävänannon GitHub classroom -linkin kautta.

```sh
git clone https://github.com/varmista-etta-github-tunnuksesi-on-repositorion-osoitteessa.git
```

Kloonattuasi projektin omalle koneellesi, avaa se koodieditorissasi.


## Vastausten lähettäminen

Kun olet saanut osan tai kaikki tehtävistä ratkaistua ja commitoinut vastauksesi, lähetä ratkaisut arvioitavaksi `git push`-komennolla. Git push käynnistää automaattisesti GitHub actions -workflow:n, joka kääntää sekä testaa ratkaisusi ja antaa jokaisesta testistä joko hyväksytyn tai hylätyn tuloksen.

Kun GitHub Actions on saanut koodisi suoritettua, näet tuloksen GitHub-repositoriosi [Actions-välilehdellä](../../actions/workflows/classroom.yml). Arvioinnin valmistumiseen menee tyypillisesti pari minuuttia.

Klikkaamalla yllä olevan linkin takaa viimeisintä *"GitHub Classroom Workflow"* -suoritusta, saat tarkemmat tiedot tehtävän arvioinnista. Sivun alaosassa näkyy saamasi pisteet. Klikkaamalla "Autograding"-otsikkoa pääset katsomaan tarkemmin arvioinnissa suoritetut vaiheet ja niiden tulokset. Kuvitetun ohjeen aiheesta löydät GitHubin dokumentista [View autograding results (github.com)](https://docs.github.com/en/education/manage-coursework-with-github-classroom/learn-with-github-classroom/view-autograding-results).

💡 *Voit lähettää ratkaisusi arvioitavaksi niin monta kertaa kuin on tarpeen tehtävän määräaikaan asti. Varmista kuitenkin, että viimeisin suoritus tuottaa parhaat pisteet, koska vain viimeisimmät pisteet jäävät voimaan.*

## Tehtävä

Tässä tehtävässä sinun tulee kirjoittaa yksikkötestejä valmiissa `PriceFormatter`-luokassa olevalle `formatPrice`-metodille. Metodi saa parametrinaan liukuluvun ja se palauttaa annetun liukuluvun merkkijonoksi muotoiltuna tiettyjen sääntöjen mukaisesti. Metodin kutsuminen onnistuu esim. seuraavasti:

```java
PriceFormatter formatter = new PriceFormatter();
String price = formatter.formatPrice(Math.PI); // 3,14 €
```

Perustapauksessa metodin pitäisi muotoilla annettu liukuluku muotoon `"123 456,78 €"`. Muotoilun suhteen on seuraavat tarkentavat säännöt:

1. Tuhaterottimena tulee käyttää välilyöntiä.
1. Desimaalierottimena tulee käyttää pilkkua.
1. Desimaaliosassa kahden numeron pituinen, seuraavin tarkennuksin:
    1. Jos desimaaliosa on nolla, jätetään desimaaliosa kokonaan pois.
    1. Desimaaliosa tulee pyöristää lähimpään sadasosaan eli senttiin.
1. Hinnan lopussa on oltava Euro-symboli `€`.

**Huomaa, että sinun ei tarvitse itse toteuttaa yllä esitettyä metodia tai siihen kuuluvia ehtoja.** Metodin toteuttamisen sijasta harjoittelemme valmiin metodin testaamista.


### Osa 1: *(perusteet, 25 %)*

Toteuta tehtäväpohjan [PriceFormatterTest](./src/test/java/exercise/PriceFormatterTest.java)-luokkaan omat yksikkötestit, jotka varmistavat eri syötteiden avulla, että valmis metodi tosiaan toimii yllä kuvatulla tavalla.

Tässä tehtävässä projektipohja ei sisällä testattavan luokan lähdekoodia, vaan luokka on valmiiksi käännetyssä [jar-paketissa](./libs/). Luokan testaamiseksi et tarvitse sen lähdekoodia: tärkeämpää on, että tiedossasi on metodin toimintaa koskevat vaatimukset.

Voit suorittaa testisi joko koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```sh
./gradlew test --tests PriceFormatterTest      # unix
gradlew.bat test --tests PriceFormatterTest    # windows
```

Huomaa, että testiesi tulisi tässä vaiheessa mennä läpi, koska testattavassa luokassa ei pitäisi olla loogisia virheitä.


### Osa 2: *(soveltaminen, 5 * 15 %)*

Se, että testit menivät läpi, ei välttämättä tarkoita, että testit olisivat kattavat tai että testattavassa koodissa ei olisi bugeja. Jotta varmistamme, että testisi löytävät myös koodissa mahdollisesti piilevät virheet, olemme lisänneet metodiin 5 yksittäistä bugia 😈.

Tehtävän toisessa osassa testisi ajetaan viiteen kertaan viittä eri tavoin bugista toteutusta vasten. Saat kustakin suorituksesta pisteet, mikäli testisi **eivät mene läpi**, eli ne löytävät bugin.

💡 *Näiden soveltavien testien suorittaminen edellyttää, että alkuperäinen toimiva koodi läpäisee testisi.*


## Lisenssi ja tekijät

Tämän tehtävän on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA -lisenssillä](https://creativecommons.org/licenses/by-nc-sa/4.0/).

Tehtävänannon, lähdekoodien ja testien toteutuksessa on hyödynnetty ChatGPT 3.5 -kielimallia sekä GitHub copilot -tekoälyavustinta.
