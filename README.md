# Undercooked
Lpro RTAI

Si vous voulez démarrer l’application depuis Intellij IDEA :
Le projet comporte la dépendance Maven
Le projet comporte une musique donc les paramètres VM options doivent ressembler à ceci afin que l’application puisse fonctionner: </br>
--module-path
/Users/Jef/jetbrains/javafx-sdk-15.0.1/lib
--add-modules
javafx.controls,javafx.fxml,javafx.media
--add-exports
javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED

Pour que le projet fonctionne correctement, veuillez utiliser javaFx version 15 et java version 15 ou modifier les versions dans le pom.xml

Problèmes connus :
Si l’utilisateur n’a pas accès à internet et qu’il essaie de se connecter, l’application va planter.

Une exception “ConcurrentModificationException” est parfois levée en partie mais n’est pas problématique au fonctionnement de l’application.

