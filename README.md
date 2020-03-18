# Mise en oeuvre de la SOA pour le nouveau système d’information de la bibliothèque d’une grande ville

Ceci est le dépôt associé au projet Développez le nouveau système d’information de la bibliothèque d’une grande ville du parcours [Expert Java EE](https://openclassrooms.com/fr/paths/99-expert-java-ee) sur [OpenClassrooms](https://openclassrooms.com).

## Technologies

### Organisation du projet

#### library avec 4 modules
- `library-model` : module contenant les entités de la solution
- `library-repository` : module contenant la persistance et le pattern DAO
- `library-service` : module contenant le web-service
- `library-soap` : module contenant les end points

#### batch
- `batch` : module contenant un batch qui envoie un mail de relance

#### Application web
- `library-webapp` : module contenant les vues et ses contrôleurs

#### MPD
![](images/library.png?raw=true)



## Déploiement

#### Configuration de la base de donnés : MySQL

- Créer une base de données MySQL

- Modifier le fichier `appilcation.properties` dans le répertoire `resources` du module `library-soap` avec les paramètres adaptés notament `database_name` que sera le nom de la base de donnée que vous avez créer:

```
spring.datasource.url = jdbc:mysql://localhost:3306/database_name?serverTimezone=UTC
spring.datasource.username= 
spring.datasource.password=
spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```
- Lorsque cela est terminé, rendez-vous dans le répertoire `library/library-soap` et tapez la commande: `mvn spring-boot:run`
Cette commande va lancer votre application et créer les tables correspondant aux différentes entités du projet dans la base de données que vous avez créée

- initialisation des données

Dans le dossier `data` vous allez trouver le fichier `data-init.sql` qui initialisé les données pour tester le service.

#### Accès au web service
Lorque toutes étapes précédantes ont été réalisé, vous pourrez avoir accès au [WSDL](http://localhost:8080/ws/library.wsdl) du web service. 
