Reponse question 1 :

toString : sert à obtenir une représentation d'un objet sous forme d'une chaîne de caractère

equals : cette méthode permet de comparer la valeur de deux instances

HashCode : La méthode hashCode() sert à retourner un “résumé” d'une instance, qui sert à optimiser l'utilisation de la méthode equals().
           permet de renvoyer la valeur de hachage de l'objet

Reponse question 2 :

List et Tableau : 
	tableau peut contenir des valeurs primitive, list des objets seulement
	structure differente
	allocation dynamique pour list, et fixe pour tableau

List et Arraylist :
	List est une interface tandis que La classe ArrayList hérite de l’interface List
	list est utilise pour creer une liste d’element, arrayList pour creer un tableau dynamique d’objets

Map et HashMap :
	Map est une interface en Java. Et HashMap est une implémentation de cette interface

Set et HashSet :
	Set est une interface, HashSet est une implémentation de cette interface 

List et Set :
	List est un regroupement ordonné d’item
    Set est un regroupement non ordonné d’item, sans double utilisation.


Reponse question 3 :

- séparation relativement simple et rigoureuse entre deux parties importantes d'une application 
elles peuvent ne rien savoir l'une de l'autre, et peuvent évoluer fréquemment et indépendamment. 

cela permet donc d'accèder à une source de données, de manière indépendante de cette source

