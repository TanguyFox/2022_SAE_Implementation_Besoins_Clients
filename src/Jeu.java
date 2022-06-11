
import java.util.Scanner;
/**
 * Descriptif de la classe Jeu:
 * Permet de jouer seule au jeu Timeline 
 */
class Jeu{
	/**
	 * Attributs:
	 */
	//frise du jeu
	private Frise frise;

	//main du joueur et pioche à disposition
	private Paquet mainJoueur , pioche;

	//score du joueur
	private int score;


	/**
	 * Constructeur qui initialise la pioche, la main du joueur et la frise
	 * @param tailleMain la taille de la main du joueur
	 * @param nomFichierCartes nom du fichier où sont les cartes du jeu
	 */
	public Jeu(int tailleMain,String nomFichierCartes){

		pioche = new Paquet(nomFichierCartes); //création de la pioche via le fichier
		mainJoueur = new Paquet(); //création de la main du joueur
		frise = new Frise();//création de la frise
		this.score = 0;

		for(int i=0;i<tailleMain;i++){
			mainJoueur.ajouterCarteFin(pioche.piocherHasard()); //pioche n cartes pour la main du joueur
		}

	}

	/**
	 * Méthode qui permet de choisir une carte de la main du joueur
	 */
	public int choisirCarte(){
		Scanner input = new Scanner(System.in);

		System.out.println("Quelle carte de votre main ?");

		int indiceCarteMain = input.nextInt();//initialisation de l'indice de la carte choisie à partir de la saisie utilisateur

		while(indiceCarteMain < 0 || mainJoueur.getNbCartes()-1 < indiceCarteMain){
			/**
			 * tant que l'indice n'appartient pas au paquet de cartes cela redemande l'indice
			 */
			System.out.println("La carte n'est pas comprise entre 0 et "+ (mainJoueur.getNbCartes()-1));
			System.out.println("Veuillez resaisir l'indice de la carte !");
			indiceCarteMain = input.nextInt();//saisie utilisateur

		}

		System.out.println(mainJoueur.getCarte(indiceCarteMain));//affiche la carte choisie

		return indiceCarteMain;
	}


	/**
	 * Méthode qui permet de choisir un emplacement dans la frise
	 */
	public int choisirApresCarte(){

		Scanner input = new Scanner(System.in);
		System.out.println("Derrière quelle carte de la frise ? (-1 pour mettre avant la première carte)");

		int indiceFrise = input.nextInt();//initialisation par la saisie utilisateur

		while(indiceFrise < -1 || frise.getNbCartes()-1 < indiceFrise ){
			/**
			 * tant que l'indice n'appartient pas à la frise cela redemande l'indice
			 */
			System.out.println("L'indice n'est pas compris entre -1 et "+ (frise.getNbCartes()-1));
			System.out.println("Veuillez resaisir l'indice !");
			indiceFrise = input.nextInt();//saisie utilisateur

		}

		int length = frise.getNbCartes();//nombre de cartes dans la frise
		Carte[] cartesFrise = frise.getCartes();

		if(length==0)
			System.out.println("Première carte à placer");
		else if(indiceFrise == -1)
			System.out.println("Avant la carte :\n\t- "+cartesFrise[0]);
		else if(length-1 == indiceFrise)
			System.out.println("Après la carte :\n\t- "+cartesFrise[length-1]);
		else
			System.out.println("entre ...\n\t- "+cartesFrise[indiceFrise]+"\n\t- "+cartesFrise[indiceFrise+1]);
		

		return indiceFrise;
	}

	/**
	 * Permet de jouer la carte choisie à l'emplacement choisie dans la frise
	 */
	public void jouerCarte(int indiceCarte, int indiceFrise){

		Carte c = mainJoueur.getCarte(indiceCarte);
		c.retournerCarte();//permet de voir la date

		System.out.println("- carte jouée : "+c);//on affiche la carte pour voir la date

		//ajoute la carte si celle ci est au bonne endroit sinon non
		boolean ajout = frise.ajouterCarteApres(mainJoueur.getCarte(indiceCarte),indiceFrise);
		

		if(ajout){
			mainJoueur.retirerCarte(indiceCarte); //si l'ajout a eu lieu on la retire de la main du joueur
			System.out.println("!!! Une carte de placee !!!");//on signale au joueur qu'il a reussi à placer une carte
			
		}
		else{
			mainJoueur.retirerCarte(indiceCarte);//la carte est défaussé
			System.out.println("Pioche une carte");
			mainJoueur.ajouterCarteFin(pioche.piocherHasard());//on pioche une carte au hasard dans la pioche
		}
		this.score=this.score+1;
	}

	/**
	 * Accesseurs
	 */
	public Frise getFrise(){
		return frise;
	}

	public Paquet getMainJoueur(){
		return mainJoueur;
	}

	public Paquet getPioche(){
		return pioche;
	}


	/**
	 * Permet de pouvoir afficher la frise puis la main du joueur
	 * @return un String
	 */
	public String toString(){
		return "--------------------------\nfrise\n" + frise.toString() + "\nmain du joueur\n" + mainJoueur.toString();
	}

	/**
	 * permet de récupérer le score du joueur
	 * @return un entier int
	 */
	public int getScore(){
		return this.score;
	}

}