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


## Déploiement
