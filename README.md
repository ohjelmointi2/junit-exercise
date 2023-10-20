# Yksikkötestaus JUnit-työkalulla

Tämä repositorio sisältää joukon Java-harjoituksia, joiden avulla harjoittelet yksikkötestausta JUnit-työkalun avustuksella.

Tästä tiedostosta löydät tehtävänannot sekä ohjeet ratkaisusi testaamiseksi. Tarkemmat ohjeet kunkin metodin ja luokan toiminnasta löydät tehtäväpohjan valmiista Java-luokista.

Voit suorittaa testisi joko koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html).


## Tehtävän aloittaminen

Aloita kloonaa Git-repositorio omalle koneellesi. Harjoitus täytyy tehdä omassa kopiossasi, eli varmista, että repositorion osoitteessa on mukana oma GitHub-käyttäjätunnuksesi! Oman kopiosi saat luotua kurssitoteutuksesi tehtävänannon GitHub classroom -linkin kautta.

```sh
git clone https://github.com/varmista-etta-github-tunnuksesi-on-repositorion-osoitteessa.git
```

Kloonattuasi projektin omalle koneellesi, avaa se koodieditorissasi.


## Vastausten lähettäminen

Kun olet saanut osan tai kaikki tehtävistä ratkaistua ja commitoinut vastauksesi, lähetä ratkaisut arvioitavaksi `git push`-komennolla. Git push käynnistää automaattisesti GitHub actions -workflow:n, joka kääntää sekä testaa ratkaisusi ja antaa jokaisesta testistä joko hyväksytyn tai hylätyn tuloksen.

Kun GitHub Actions on saanut koodisi suoritettua, näet tuloksen GitHub-repositoriosi [Actions-välilehdellä](../../actions/workflows/classroom.yml). Arvioinnin valmistumiseen menee tyypillisesti pari minuuttia.

Klikkaamalla yllä olevan linkin takaa viimeisintä *"GitHub Classroom Workflow"* -suoritusta, saat tarkemmat tiedot tehtävän arvioinnista. Sivun alaosassa näkyy saamasi pisteet. Klikkaamalla "Autograding"-otsikkoa pääset katsomaan tarkemmin arvioinnissa suoritetut vaiheet ja niiden tulokset. Kuvitetun ohjeen aiheesta löydät GitHubin dokumentista [View autograding results (github.com)](https://docs.github.com/en/education/manage-coursework-with-github-classroom/learn-with-github-classroom/view-autograding-results).

💡 *Voit lähettää ratkaisusi arvioitavaksi niin monta kertaa kuin on tarpeen tehtävän määräaikaan asti. Varmista kuitenkin, että viimeisin suoritus tuottaa parhaat pisteet, koska vain viimeisimmät pisteet jäävät voimaan.*


### Osa 1: *(perusteet, 30 %)*

### Osa 2: *(perusteet, 30 %)*


```sh
./gradlew test --tests TODO      # unix
gradlew.bat test --tests TODO    # windows
```

## Lisenssi ja tekijät

Tämän tehtävän on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA -lisenssillä](https://creativecommons.org/licenses/by-nc-sa/4.0/).

Tehtävänannon, lähdekoodien ja testien toteutuksessa on hyödynnetty ChatGPT 3.5 -kielimallia sekä GitHub copilot -tekoälyavustinta.
