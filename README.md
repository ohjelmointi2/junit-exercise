# Java & Gradle -projektipohja

Tämä pohja sisältää valmiiksi määritellyt Gradle-skriptit, .gitignore-tiedoston ja .gitattributes-tiedoston auttaakseen sinua aloittamaan Java-projektisi nopeasti ja tehokkaasti.


## Gradle ja "wrapper scripts"

Gradle on suosittu "build automation"-työkalu, joka helpottaa projektin sekä riippuvuuksien hallintaa. Gradlew-skriptit (wrapper scripts) ovat osa Gradlea ja ne mahdollistavat Gradlen käytön ilman, että sinun tarvitsee asentaa Gradle erikseen. Voit ajaa projektiin liittyviä Gradle-tehtäviä suoraan näiden skriptien kautta.


### Gradlen käyttö

Skriptit ovat saatavilla projektitiedostojen juuressa. Voit käyttää niitä seuraavasti:

**Unix**:

```bash
./gradlew build    # kääntää projektin ja tuottaa suoritettavan JAR-tiedoston
./gradlew test     # suorittaa projektiin liittyvät testit
```

**Windows**:

```powershell
.\gradlew.bat build    # kääntää projektin ja tuottaa suoritettavan JAR-tiedoston
.\gradlew.bat test     # suorittaa projektiin liittyvät testit
```

Ensimmäisen komennon suorittamisen yhteydessä Gradle lataa tarvittavat riippuvuudet automaattisesti.


## .gitignore ja .gitattributes

Tämä pohja sisältää myös valmiiksi määritellyt `.gitignore`- ja `.gitattributes`-tiedostot. `.gitignore`:ssa on määritelty, mitkä tiedostot jätetään versionhallinnan ulkopuolelle, kun taas `.gitattributes`-tiedostossa on määritetty eri tiedostotyypeille yhtenäiset rivinvaihtomerkit.

Voit muokata näitä tiedostoja tarpeidesi mukaan.


## Miten käytän tätä pohjaa

1. Forkkaa tämä projekti omalle GitHub-tilillesi. Käytä "Fork" -painiketta tämän projektin GitHub-sivulla.

2. Kloonaa forkkaamasi projekti omalle tietokoneellesi:

   ```bash
   git clone https://github.com/OMA_KÄYTTÄJÄTUNNUKSESI/projekti.git
   ```

3. Muokkaa projektin tiedostoja ja koodia tarpeidesi mukaan.

4. Käytä Gradle-skriptejä suorittaaksesi erilaisia tehtäviä projektissasi.

5. Lisää oma koodisi ja muokatut tiedostot Git-versionhallintaan:

   ```bash
   git add .
   git commit -m "Ensimmäinen commit"
   ```

6. Pushaa muutokset GitHubiin omalle forkkaamallesi projektille:

   ```bash
   git push origin master
   ```

7. Voit sitten tehdä "Pull Requestin" (PR) alkuperäiselle projektille, kun olet valmis jakamaan muutoksesi.


## Projekti Avaminen Eclipsessä

1. Avaa Eclipse ja valitse `File -> Open Projects from File System...`.

2. Valitse `Directory...` ja valitse projektin kansio, jonka olet aiemmin kloonannut.

3. Klikkaa `Finish` avataksesi projektin Eclipse-ssä.


## Projekti Avaminen Visual Studio Codessa

1. Avaa Visual Studio Code ja valitse `File -> Open Folder...`.

2. Valitse projektin kansio, jonka olet aiemmin kloonannut ja klikkaa `Open`.

3. Voit nyt muokata, rakentaa ja suorittaa projektiasi Visual Studio Codessa.



## Lisätietoja

Lisätietoja Gradlesta ja sen käytöstä löydät [Gradlen virallisilta verkkosivuilta](https://gradle.org/).

Hyvää koodausta ja onnea projektisi kanssa!

-----

Tämän tiedoston luonnissa on hyödynnetty [GhatGPT 3.5](https://chat.openai.com/) -kielimallia.
