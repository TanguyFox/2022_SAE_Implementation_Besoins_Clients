/**
 * Descriptif de la classe Paquet:
 * Permet de créer un paquet de cartes
 * On peut retirer, ajouter et picoher au hasard des cartes
 * 
 */
class Paquet{
	/**
	 * Attributs :
	 * Déclaration du paquet de cartes qui est un tableau de cartes
	 */
	private Carte[] cartes;



	/**
	 * Constructeurs:
	 */
	/** 
	 * Constructeur vide qui initialise le tableau à une longueur de 0
	 * 
	 */
	public Paquet(){
		cartes = new Carte[0];
	}

	/**
	 * Constructeur qui prend en paramètre un un tableau de cartes et qui le recopie
	 * @param pCartes tableau de cartes à copier
	 */
	public Paquet(Carte[] pCartes){
		this.cartes = new Carte[pCartes.length];
		this.cartes = pCartes;

	}
	/**
	 * Extrait les cartes d'un fichier
	 * @param nomFichier nom du fichier en question dont-il faut extraire les cartes
	 */
	public Paquet(String nomFichier){

		LectureFichier fichier = new LectureFichier(nomFichier); //lecture du fichier
		String[] cartesString = fichier.lireFichier();			 //lecture des chaines de caractères
		cartes = new Carte[cartesString.length];				 //définition de la taille du tableau
		for(int i =0;i<cartesString.length;i++){
			cartes[i] = new Carte(cartesString[i]);				 //convertion des chaines de caractères en Carte
		}

	}




	/**
	 * Accesseurs:
	 */
	/**
	 * @param place de la carte qu'on souhaite obtenir
	 * @return null si la place n'est pas comprise dans le tableau
	 * 		   sinon la carte en question
	 */
	public Carte getCarte(int place){
		
		if (-1< place && place < this.getNbCartes())
			return cartes[place];
		else
			return null;
	}

	/**
	 * @return le paquet de carte
	 */
	public Carte[] getCartes(){
		return cartes;
	}




	/**
	 * Méthodes :
	 */

	/**
	 * @return le nombre de cartes présentent dans le paquet
	 */
	public int getNbCartes(){
		return cartes.length;
	}

	/**
	 * Ajoute une carte à la fin du paquet
	 * @param pCarte la carte qu'on ajoute à la fin du paquet
	 */
	public void ajouterCarteFin(Carte pCarte){
		/*
		1.Créer une variable temporaire pour stocker les cartes pour que
		  	augmenter la taille du tableau 
		2.Incrémente la taille du paquet de 1
		3.Place la carte à la derniere place
		4.On recopie le tableau qu'on a stocké temporairement
		*/

		Carte[] tempo = cartes; 
		cartes = new Carte[this.getNbCartes()+1]; 
		cartes[this.getNbCartes()-1] = pCarte;	

		for(int i =0;i<this.getNbCartes()-1;i++){
			cartes[i] = tempo[i];
		}
	}


	/**
	 * Retire une carte à l'indice place
	 * @param place indice de la carte à retirer
	 */
	public void retirerCarte(int place){

		/**
		 0.Test si place est à l'intérieur du tableau
		 1.On stocke temporairement le tableau de carte
		 2.On reduit la taille du tableau de -1
		 3.On recopie les cartes de 0 jusqu a la place-1
		 4.On recopie les cartes de place+1 jusqu a la fin
		 */
		 if(-1< place && place < this.getNbCartes()){
			Carte[] tempo = cartes;
			cartes = new Carte[this.getNbCartes()-1];
			
			
			for(int i =0;i<place;i++){
				cartes[i] = tempo[i];
			}
			for(int j =place+1;j<tempo.length;j++){
				cartes[j-1] = tempo[j];
			}
		}

	}


	/**
	 * Ajoute une carte au debut du tableau
	 * @param pCarte la carte à ajouter
	 */
	public void ajouterCarteDebut(Carte pCarte){
		/**
		 1.On stocke temporairement le tableau de carte
		 2.On augmente la taille du tableau de +1
		 3.On place la carte à l'indice 0
		 4.On recopie le tableau stocké temporairement
		 */
		Carte[] tempo = cartes;
		cartes = new Carte[this.getNbCartes()+1];
		cartes[0] = pCarte;

		for(int i =0;i<this.getNbCartes()-1;i++){
			cartes[i+1] = tempo[i];
		}
	}	


	/**
	 * Ajoute une carte à l'indice place + 1 
	 * @param pCarte carte à ajouter
	 * @param place indice+1 auquel on veut ajouter une carte
	 */
	public void ajouterCarte(Carte pCarte,int place){

		/**
		 0.Test si place est à l'intérieur du tableau
		 1.On stocke temporairement le tableau de carte
		 2.On augmente la taille du tableau de +1
		 3.On place la carte à l'indice place+1
		 4.On recopie le tableau stocké temporairement
		 */
		if(getNbCartes() == 0)
			ajouterCarteDebut(pCarte);
		else if(-2< place && place < this.getNbCartes()){
			Carte[] tempo = cartes;
			cartes = new Carte[this.getNbCartes()+1];
			cartes[place+1] = pCarte;

			for (int i=0;i<place+1;i++){
				cartes[i] = tempo[i];
			}

			for (int j=place+1;j<this.getNbCartes()-1;j++){
				cartes[j+1] = tempo[j];
			}
		}
	}


	/**
	 * Permet d'afficher le paquet de cartes
	 * @return un String
	 */
	public String toString(){
		String s="--------------------------\n";

		for (int i =0;i<getNbCartes();i++){
			s+= i + ". carte(" + cartes[i] + ")\n";
		}
		s+="--------------------------";
		return s;
	}


	/**
	 * Permet de piocher une carte au hasard
	 * @return une carte pioché au hasard
	 */
	public Carte piocherHasard(){
		if(cartes.length != 0){
			int place = (int) Math.round((cartes.length-1)*(Math.random()));
			Carte carte = cartes[place];
			retirerCarte(place);
			return carte;
		}
		else
			return null;
	}
}