[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LylzhpHc)
# TP Maven-JUnit
L'objet de cet exercice est de réaliser une classe `ChaineCryptee` qui permettra de chiffrer/déchiffrer une chaîne de caractères (**composée de lettres majuscules et d'espace**).
Le chiffrement utilise une méthode par décalage.
La valeur du décalage représente la clé de chiffrement.
Par exemple, une clé de valeur trois transformera un `'A'` en `'D'`.

La classe `ChaineCryptee` disposera
* des attributs pour la chaîne *en clair* et le décalage,
* un constructeur pour initialiser les instances à partir d'une chaîne en clair et du décalage,
* la méthode `String decrypte()` qui retourne la chaîne en clair,
* la méthode `String crypte()` qui retourne la chaîne chiffrée,
Vous pourrez utilisez pour cela la [méthode `decaleCaractere`](https://gist.github.com/hal91190/4f3a0941e652e82a5e1c572834d97827),
* la possibilité d'initialiser une instance à partir d'une chaîne cryptée et d'un décalage.
Pour éviter l'ambiguïté au niveau du constructeur, vous utiliserez le [modèle de conception Fabrication](http://fr.wikipedia.org/wiki/Fabrique_%28patron_de_conception%29#Autres_avantages_et_variantes).
Pour cela,
    * créez les méthodes de classe `ChaineCryptee deCryptee(String, int)` et `ChaineCryptee deEnClair(String, int)`,
    * rendez le constructeur privé.
La création des instances se fait maintenant à l'aide des deux méthodes de classe.

De plus, le projet sera géré avec [Maven](https://maven.apache.org/) et vous utiliserez une approche pilotée par les tests pour la réalisation, i.e. écrivez toujours un test avant le code et pensez au refactoring.
Le framework de tests devra être [JUnit 5](https://junit.org/junit5/).
Vous rédigerez votre code source en respectant les [conventions de codage](https://google.github.io/styleguide/javaguide.html) du guide de stype _Google_.
Enfin, la prise en compte des contraintes se fera par de la gestion d’erreurs et des exceptions.

Il pourra éventuellement être nécessaire de [configurer le proxy](http://maven.apache.org/guides/mini/guide-proxies.html) (http://wwwcache.uvsq.fr:3128) pour accéder au dépôt Maven.

À chaque étape, validez vos modifications avec `git` et si nécessaire, exécutez le cycle maven adapté pour vérifier vos manipulations.

1.  Quelles conventions utilise Maven pour l’arborescence des répertoires ?
    > Maven utilise une arborescence standardisée :
Le code source se trouve dans src/main/java
Les ressources dans src/main/resources
Les tests dans src/test/java
Les ressources de test dans src/test/resources
Les fichiers compilés et exécutables sont générés dans le répertoire target/
Le fichier pom.xml à la racine contient la configuration du projet
Ces conventions permettent à Maven de gérer automatiquement la compilation, les tests et le packaging.
 
2. Examinez le projet Maven ainsi que le fichier de description et répondez aux questions suivantes :
    1.  Dans quel répertoire se trouvent les fichiers sources du projet ? Les sources des tests ?
        > Les fichiers sources du projet se trouvent dans le répertoire :
        src/main/java
        et les fichiers de tests se trouvent dans :
        src/test/java.
Ces emplacements sont imposés par la convention Maven : le dossier main contient le code principal, et le dossier test contient uniquement le code utilisé pour les tests unitaires.
    2. Quelles sont les coordonnées du projet ?
        > Les coordonnées du projet se trouvent dans le fichier pom.xml et sont définies par les balises suivantes :
     <groupId>com.mycompany</groupId>
     <artifactId>td2-chaima-29</artifactId>
     <version>1.0-SNAPSHOT</version>
    3. À quoi sert la propriété `project.build.sourceEncoding` ?
        > La propriété project.build.sourceEncoding définit l’encodage des fichiers sources (par exemple UTF-8).
       Elle permet d’éviter les erreurs liées aux caractères spéciaux (comme les accents) lors de la compilation.
    4. Quelles versions des sources et de la JVM sont utilisés ?
        > le projet est compilé avec Java 17, et les fichiers .class générés sont compatibles avec la JVM Java 17.
    5. Quelle version de JUnit est configurée ? À quoi sert la balise `scope` ?
        > Le projet utilise JUnit 5.8.2
        > Balise <scope> : indique que cette dépendance est utilisée uniquement pour les tests.
       Elle ne sera donc pas incluse dans le JAR final du projet
    6. À quoi sert la section `pluginManagement` ?
        > La section <pluginManagement> sert à définir les versions par défaut des plugins Maven utilisés dans le projet (ou dans ses sous-modules).
       Elle ne déclenche pas directement l’exécution des plugins, mais précise à Maven quelle version utiliser lorsqu’un plugin est appelé ailleurs dans le pom.xml.
3.  Modifiez la configuration du projet de la façon suivante :
    1.  fixez la version des sources et des .class pour utiliser la version 17 de Java
    2.  utilisez la dernière version stable de JUnit 4 (cf. [MVNRepository](https://mvnrepository.com/))
4.  Ajoutez un fichier `.gitignore` adapté aux projets Maven (cf. [A collection of .gitignore templates](https://github.com/github/gitignore)) et ajoutez-y les fichiers et répertoires de votre IDE.
5.  Quelle commande Maven permet de :
    1.  créer un `jar` du projet ?
        > mvn package
    2. lancer les tests ?
        > mvn test
    3. supprimer tous les fichiers issus de la compilation ?
        > mvn clean
6.  Ajoutez une classe `ChaineCryptee` et une classe `ChaineCrypteeTest` dans les répertoires et packages appropriés.
    Supprimez les classes d'exemple `App` et `AppTest`.
7.  Énumérez une liste de cas de tests à réaliser en n'oubliant pas les cas d'erreur.
    > Voici les principaux cas de tests à prévoir pour vérifier le bon fonctionnement de la classe ChaineCryptee :
      Cas normaux :
      Vérifier que le chiffrement d’une chaîne simple fonctionne correctement (exemple : "ABC" → "DEF" avec un décalage de 3).
      Vérifier que le déchiffrement fonctionne correctement (exemple : "DEF" → "ABC").
      Vérifier que les espaces ne sont pas modifiés.
      Vérifier que la lettre 'Z' revient bien à 'C' lors du décalage (bouclage de l’alphabet).
      Cas limites et erreurs :
      Vérifier qu’une chaîne vide ("") renvoie une chaîne vide.
      Vérifier qu’une chaîne null ne provoque pas d’erreur.
      Vérifier qu’un décalage nul (0) laisse la chaîne inchangée.
      Vérifier qu’un décalage supérieur à 26 est bien pris en compte grâce au calcul modulaire.
      (Optionnel) Vérifier la gestion des caractères non autorisés (autres que les majuscules et les espaces).
      Ces tests permettent de s’assurer que la classe fonctionne correctement dans les cas normaux, mais aussi dans les situations limites ou d’erreur.
 
8. Pour chaque cas de test,
    1. écrivez le test JUnit correspondant dans la classe de test,
    2. vérifiez qu’il échoue,
    3. implémentez la fonctionnalité dans la classe,
    4. vérifiez que le test passe,
    5. appliquez un étape de refactoring sur les tests et la classe si nécessaire.
1.  Comment se comporte votre classe si la chaîne passée au constructeur est `null` ?
Vous pouvez utiliser le débogueur pour identifier le problème (s'il y a un problème) au niveau de `crypte`.
    > RÉPONDRE ICI
    1. ajoutez un test pour prendre en compte la chaîne `null`,
    1. si nécessaire, modifiez la classe pour faire passer le test
1. Changez la représentation interne de la classe : seule la chaîne cryptée est stockée (plus la chaîne en clair).
    * effectuez les modifications nécessaires sans changer l'interface de la classe (les tests ne seront donc pas impactés).
1.  Modifiez le POM pour intégrer la vérification des conventions de codage avec [`checkstyle`](http://maven.apache.org/plugins/maven-checkstyle-plugin/) en utilisant les conventions _Google_.
1.  Ajoutez une méthode `main` qui démontre quelques fonctionnalités de la classe, puis modifiez le POM pour que le jar généré soit exécutable (cf. [Apache Maven JAR Plugin](https://maven.apache.org/plugins/maven-jar-plugin/index.html))
1.  Modifiez la méthode `main` pour que les différents affichages se fassent à l'aide de la bibliothèque de logging [`SLF4J`](http://www.slf4j.org/)
1. En utilisant le plugin [assembly](https://maven.apache.org/plugins/maven-assembly-plugin/) (ou le plugin [shade](https://maven.apache.org/plugins/maven-shade-plugin/)), générez une archive du projet contenant ses dépendances (uber-jar)
