Reponse question 1 :

Une injection SQL est un type d'exploitation d'une faille de sécurité d'une application interagissant avec une base de données. 
L'attaquant détourne les requêtes pour trouver et exploiter cette faille.

Reponse question 2 :

L'exécution des PreparedStatement est identique à celle des simples Statement, la différence est qu'il n'y a pas d'argument aux méthodes execute

Les avantages d'une PreparedStatement par rapport au Statement :
- déjà compilée : donc meilleurperformance si répétition
- un ou plusieurs paramètres d'entrée, non spécifiés a la création de l'instruction. 

le statement :
- Valeur fixe du paramètre

Reponse question 3 :

Inner join est une jointure interne, les autres sont des jointures externes 
Les mots clefs LEFT, RIGHT et FULL indiquent la manière dont le moteur de requête doit effectuer la jointure externe. 
Il font référence à la table située à gauche (LEFT) du mot clef JOIN ou à la table située à droite (RIGHT) de ce même mot clef. 
Le mot FULL indique que la jointure externe est bilatérale.



