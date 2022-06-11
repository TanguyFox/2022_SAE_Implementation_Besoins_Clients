/**
 * Descriptif de la classe Frise:
 * La frise est constituée de cartes triées selon la date de l'évènement
 */
class Frise{
	/**
	 * Attributs:
	 */
	/**
	 * Tableau de cartes triées selon la date de l'évènement
	 */
	private Carte[] cartes ;



	/**
	 * Constructeur vide qui initialise le tableau de carte à 0
	 */
	public Frise(){
		cartes = new Carte[0];
	}

	/**
	 * Accesseurs
	 */
	/**
	 * Permet d'obtenir le tableau de cartes
	 */
	public Carte[] getCartes(){
		return cartes;
	}


	/**
	 * Permet d'obtenir la longueur de la frise
	 */
	public int getNbCartes(){
		return cartes.length;
	}


	/**
	 * Méthode qui ajoute une carte à un emplacement pour que le tableau de carte soit trié selon la date
	 * @param c carte à ajouté au carte déjà trié
	 */
	public void ajouterCarteTrie(Carte c){
		if(c.getDateVisible() == false) //retourne la carte si la date n'est pas visible
			c.retournerCarte();

		if(cartes.length != 0){ 
			Paquet p = new Paquet(cartes); //créer un paquet de carte à partir du tableau de carte déjà trié
			if(c.getDate() < cartes[0].getDate()) //test si la carte est avant la première carte
				p.ajouterCarteDebut(c);
			else if(c.getDate() > cartes[cartes.length-1].getDate()) //test si la carte est après la dernière carte
				p.ajouterCarteFin(c);
			else{

				int i =0;				//initialisation
				boolean arret = false;

				while(i<cartes.length && !arret){ 
					/**
					 * tant que la date qu'on veut ajouter n'est pas supérieure à la date 
					 * courante dans le tableau on ne fait rien sinon on l'ajoute à l'emplacement i et non i+1
					 */
					if(cartes[i].getDate() >= c.getDate()){ 
						p.ajouterCarte(c,i-1); //ajoute la carte à l'emplacement i
						arret = true; // arrête la boucle

					}
					i++;
				}
			}
			cartes = p.getCartes(); //réaffecte le paquet à l'attribut cartes
			
		}
		else{
			cartes = new Carte[1]; //le tableau de carte prend comme longueur 1
			cartes[0] = c;
		}
	}

	/**
	 * Méthode qui permet de vérifier si une carte peut s'insérer après une place selon l'ordre de la frise
	 * @param c carte en question à vérifier
	 * @param place place après laquelle on veut vérifier
	 */
	public boolean verifierCarteApres(Carte c,int place){
		if(cartes.length == 0)
			return (place == -1);
		else if(place == -1)
			return (c.getDate() <= cartes[place+1].getDate());
		else if(place == cartes.length-1) //si la place est égale à la dernière place du tableau de cartes
			return (cartes[place].getDate() <= c.getDate());
		else{
			if(0<=place && place < cartes.length-1)
				return (cartes[place].getDate() <= c.getDate() && c.getDate() <= cartes[place+1].getDate());
			else
				return false;
		}

	}

	/**
	 * Méthode qui permet d'ajouter une carte après une place selon l'ordre de la frise et l'ajoute si et seulement
	 * si elle est à la bonne place
	 * @param c carte en question à insérer
	 * @param palce place après laquelle on veut insérer
	 */
	public boolean ajouterCarteApres(Carte c,int place){
		if(c.getDateVisible() == false) //retourne la carte si la date n'est pas visible
			c.retournerCarte();

		if(verifierCarteApres(c,place)){ //verifie si on peut l'insérer après cette place

			Paquet p = new Paquet(cartes); //utilise la classe paquet pour insérer une carte
			p.ajouterCarte(c,place); //insérer la carte en question à la place voulu
			cartes = p.getCartes(); //récupére le tableau de cartes après insertion
			return true;

		}
		else
			return false;


	}



	/**
	 * Récupére une chaîne de caractère pour pouvoir afficher la frise
	 */
	public String toString(){
		Paquet p = new Paquet(cartes); //on réutilise la méthode toString de la classe Paquet
		return p.toString();
	}

}